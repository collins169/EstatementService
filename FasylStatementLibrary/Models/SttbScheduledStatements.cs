using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FasylStatementLibrary.Models
{
    public class SttbScheduledStatements
    {
        public string guid { get; set; }
        public string custNo { get; set; }
        public string acNo { get; set; }
        public Nullable<System.DateTime> startDate { get; set; }
        public Nullable<System.DateTime> endDate { get; set; }
        public string stmntType { get; set; }
        public string status { get; set; }
        public Nullable<System.DateTime> scheduleStamp { get; set; }
        public string email { get; set; }
        public string stmtPass { get; set; }
        public Nullable<System.DateTime> stmtDtSend { get; set; }
        public string pdfPath { get; set; }
    }
}