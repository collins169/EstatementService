using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Reporting.WinForms;
//using Oracle.DataAccess.Client;
//using Oracle.DataAccess.Client;
using System.Data;
using System.Drawing.Printing;
using System.IO;
using System.Windows.Forms;
using PdfSharp;
using PdfSharp.Pdf;
using PdfSharp.Pdf.IO;
using PdfSharp.Pdf.Security;
using FasylStatementLibrary.Models;
using Newtonsoft.Json;

namespace FasylStatementLibrary
{
    public class StatementGenerator
    {

        public string GenerateStatement(string custId, string CustomerInfo, string Transactions, TransactionStatistics statistics, SttbScheduledStatements statement)
        {
            try
            {
                List<CustomerInformation> CustomerInformations = JsonConvert.DeserializeObject<List<CustomerInformation>>(CustomerInfo);
                List<TransactionHistory> TransactionHistories = JsonConvert.DeserializeObject<List<TransactionHistory>>(Transactions);
                String v_mimetype;
                String v_encoding;
                String v_filename_extension;
                String[] v_streamids;
                Microsoft.Reporting.WinForms.Warning[] warnings;

                ReportViewer reportViewer1 = new ReportViewer();
                reportViewer1.LocalReport.ReportPath = @"C:\eaes\config\Report1.rdlc";
                reportViewer1.RefreshReport();


                //lets get the custid 
                //string custId = acctNo.Substring(6, 6);
                //string custId = acctNo.Substring(4, 6);

                DataSet ds = new DataSet();
                ds = GetCustomerInformation(CustomerInformations);
                //
                GenerateAndSaveStatementsForAllAccounts(custId, TransactionHistories, statement.stmntType);

                DataSet ds4 = new DataSet();
                ds4 = GetChannelCountsAndPercentages(statistics);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    ReportDataSource rds = new ReportDataSource("DataSet1", ds.Tables[0]);
                    reportViewer1.LocalReport.DataSources.Clear();
                    reportViewer1.LocalReport.DataSources.Add(rds);

                    //this last Dataset5 is for the channels with totals
                    ReportDataSource rds5 = new ReportDataSource("DataSet2", ds4.Tables[0]);
                    reportViewer1.LocalReport.DataSources.Add(rds5);

                }

                byte[] byteViewer = reportViewer1.LocalReport.Render("PDF", null, out v_mimetype, out v_encoding, out v_filename_extension, out v_streamids, out warnings);

                string month = DateTime.Now.ToString("MMM");
                string path = @"C:\eaes\statementPdf\" + month + "\\" + statement.stmntType + "\\" + custId + "\\";
                DirectoryInfo dI = new DirectoryInfo(path);
                if (!dI.Exists) { dI.Create(); }

                //lets dispose the reportviewer1 here
                reportViewer1.Dispose();

                FileStream newFile = new FileStream(path + statement.acNo + "1.pdf", FileMode.Create);
                newFile.Write(byteViewer, 0, byteViewer.Length);
                newFile.Close();
                newFile.Dispose();

                //now lets loop through the path and add merge all the pdfs into 1
                DirectoryInfo d = new DirectoryInfo(path);
                PdfDocument pdfDoc = new PdfDocument();
                foreach (FileInfo f in d.GetFiles().OrderByDescending(f => f.CreationTime))
                {
                    //logger.Info("file no => " + f.Name);
                    //merging the varios pdfs...
                    using (PdfDocument pd = PdfReader.Open(path + f.Name, PdfDocumentOpenMode.Import))
                    {
                        CopyPages(pd, pdfDoc);
                    }
                }
                //since we have finished merging everything, lets save it
                pdfDoc.Save(path + statement.acNo + ".pdf");
                pdfDoc.Close();

                //lets assume that at this time, we have created the pdf
                //we now need to put a password on the pdf file
                //i hope it does not bomb at this stage.
                PdfDocument doc = PdfReader.Open(path + statement.acNo + ".pdf");
                PdfSecuritySettings securitySettings = doc.SecuritySettings;
                securitySettings.UserPassword = statement.stmtPass == null ? custId : statement.stmtPass;
                securitySettings.OwnerPassword = statement.stmtPass == null ? custId : statement.stmtPass;

                //securitySettings.DocumentSecurityLevel = PdfDocumentSecurityLevel.Encrypted40Bit;

                //aditional settings
                securitySettings.PermitAccessibilityExtractContent = false;
                securitySettings.PermitAnnotations = false;
                securitySettings.PermitAssembleDocument = false;
                securitySettings.PermitExtractContent = false;
                securitySettings.PermitFormsFill = false;
                securitySettings.PermitFullQualityPrint = true;
                securitySettings.PermitModifyDocument = false;
                securitySettings.PermitPrint = true;
                string Path = path + statement.acNo + ".pdf";
                doc.Save(Path);

                doc.Close();

                //now that we are done with the files, its time we delete all of them
                //except the merged 1
                removeOtherFiles(statement.acNo, custId, statement.stmntType);

                return Path;
            }
            catch (Exception ex)
            {
                //logger.Info(ex.Message, ex);
                return "";
            }
        }

