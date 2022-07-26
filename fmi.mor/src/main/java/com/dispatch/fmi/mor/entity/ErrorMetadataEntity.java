//package name
package com.dispatch.fmi.mor.entity;

//imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.lang.Nullable;
 
@Entity
public class ErrorMetadataEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int errorCode;

    private String errorTitle;
	@Lob
    private String errorDescription;
    private int severity;
	private String spoc;
    private boolean isTypeOther;
	
	@Nullable
    private Integer step01;
    @Nullable
	private Integer step02;
    @Nullable
	private Integer step03;
    @Nullable
	private Integer step04;
    @Nullable
	private Integer step05;
    @Nullable
	private Integer step06;
    @Nullable
	private Integer step07;
    @Nullable
	private Integer step08;
    @Nullable
	private Integer step09;
    @Nullable
	private Integer step10;


	
	/** 
	 * @return String
	 */
	public String getSpoc() {
		return this.spoc;
	}

	
	/** 
	 * @param spoc
	 */
	public void setSpoc(String spoc) {
		this.spoc = spoc;
	}


	
	/** 
	 * @return int
	 */
	public int getErrorCode() {
		return this.errorCode;
	}

	
	/** 
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	
	/** 
	 * @return String
	 */
	public String getErrorTitle() {
		return this.errorTitle;
	}

	
	/** 
	 * @param errorTitle
	 */
	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}

	
	/** 
	 * @return String
	 */
	public String getErrorDescription() {
		return this.errorDescription;
	}

	
	/** 
	 * @param errorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	
	/** 
	 * @return int
	 */
	public int getSeverity() {
		return this.severity;
	}

	
	/** 
	 * @param severity
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isIsTypeOther() {
		return this.isTypeOther;
	}

	
	/** 
	 * @param isTypeOther
	 */
	public void setIsTypeOther(boolean isTypeOther) {
		this.isTypeOther = isTypeOther;
	}

	

	/** 
	 * @return int
	 */
	public Integer getStep01() {
		return this.step01;
	}

	
	/** 
	 * @param step01
	 */
	public void setStep01(Integer step01) {
		this.step01 = step01;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep02() {
		return this.step02;
	}

	
	/** 
	 * @param step02
	 */
	public void setStep02(Integer step02) {
		this.step02 = step02;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep03() {
		return this.step03;
	}

	
	/** 
	 * @param step03
	 */
	public void setStep03(Integer step03) {
		this.step03 = step03;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep04() {
		return this.step04;
	}

	
	/** 
	 * @param step04
	 */
	public void setStep04(Integer step04) {
		this.step04 = step04;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep05() {
		return this.step05;
	}

	
	/** 
	 * @param step05
	 */
	public void setStep05(Integer step05) {
		this.step05 = step05;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep06() {
		return this.step06;
	}

	
	/** 
	 * @param step06
	 */
	public void setStep06(Integer step06) {
		this.step06 = step06;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep07() {
		return this.step07;
	}

	
	/** 
	 * @param step07
	 */
	public void setStep07(Integer step07) {
		this.step07 = step07;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep08() {
		return this.step08;
	}

	
	/** 
	 * @param step08
	 */
	public void setStep08(Integer step08) {
		this.step08 = step08;
	}

	
	/** 
	 * @return int
	 */
	public Integer getStep09() {
		return this.step09;
	}

	
	/** 
	 * @param step09
	 */
	public void setStep09(Integer step09) {
		this.step09 = step09;
	}
	
	/** 
	 * @return int
	 */
	public Integer getStep10() {
		return this.step10;
	}

	
	/** 
	 * @param step10
	 */
	public void setStep10(Integer step10) {
		this.step10 = step10;
	}

    
    public ErrorMetadataEntity(int errorCode, String errorTitle, String errorDescription,int severity, boolean  isTypeOther, String spoc, int step01, Integer step02, Integer step03, Integer step04, Integer step05, Integer step06, Integer step07, Integer step08, Integer step09, Integer step10){        
		this.errorCode=errorCode;
        this.errorTitle=errorTitle;
        this.errorDescription=errorDescription;
        this.severity=severity;
		this.spoc=spoc;
        this.isTypeOther=isTypeOther;
        this.step01=step01;
        this.step02=step02;
        this.step03=step03;
        this.step04=step04;
        this.step05=step05;
        this.step06=step06;
        this.step07=step07;
        this.step08=step08;
        this.step09=step09;
        this.step10=step10;
    }

	public ErrorMetadataEntity(){


	}

    
}