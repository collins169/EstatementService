using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FasylStatementLibrary.Models
{
    public class TransactionStatistics
    {
        public int TotalNumOfTransaction { get; set; }
        public double TotalCredits { get; set; }
        public double TotalDebits { get; set; }
        public int TotalAtmTransaction { get; set; }
        public double TotalAtmCredits { get; set; }
        public double TotalAtmDebits { get; set; }
        public double TotalAtmPercent { get; set; }
        public int TotalPosTransaction { get; set; }
        public double TotalPosCredits { get; set; }
        public double TotalPosDebits { get; set; }
        public double TotalPosPercent { get; set; }
        public int OthersTotalTransaction { get; set; }
        public double OthersTotalCredits { get; set; }
        public double OthersTotalDebits { get; set; }
        public double OthersTotalPercent { get; set; }
    }
}