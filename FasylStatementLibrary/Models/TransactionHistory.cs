using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FasylStatementLibrary.Models
{
    public class TransactionHistory
    {
        public AllCustomerAccount AllCustomerAccount { get; set; }
        public List<StvwTransaction> StvwTransactions { get; set; }
    }
}