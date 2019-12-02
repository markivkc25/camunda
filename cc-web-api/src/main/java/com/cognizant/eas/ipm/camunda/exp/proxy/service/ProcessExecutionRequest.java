package com.cognizant.eas.ipm.camunda.exp.proxy.service;

public class ProcessExecutionRequest {
	
	public ProcessVariable[] getVariables() {
		return variables;
	}
	public void setVariables(ProcessVariable[] variables) {
		this.variables = variables;
	}
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	public boolean getWithVariablesInReturn() {
		return withVariablesInReturn;
	}
	public void setWithVariablesInReturn(boolean withVariablesInReturn) {
		this.withVariablesInReturn = withVariablesInReturn;
	}
	private ProcessVariable[] variables;
	private String businessKey;
	private boolean withVariablesInReturn;
	

}
