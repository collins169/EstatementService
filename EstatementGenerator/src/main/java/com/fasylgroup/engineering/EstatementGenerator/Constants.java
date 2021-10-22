package com.fasylgroup.engineering.EstatementGenerator;

public class Constants {
    public static String GetInformation = "SELECT '{0}' statement_start,\n" +
            "  '{1}' statement_end,\n" +
            "  NVL(DR_CNT,0) DR_CNT,\n" +
            "  NVL(CR_CNT,0) CR_CNT,\n" +
            "  NVL(DR_TOT,0) DR_TOT,\n" +
            "  NVL(CR_TOT,0) CR_TOT,\n" +
            "  NVL(opening_balance,0) acy_opening_balance,\n" +
            "  NVL(closing_balance,0) closing_balance,\n" +
            "  0 statement_status,\n" +
            "  a.ac_desc,\n" +
            "  a.ccy,\n" +
            "  a.acy_avl_bal,\n" +
            "  a.cust_no,\n" +
            "  (select description from sttm_account_class where account_class = a.account_class) description,\n" +
            "  a.branch_code,\n" +
            "  (select branch_name from sttm_branch where branch_code = a.branch_code) branch_name,\n" +
            "  (select branch_addr1 from sttm_branch where branch_code = a.branch_code) branch_addr1,\n" +
            "  a.address2\n" +
            "FROM STTM_CUST_ACCOUNT a\n" +
            "JOIN lmtms_liab h\n" +
            "ON a.cust_no=h.liab_id\n" +
            "LEFT JOIN\n" +
            "  (SELECT ac_no,\n" +
            "    SUM(DECODE(cod_drcr,'D',1,0)) DR_CNT,\n" +
            "    SUM(DECODE(cod_drcr,'C',1,0)) CR_CNT,\n" +
            "    SUM(DECODE(cod_drcr,'D',amt_txn,0)) DR_TOT,\n" +
            "    SUM(DECODE(cod_drcr,'C',amt_txn,0)) CR_TOT\n" +
            "  FROM\n" +
            "    (SELECT ac_no,\n" +
            "      ROUND(DECODE(ac_ccy,'GHS',lcy_amount,DECODE(trim(fcy_amount),NULL,lcy_amount/exch_rate,'',lcy_amount/exch_rate,fcy_amount)),2) amt_txn,\n" +
            "      drcr_ind cod_drcr\n" +
            "    FROM acvw_all_ac_entries\n" +
            "    WHERE trn_dt BETWEEN '{0}' AND '{1}'\n" +
            "    AND event <> 'REVL'\n" +
            "    )\n" +
            "  GROUP BY ac_no\n" +
            "  ) i\n" +
            "ON a.cust_ac_no=i.ac_no\n" +
            "LEFT JOIN\n" +
            "  (SELECT ac_no,\n" +
            "    DECODE(SUM(DECODE(cod_drcr,'D',-1,1) * amt_txn),NULL,0,SUM(DECODE(cod_drcr,'D',-1,1) * amt_txn)) opening_balance\n" +
            "  FROM\n" +
            "    (SELECT ac_no,\n" +
            "      ROUND(DECODE(ac_ccy,'GHS',lcy_amount,DECODE(trim(fcy_amount),NULL,lcy_amount/exch_rate,'',lcy_amount/exch_rate,fcy_amount)),2) amt_txn,\n" +
            "      drcr_ind cod_drcr\n" +
            "    FROM acvw_all_ac_entries\n" +
            "    WHERE trn_dt < '{0}'\n" +
            "    AND event   <> 'REVL'\n" +
            "    )\n" +
            "  GROUP BY ac_no\n" +
            "  ) j\n" +
            "ON a.cust_ac_no=j.ac_no\n" +
            "LEFT JOIN\n" +
            "  (SELECT ac_no,\n" +
            "    DECODE(SUM(DECODE(cod_drcr,'D',-1,1) * amt_txn),NULL,0,SUM(DECODE(cod_drcr,'D',-1,1) * amt_txn)) closing_balance\n" +
            "  FROM\n" +
            "    (SELECT ac_no,\n" +
            "      ROUND(DECODE(ac_ccy,'GHS',lcy_amount,DECODE(trim(fcy_amount),NULL,lcy_amount/exch_rate,'',lcy_amount/exch_rate,fcy_amount)),2) amt_txn,\n" +
            "      drcr_ind cod_drcr\n" +
            "    FROM acvw_all_ac_entries\n" +
            "    WHERE trn_dt <= '{1}'\n" +
            "    AND event    <> 'REVL'\n" +
            "    )\n" +
            "  GROUP BY ac_no\n" +
            "  ) x\n" +
            "ON a.cust_ac_no   =x.ac_no\n" +
            "WHERE a.cust_ac_no='{2}'\n" +
            "AND a.auth_stat   ='A'\n" +
            "AND h.auth_stat   ='A'\n" +
            "AND a.record_stat = 'O'";
}
