package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import java.io.IOException;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.CurrentStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.NextStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.StageResultEnum;
import com.cognizant.eas.ipm.camunda.cc.app.service.AddressService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("addressValidator")
public class AddressValidatorDelegate implements JavaDelegate {	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";
	private final Logger LOGGER = Logger.getLogger(AddressValidatorDelegate.class.getName());		
	private ObjectMapper objectMapper=new ObjectMapper();	

	
	@Autowired
	private AddressService addressService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Entered AddressValidatorDelegate.execute");
		// Retrieve the Original Form Request Object 
		execution.setVariable("url", "");
		ApplicationForm applicationForm = getRequestObject(execution);
		// Retrieve the Previous Response Object and Modify the response
		ApplicationFormResponse applicationFormResponse = getResponseObject(execution);	
		boolean isAddressValid=false;
		execution.setVariable("isAddressValid", isAddressValid);
		if(applicationForm.getApplicant().getAddress()!=null) {
			Address addr=applicationForm.getApplicant().getAddress();
			isAddressValid=addressService.validateAddress(addr);	
			applicationFormResponse.getApplicationForm().getApplicant().setAddress(addr);
			
			if(isAddressValid){
				setProcessingStatus(applicationFormResponse,"Address Validation Succesfull");
				execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
			}
			else{
				LOGGER.info("Address is not valid.....");
				applicationFormResponse.getProcessingStatus().setMessage("Address is not Valid");
				applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
				applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
				applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERPERSONALDETAILS);
				execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
				throw new BpmnError("CC-WF-008","InvalidAddress");
				
			}
		}
		else{
			LOGGER.info("Address is not Provided by the Customer.....");
			applicationFormResponse.getProcessingStatus().setMessage("Address is not Provided");
			applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
			applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
			applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERPERSONALDETAILS);
			execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
			throw new BpmnError("CC-WF-008","InvalidAddress");
		}
		
		LOGGER.info("Entered AddressValidatorDelegate.execute");
	}
	
	/**
	 * 
	 * @param applicationFormResponse
	 * @param message
	 */
	private void setProcessingStatus(ApplicationFormResponse applicationFormResponse, String message) {
		applicationFormResponse.getProcessingStatus().setMessage(message);
		applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.PASSED);
		applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
		applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERUSERPREFERENCES);
	}
	
	/**
	 * 
	 * @param execution
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	private com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse getResponseObject(
			DelegateExecution execution) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormResponseValue = execution.getVariableTyped(APPLICATION_FORM_RESPONSE);
		ApplicationFormResponse applicationFormResponse = (ApplicationFormResponse)objectMapper.readValue(applicationFormResponseValue.getValueSerialized(),ApplicationFormResponse.class);
		return applicationFormResponse;
	}
	
	/**
	 * 
	 * @param execution
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	private com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm getRequestObject(
			DelegateExecution execution) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormValue = execution.getVariableTyped(APPLICATION_FORM);
		ApplicationForm applicationForm = (ApplicationForm)objectMapper.readValue(applicationFormValue.getValueSerialized(),ApplicationForm.class);
		return applicationForm;
	}

}
