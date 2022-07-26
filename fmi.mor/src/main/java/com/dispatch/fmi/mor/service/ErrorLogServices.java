package com.dispatch.fmi.mor.service;
 
import com.dispatch.fmi.mor.entity.ErrorLogsEntity;
 
 
public interface ErrorLogServices {
    void save(ErrorLogsEntity errorLogEntity);

    public ErrorLogsEntity addErrorLog(int ierrorCode);
    void deleteAllInstancesOfErrorCode(int errorCode);

}