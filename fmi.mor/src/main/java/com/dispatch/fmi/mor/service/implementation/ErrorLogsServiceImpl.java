package com.dispatch.fmi.mor.service.implementation;
 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dispatch.fmi.mor.entity.ErrorLogsEntity;
import com.dispatch.fmi.mor.service.ErrorLogServices;
import com.dispatch.fmi.mor.repository.ErrorLogRepository;
 
@Service
public class ErrorLogsServiceImpl
    implements ErrorLogServices {
   
    @Autowired private ErrorLogRepository errLogRepo;

 
    @Override public void save(ErrorLogsEntity errLog){
        errLogRepo.save(errLog);
    }

    
    /** 
     * @param errorCode
     * @return ErrorLogsEntity
     */
    public ErrorLogsEntity addErrorLog(int errorCode){
        Date date = new Date();
        ErrorLogsEntity errorLogsEntity=new ErrorLogsEntity(errorCode, date);
        save(errorLogsEntity);
        return errorLogsEntity;
    }

    @Override public void deleteAllInstancesOfErrorCode(int errorCode){
        errLogRepo.removeByErrorCode(errorCode);
    }

}