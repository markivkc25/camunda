package com.cognizant.eas.ipm.camunda.cc.app.listeners.execution;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Reference;

@Service("variablesInitializerExecutionListener")
public class VariablesInitializerExecutionListener implements ExecutionListener {

	private final Logger LOGGER = Logger.getLogger(VariablesInitializerExecutionListener.class.getName());


	@Override
	public void notify(DelegateExecution execution) throws Exception {
		LOGGER.info("-----------------------ExecutionListener Invoked:-----------------");
		LOGGER.info("-----------------------Credit Card Application Request Recieved:----------");		
		//Duration Format: P3Y6M4DT12H30M5S - three years, six months, four days, twelve hours, thirty minutes, and five seconds
		execution.setVariable("duration", "PT30M");
		//Initialize the Request Form
		ApplicationForm applicationForm = new ApplicationForm();
		Reference reference = new Reference();
		reference.setApplicationIdentifier(execution.getProcessInstanceId());
		applicationForm.isExistingCustomer(false);
		applicationForm.setReference(reference);
		ObjectValue applicationFormJson =Variables.objectValue(applicationForm).serializationDataFormat("application/json").create();
		execution.setVariable("applicationForm", applicationFormJson);

		LOGGER.info("------------------Credit Card Application Form generated with the unique id:------------------"+execution.getProcessInstanceId());
		
		
	}

}
