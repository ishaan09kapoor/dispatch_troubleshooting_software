//package name
package com.dispatch.fmi.mor.entity;

//imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
 
@Entity
public class StepMetadataEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int stepCode;
	@Lob
    private String stepDescription;
    private String stepType;
    private int responsibleParty;
    private boolean correctiveSteps;
    private String functionToExecute;
    private int variable01;
    private int variable02;
    private int variable03;
    private int variable04;

	public int getStepCode() {
		return this.stepCode;
	}

	public void setStepCode(int stepCode) {
		this.stepCode = stepCode;
	}

	public String getStepDescription() {
		return this.stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	public String getStepType() {
		return this.stepType;
	}

	public void setStepType(String stepType) {
		this.stepType = stepType;
	}

	public int getResponsibleParty() {
		return this.responsibleParty;
	}

	public void setResponsibleParty(int responsibleParty) {
		this.responsibleParty = responsibleParty;
	}

	public boolean isCorrectiveSteps() {
		return this.correctiveSteps;
	}

	public void setCorrectiveSteps(boolean correctiveSteps) {
		this.correctiveSteps = correctiveSteps;
	}

	public String getFunctionToExecute() {
		return this.functionToExecute;
	}

	public void setFunctionToExecute(String functionToExecute) {
		this.functionToExecute = functionToExecute;
	}

	public int getVariable01() {
		return this.variable01;
	}

	public void setVariable01(int variable01) {
		this.variable01 = variable01;
	}

	public int getVariable02() {
		return this.variable02;
	}

	public void setVariable02(int variable02) {
		this.variable02 = variable02;
	}

	public int getVariable03() {
		return this.variable03;
	}

	public void setVariable03(int variable03) {
		this.variable03 = variable03;
	}

	public int getVariable04() {
		return this.variable04;
	}

	public void setVariable04(int variable04) {
		this.variable04 = variable04;
	}

	public StepMetadataEntity(int stepCode, String stepDescription, String stepType, int responsibleParty, 
	boolean correctiveSteps, String functionToExecute, int variable01, int variable02, int variable03, int variable04){
		this.stepCode=stepCode;
		this.stepDescription=stepDescription;
		this.stepType=stepType;
		this.correctiveSteps=correctiveSteps;
		this.functionToExecute=functionToExecute;
		this.responsibleParty=responsibleParty;
		this.variable01=variable01;
		this.variable02=variable02;
		this.variable03=variable03;
		this.variable04=variable04;
	}

	public StepMetadataEntity(){
		
	}
    
}