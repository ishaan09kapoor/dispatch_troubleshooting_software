
package com.dispatch.fmi.mor.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dispatch.fmi.mor.entity.ErrorLogsEntity;
 
@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLogsEntity,Long> {
    
    @Transactional
    @Modifying
    @Query("delete from ErrorLogsEntity e where e.errorCode=:errorCode")
    void removeByErrorCode(@Param("errorCode") int errorCode);
}