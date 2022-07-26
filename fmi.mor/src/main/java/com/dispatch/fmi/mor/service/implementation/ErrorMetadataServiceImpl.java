package com.dispatch.fmi.mor.service.implementation;
 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
import com.dispatch.fmi.mor.service.ErrorMetadataServices;

import com.dispatch.fmi.mor.repository.ErrorMetadataRepository;
 
@Service
public class ErrorMetadataServiceImpl
    implements ErrorMetadataServices {
   
    @Autowired private ErrorMetadataRepository errMetadataRepo;

 
    
    /** 
     * @return ErrorMetadataEntity
     */
    @Override public ErrorMetadataEntity getByErrorCode(int errorCode)
    {
        Optional<ErrorMetadataEntity> optional = errMetadataRepo.findById(errorCode);
        ErrorMetadataEntity errorMetadataEntity = null;
        if (optional.isPresent())
            errorMetadataEntity = optional.get();
        else
            throw new RuntimeException(
                "Error not found for error id : " + errorCode);
        return errorMetadataEntity;
    }

    @Override public void save(ErrorMetadataEntity errMetadata){
        errMetadata.setIsTypeOther(true);
        errMetadataRepo.save(errMetadata);
    }
    
    @Override public void deleteById(int errorCode){
        errMetadataRepo.deleteById(errorCode);
    }
    
    /** 
     * @return List<ErrorMetadataEntity>
     */
    @Override public List<ErrorMetadataEntity> getAllErrorMetadata()
    {
        return errMetadataRepo.findAll();
    }

    @Override
    public Optional<ErrorMetadataEntity> findById(int errorCode) {
        return errMetadataRepo.findById(errorCode);
    }

    @Override
    public List<ErrorMetadataEntity> findAll() {
        return errMetadataRepo.findAll();
    }

    @Override
    public List<ErrorMetadataEntity> findAllByErrorCode(List<Integer> errorCodes) {
        return errMetadataRepo.findAllByErrorCode(errorCodes);
    }

    @Override
    public void update(ErrorMetadataEntity oldEntity) {
        Integer oldErrorCode=oldEntity.getErrorCode();
        errMetadataRepo.deleteById(oldErrorCode);      
        errMetadataRepo.save(oldEntity);
    }
}
    