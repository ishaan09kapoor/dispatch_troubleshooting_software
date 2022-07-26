
package com.dispatch.fmi.mor.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.dispatch.fmi.mor.entity.StepMetadataEntity;
 
@Repository
public interface StepMetadataRepository extends JpaRepository<StepMetadataEntity,Integer> {
 
}