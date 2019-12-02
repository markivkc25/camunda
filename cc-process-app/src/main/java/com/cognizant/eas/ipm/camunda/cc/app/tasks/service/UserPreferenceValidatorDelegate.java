package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import java.io.IOException;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.CurrentStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.NextStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.StageResultEnum;
import com.cognizant.eas.ipm.camunda.cc.app.service.UserPreferenceService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("userPreferenceValidator")
public class UserPreferenceValidatorDelegate implements TaskListener {
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";
	private final Logger LOGGER = Logger.getLogger(UserPreferenceValidatorDelegate.class.getName());
	
	@Autowired
	private UserPreferenceService userPreferenceService;
	
	private ObjectMapper objectMapper=new ObjectMapper();

	@Override
	public void notify(DelegateTask task){
		LOGGER.info("Entered UserPreferenceValidatorDelegate.execute");
		// Retrieve the Original Form Request Object 
		ApplicationForm applicationForm = new ApplicationForm();
		try {
			applicationForm = getRequestObject(task);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Retrieve the Previous Response Object and Modify the response
		ApplicationFormResponse applicationFormResponse = new ApplicationFormResponse();
		try {
			applicationFormResponse = getResponseObject(task);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		validateUserPreference(applicationForm, applicationFormResponse, task);
		// Retrieve the Previous and Modify the response Response Object and Set in Context
		task.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);

	}
	
	/**
	 * 
	 * @param applicationForm
	 * @param applicationFormResponse
	 * @param task
	 */
	private void validateUserPreference(ApplicationForm applicationForm, ApplicationFormResponse applicationFormResponse, DelegateTask task) {
		if(applicationForm.getApplicant().getUserOptions()!=null) {
			boolean userPreferenceValid=false;
			LOGGER.info("User Preference provided");
			// Retrieve the Original Form Request Object 
			userPreferenceValid=userPreferenceService.validateUserPreference(applicationForm.getApplicant().getUserOptions());
			if(!userPreferenceValid) {
				LOGGER.info("User Preference Validation not Success.....");
				applicationFormResponse.getProcessingStatus().setMessage("Terms and Conditions not Accepted");
				applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
				applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERUSERPREFERENCES);
				applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERUSERPREFERENCES);
				task.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
				throw new BpmnError("CC-WF-004","InvalidUserPreferences");
			}else {
				setProcessingStatus(applicationFormResponse,"User Preference Validation Successful");
			}			
		}else {
			setProcessingStatus(applicationFormResponse,"User Preference Not Provided");
		}
	}
	/**
	 * 
	 * @param applicationFormResponse
	 * @param message
	 */
	private void setProcessingStatus(ApplicationFormResponse applicationFormResponse, String message) {
		applicationFormResponse.getProcessingStatus().setMessage(message);
		applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.PASSED);
		applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERUSERPREFERENCES);
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
			DelegateTask task) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormResponseValue = task.getVariableTyped(APPLICATION_FORM_RESPONSE);
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
			DelegateTask task) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormValue = task.getVariableTyped(APPLICATION_FORM);
		ApplicationForm applicationForm = (ApplicationForm)objectMapper.readValue(applicationFormValue.getValueSerialized(),ApplicationForm.class);
		return applicationForm;
	}

}
