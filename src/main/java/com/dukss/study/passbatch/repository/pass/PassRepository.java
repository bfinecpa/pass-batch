package com.dukss.study.passbatch.repository.pass;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE PassEntity p" +
        "          SET p.remainingCount = :remainingCount," +
        "              p.modifiedAt = CURRENT_TIMESTAMP" +
        "        WHERE p.passSeq = :passSeq")
    int updateRemainingCount(Integer passSeq, Integer remainingCount);
}