        private void removeOtherFiles(string accountNumber, string custId, string type)
        {
            //string custId = accountNumber.Substring(6, 6);
            string fileName = accountNumber + ".pdf"; //accountNumber.Substring(0, 6) + "xxxxx" + accountNumber.Substring(12) + ".pdf";

            //l.Info("Cust Id : " + custId);
            string month = DateTime.Now.ToString("MMM");
            //string currentPath = String.Format("C:/eaes/statementPdf/{0}/{1}/{2}", month, type, custId);
            string path = @"C:\eaes\statementPdf\" + month + "\\" + type + "\\" + custId + "\\";
            DirectoryInfo info = new DirectoryInfo(path);
            if (!info.Exists)
            {
                return;
            }

            FileInfo[] files = info.GetFiles();

            foreach (FileInfo file in files)
            {
                //l.Info(file.Name);
                if (fileName.Trim() != file.Name.Trim())
                {
                    file.Delete();
                }
            }
        }


        private void CopyPages(PdfDocument from, PdfDocument to)
        {
            for (int i = 0; i < from.PageCount; i++)
            {
                to.AddPage(from.Pages[i]);
            }
        }

        private DataSet GetCustomerInformation(List<CustomerInformation> customerInformations)
        {
            
            //da.SelectCommand = cmd;
            DataSet ds = new DataSet();

            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[11] 
                    { 
                        new DataColumn("CUSTOMER_NAME", typeof(string)),
                        new DataColumn("CCY", typeof(string)),
                        new DataColumn("DESCRIPTION", typeof(string)) ,
                        new DataColumn("ACY_OPENING_BAL", typeof(decimal)),
                        new DataColumn("ACY_AVL_BAL", typeof(decimal)),
                        new DataColumn("CUST_AC_NO", typeof(string)) ,
                        new DataColumn("BRANCH_NAME", typeof(string)),
                        new DataColumn("BRANCH_ADDR1", typeof(string)),
                        new DataColumn("ADDRESS2", typeof(string)) ,
                        new DataColumn("ACY_TODAY_TOVER_DR", typeof(decimal)),
                        new DataColumn("ACY_TODAY_TOVER_CR", typeof(decimal))
                    });
            if (customerInformations.Count > 0)
            {
                foreach (CustomerInformation cust in customerInformations.OrderBy(x => x.Position).ToList())
                {

                    dt.Rows.Add(cust.CustomerName, cust.Ccy, cust.Description, cust.AcyOpeningBal, cust.AcyAvlbal, cust.CustAcNo, cust.BranchName, cust.BranchAddr1, cust.Address2, cust.AcyTodayToverDr, cust.AcyTodayToverCr);
                }
                ds.Tables.Add(dt);
            }

