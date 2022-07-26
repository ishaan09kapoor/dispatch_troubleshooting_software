
package com.dispatch.fmi.mor.repository;
 
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
 
@Repository
public interface ErrorMetadataRepository extends JpaRepository<ErrorMetadataEntity,Integer> {

    @Query("select e from ErrorMetadataEntity e where e.errorCode in :errorCodes")
    List<ErrorMetadataEntity> findAllByErrorCode(@Param("errorCodes") List<Integer> errorCodes);
    
}