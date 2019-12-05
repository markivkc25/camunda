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

@Service("userTaskVariableInitializer")
public class CaptureCustomerStartFormUserTask implements TaskListener {
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";


	private final Logger LOGGER = Logger.getLogger(CaptureCustomerStartFormUserTask.class.getName());
	private ObjectMapper objectMapper=new ObjectMapper();

	@Override
	public void notify(DelegateTask task) {
		LOGGER.info("ExecutionListener Invoked:");
		LOGGER.info("Credit Card Application Request Recieved:");		
		//Initialize the Response Object Form
		ApplicationFormResponse applicationFormResponse = new ApplicationFormResponse();
		//Initialize the Processing Status Form
		ProcessingStatus processingStatus=new ProcessingStatus();
		processingStatus.currentStage(CurrentStageEnum.ENTERCUSTOMERDETAILS);
		processingStatus.nextStage(NextStageEnum.ENTERPERSONALDETAILS);
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
		//Default Variables
		task.setVariable("hasPromoCode", false);
		task.setVariable("isExistingCustomer", false);
		task.setVariable("ValidationStatus", "InComplete");
		if(applicationForm!=null && applicationForm.getReference()!=null && applicationForm.getReference().getPromoCode()!=null) {
			String promoCode=applicationForm.getReference().getPromoCode();
			task.setVariable("promoCode", promoCode);	
			task.setVariable("hasPromoCode", true);
			LOGGER.info("Credit Card Application Form generated for promoCode"+promoCode);
		}
		
		if(applicationForm!=null && applicationForm.isExistingCustomer()) {
			boolean isExistingCustomer=applicationForm.isExistingCustomer();
			task.setVariable("isExistingCustomer", isExistingCustomer);
			LOGGER.info("Credit Card Application Form generated for ExistingCustomer:"+isExistingCustomer);
		}
			
		ObjectValue applicationFormJson =Variables.objectValue(applicationFormResponse).serializationDataFormat("application/json").create();		
		task.setVariable(APPLICATION_FORM_RESPONSE, applicationFormJson);
		
		LOGGER.info("Credit Card Application Form generated with the unique id"+task.getProcessInstanceId());
		
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
