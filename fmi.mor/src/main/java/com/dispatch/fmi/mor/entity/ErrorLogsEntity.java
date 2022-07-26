//package name
package com.dispatch.fmi.mor.entity;

//imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;
 
@Entity
public class ErrorLogsEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long errorId;
    
    
    private int errorCode;
    private Date timestamp;
    private int failureStep;

    
    public ErrorLogsEntity(long errorId, int errorCode, Date timestamp, int failureStep){
        this.errorId=errorId;
        this.errorCode=errorCode;
        this.timestamp=timestamp;
        this.failureStep=failureStep;
    }

    public ErrorLogsEntity(int errorCode, Date timestamp){
        this.errorCode=errorCode;
        this.timestamp=timestamp;
    } 


    /**
     * @return long return the errorId
     */
    public long getErrorId() {
        return errorId;
    }

    /**
     * @param errorId the errorId to set
     */
    public void setErrorId(long errorId) {
        this.errorId = errorId;
    }

    /**
     * @return int return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return Date return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return int return the failureStep
     */
    public int getFailureStep() {
        return failureStep;
    }

    /**
     * @param failureStep the failureStep to set
     */
    public void setFailureStep(int failureStep) {
        this.failureStep = failureStep;
    }

}