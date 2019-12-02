package com.cognizant.eas.ipm.camunda.creditscore.process.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.creditscore.LoggerDelegate;

@Service("transUnionDelegate")
public class TransUnionServiceTask implements JavaDelegate {
	
	  private final Logger LOGGER = Logger.getLogger(TransUnionServiceTask.class.getName());


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("  ... TransUnionServiceTask invoked  ");
		execution.setVariable("transUnionScore", 660);
		execution.setVariable("creditHistoryInMonths", 72);
		execution.setVariable("status", "Active");
		LOGGER.info("  ... TransUnionService Score Generated");

	}

}
