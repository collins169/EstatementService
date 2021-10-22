using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FasylStatementLibrary.Models
{
    public class CustomerInformation
    {
        public int Position { get; set; }
        public string CustomerName { get; set; }
        public string Ccy { get; set; }
        public string Description { get; set; }
        public double AcyOpeningBal { get; set; }
        public double AcyAvlbal { get; set; }
        public string CustAcNo { get; set; }
        public string CustNo { get; set; }
        public string BranchCode { get; set; }
        public string BranchName { get; set; }
        public string BranchAddr1 { get; set; }
        public string Address2 { get; set; }
        public double AcyTodayToverDr { get; set; }
        public double AcyTodayToverCr { get; set; }
    }
}