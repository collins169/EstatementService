package com.fasylgroup.engineering.EstatementDispatcher.Repository;

import com.fasylgroup.engineering.EstatementDispatcher.Model.StvwTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StvwTransactionRepository extends JpaRepository<StvwTransaction, Long> {

    @Query(value = "SELECT a.* FROM stvw_transactions2 a WHERE a.TRN_DT BETWEEN ?1 AND ?2 AND a.AC_NO = ?3 ORDER BY a.AC_ENTRY_SR_NO ASC", nativeQuery = true)
    List<StvwTransaction> getAllTransactionByDateAndAcNo(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("acNo") String acNo);
}