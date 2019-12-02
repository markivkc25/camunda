package com.cognizant.eas.ipm.camunda.creditscore.process.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("equifaxDelegate")
public class EquifaxServiceTask implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(EquifaxServiceTask.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("  ... EquifaxServiceTask invoked  ");
		execution.setVariable("equifaxScore", 640);
		LOGGER.info("  ... EquifaxServiceTask Score Generated");

	}

}
