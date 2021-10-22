package com.fasylgroup.engineering.EstatementDispatcher.Repository;

import com.fasylgroup.engineering.EstatementDispatcher.Model.SttbScheduledStatements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SttbScheduledStatementsRepository extends JpaRepository<SttbScheduledStatements, String> {
    @Query(value = "SELECT a.* FROM STTB_SCHEDULED_STATMENTS_DEV a WHERE a.guid = ?1 and a.ac_no = ?2 and a.email is not null", nativeQuery = true)
    Optional<SttbScheduledStatements> findOneByGuidAndAcNo(@Param("guid") String guid, @Param("acNo") String acNo);
    List<SttbScheduledStatements> findByStatusAndPdfPathIsNotNull(String status);
}