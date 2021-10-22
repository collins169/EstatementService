using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FasylStatementLibrary.Models
{
    public class StvwTransaction
    {
        public string TrnRefNo { get; set; }
        public string AcEntrySrNo { get; set; }
        public string AcNo { get; set; }
        public string AcCcy { get; set; }
        public string DrCrInd { get; set; }
        public string Narration { get; set; }
        public double FcyAmount { get; set; }
        public double LcyAmount { get; set; }
        public System.DateTime TrnDt { get; set; }
        public System.DateTime ValueDt { get; set; }
        public string InstrumentCode { get; set; }
        public string AcDesc { get; set; }
        public string Description { get; set; }
        public double AcyOpeningBal { get; set; }
        public double Debit { get; set; }
        public double Credit { get; set; }
        public string RunningBal { get; set; }
        public double Amount { get; set; }
    }
}