            return ds;
        }

        private DataSet GetAccountTransactionBetweenDates(List<StvwTransaction> StvwTransactions, AllCustomerAccount account)
        {

            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[17] 
                    { 
                        new DataColumn("TRN_REF_NO", typeof(string)),
                        new DataColumn("AC_ENTRY_SR_NO", typeof(decimal)),
                        new DataColumn("AC_NO", typeof(string)) ,
                        new DataColumn("AC_CCY", typeof(string)),
                        new DataColumn("DRCR_IND", typeof(string)),
                        new DataColumn("NARRATION", typeof(string)) ,
                        new DataColumn("FCY_AMOUNT", typeof(decimal)),
                        new DataColumn("LCY_AMOUNT", typeof(decimal)),
                        new DataColumn("TRN_DT", typeof(DateTime)) ,
                        new DataColumn("VALUE_DT", typeof(DateTime)),
                        new DataColumn("INSTRUMENT_CODE", typeof(string)),
                        new DataColumn("AC_DESC", typeof(string)) ,
                        new DataColumn("DESCRIPTION", typeof(string)),
                        new DataColumn("ACY_OPENING_BAL", typeof(decimal)),
                        new DataColumn("DEBITS", typeof(string)) ,
                        new DataColumn("CREDITS", typeof(string)),
                        new DataColumn("BALANCE", typeof(decimal))
                    });

            DataSet ds1 = new DataSet();

            //lets set the dataset for the account
            //dt.Rows.Add(accountNum, null, null, null, null, "Statment For ", null, null, null, null, null, null, null, null, null, null, null);
            dt.Rows.Add(null, null, null, null, null, "Balance Brought Forward", null, null, null, null, null, null, null, null, null, null, account.AcyAvlBal);


            foreach(StvwTransaction trans in StvwTransactions)
            {

                dt.Rows.Add(trans.TrnRefNo, trans.AcEntrySrNo, trans.AcNo, trans.AcCcy, trans.DrCrInd, trans.Narration, trans.FcyAmount, trans.LcyAmount, trans.TrnDt, trans.ValueDt, trans.InstrumentCode, trans.AcDesc, trans.Description, trans.AcyOpeningBal, trans.Debit, trans.Credit, trans.RunningBal);

            };

            //logger.Info("finished adding to dataset for account");
            ds1.Tables.Add(dt);
            return (ds1);
            //}
            //}
        }

        private DataSet GetAccountRunningBalance(AllCustomerAccount AllCustomerAccount)
        {
            DataSet ds1 = new DataSet();
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[5] 
                    { 
                        new DataColumn("AC_NO", typeof(string)),
                        new DataColumn("CUSTOMER_NAME", typeof(string)) ,
                        new DataColumn("PRODUCT_NAME", typeof(string)),
                        new DataColumn("CURRENCY", typeof(string)),
                        new DataColumn("OPENING_BALANCE", typeof(decimal))
                    });
            //logger.Info("AllCustomerAccounts : " + AllCustomerAccount.ToString());

            dt.Rows.Add(AllCustomerAccount.CustAcNo, AllCustomerAccount.AcDesc, AllCustomerAccount.Description, AllCustomerAccount.CcyName, AllCustomerAccount.AcyAvlBal);

            ds1.Tables.Add(dt);

            return (ds1);
        }

        private DataSet GetChannelCountsAndPercentages(TransactionStatistics stat)
        {
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[5] 
            { 
                new DataColumn("CHANNEL", typeof(string)),
                new DataColumn("NO_OF_TRANS", typeof(int)) ,
                new DataColumn("PERCENTAGE", typeof(double)),
                new DataColumn("CREDITS", typeof(decimal)),
                new DataColumn("DEBITS", typeof(decimal))
            });

            DataSet ds1 = new DataSet();

            //this is we adding the ATM channel first
            dt.Rows.Add("ATM", stat.TotalAtmTransaction, stat.TotalAtmPercent, stat.TotalAtmCredits, stat.TotalAtmDebits);
            //this is we adding the POS channel 
            dt.Rows.Add("POS", stat.TotalPosTransaction, stat.TotalPosPercent, stat.TotalPosCredits, stat.TotalPosDebits);
            //this is we adding Other channel
            dt.Rows.Add("OTHERS", stat.OthersTotalTransaction, stat.OthersTotalPercent, stat.OthersTotalCredits, stat.OthersTotalDebits);
            //this is we adding the total channel
            //dt.Rows.Add("TOTAL", totalNumOfTransaction, 100, totalCredits, totalDebits);

            ds1.Tables.Add(dt);

            return (ds1);
        }

        private void GenerateAndSaveStatementsForAllAccounts(string custId, List<TransactionHistory> TransactionHistories, String type)
        {
            //logger.Info("About to get account lists..");

            try
            {

                //logger.Info("Number of accounts found is " + TransactionHistories.Count);
                //logger.Info("about to add each account to the datasets");
                //decimal runningBalance = 0;
                string month = DateTime.Now.ToString("MMM");
                string path = @"C:\eaes\statementPdf\" + month + "\\" + type + "\\" + custId + "\\";
                int cnt = 1;
                foreach(TransactionHistory history in TransactionHistories)
                {
                    cnt++;
                    DataSet ds2 = new DataSet();
                    ds2 = GetAccountRunningBalance(history.AllCustomerAccount);
                    DataSet dscnt = new DataSet();
                    dscnt = GetAccountTransactionBetweenDates(history.StvwTransactions, history.AllCustomerAccount);
                    //DataSet ds3 = new DataSet();
                    //ds3 = GetChannelCountsAndPercentages();
                    if (dscnt.Tables[0].Rows.Count > 0)
                    {
                        String v_mimetype;
                        String v_encoding;
                        String v_filename_extension;
                        String[] v_streamids;
                        Microsoft.Reporting.WinForms.Warning[] warnings;

                        ReportViewer reportViewer1 = new ReportViewer();
                        reportViewer1.LocalReport.ReportPath = @"C:\eaes\config\Report2.rdlc";

                        reportViewer1.RefreshReport();

                        ReportDataSource rds3 = new ReportDataSource("DataSet1", dscnt.Tables[0]);
                        reportViewer1.LocalReport.DataSources.Add(rds3);

                        ReportDataSource rds2 = new ReportDataSource("DataSet2", ds2.Tables[0]);
                        reportViewer1.LocalReport.DataSources.Add(rds2);

                        //ReportDataSource rds1 = new ReportDataSource("DataSet2", ds3.Tables[0]);
                        //reportViewer1.LocalReport.DataSources.Add(rds1);

                        DirectoryInfo dI = new DirectoryInfo(path);

                        if (!dI.Exists)
                        {
                            dI.Create();
                        }


                        byte[] byteViewer = reportViewer1.LocalReport.Render("PDF", null, out v_mimetype, out v_encoding, out v_filename_extension, out v_streamids, out warnings);

                        //disposing of the reportviewer here...
                        reportViewer1.Dispose();

                        FileStream newFile = new FileStream(path + history.AllCustomerAccount.CustAcNo + cnt + ".pdf", FileMode.Create);
                        newFile.Write(byteViewer, 0, byteViewer.Length);
                        newFile.Close();
                        newFile.Dispose();
                    }
                };
            }
            catch (Exception ex) {  }
        }


        public string GenerateStatmentTest(string name)
        {
            return name + " >>>>> It worked oooo";
        }
    }
}
