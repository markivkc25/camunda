package com.cognizant.eas.ipm.camunda.cc.app.listeners.task;

import java.io.IOException;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.CurrentStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.NextStageEnum;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("personalDetailsUserTask")
public class CaptureCustomerPersonalDetailsUserTask implements TaskListener {
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";


	private final Logger LOGGER = Logger.getLogger(CaptureCustomerPersonalDetailsUserTask.class.getName());
	private ObjectMapper objectMapper=new ObjectMapper();

	@Override
	public void notify(DelegateTask task) {
		LOGGER.info("Personal Details TaskListener Invoked:");
		LOGGER.info("Customer's Personal Details Recieved:");
		task.setVariable("ValidationStatus", "InComplete");
		//Initialize the Response Object Form
		ApplicationFormResponse applicationFormResponse = new ApplicationFormResponse();
		//Initialize the Processing Status Form
		ProcessingStatus processingStatus=new ProcessingStatus();
		processingStatus.currentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
		processingStatus.nextStage(NextStageEnum.ENTERUSERPREFERENCES);
		applicationFormResponse.setProcessingStatus(processingStatus);
		applicationFormResponse.setApplicationId(task.getProcessInstanceId());
		
		com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm applicationForm=null;;
		try {
			applicationForm = getRequestObject(task);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		applicationFormResponse.setApplicationForm(applicationForm);
		
		if(applicationForm!=null && applicationForm.getApplicant()!=null && applicationForm.getApplicant().getSsn()!=null) {
			String ssn=applicationForm.getApplicant().getSsn();
			task.setVariable("ssn", ssn);
		}
			
		ObjectValue applicationFormJson =Variables.objectValue(applicationFormResponse).serializationDataFormat("application/json").create();		
		task.setVariable(APPLICATION_FORM_RESPONSE, applicationFormJson);
		
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
