package com.dispatch.fmi.mor.service;
 
import java.util.List;
import java.util.Optional;

import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
 
 
public interface ErrorMetadataServices {
    ErrorMetadataEntity getByErrorCode(int errorCode);
    List<ErrorMetadataEntity> getAllErrorMetadata();
    void save(ErrorMetadataEntity errorMetadataEntity);
    void deleteById(int errorCode);
    Optional<ErrorMetadataEntity> findById(int errorCode);
    List<ErrorMetadataEntity> findAll();
    List<ErrorMetadataEntity> findAllByErrorCode(List<Integer> errorCodes);
    void update(ErrorMetadataEntity oldEntity);
    
}