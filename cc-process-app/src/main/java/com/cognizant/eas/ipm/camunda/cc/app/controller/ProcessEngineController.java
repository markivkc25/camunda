package com.cognizant.eas.ipm.camunda.cc.app.controller;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;

@RestController
public class ProcessEngineController {

	private final Logger LOGGER = Logger.getLogger(ProcessEngineController.class.getName());

	@Autowired
	private RuntimeService runtimeService;

	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("/user-task/submit")
	public ResponseEntity<ApplicationFormResponse> completeTaskWithValidation(@RequestParam("processinstanceid")String processInstanceId) {			
		// Get the Task Id
		LOGGER.info("processInstanceId-"+processInstanceId);
		String validationStatus = "";
		boolean timeOutOccured=false;
		// Keep Looping till validation status changes to complete
		long timeoutExpiredMs = System.currentTimeMillis()+30000;
		while(!validationStatus.equals("Complete") && !timeOutOccured) {
			
			try{
				TimeUnit.MILLISECONDS.sleep(2);
				long waitMillis = timeoutExpiredMs - System.currentTimeMillis();
				
			    if (waitMillis <= 0) {				    	
			       timeOutOccured=true;
			       LOGGER.info("timeOutOccured -"+timeOutOccured);
			    }
			    validationStatus = (String) runtimeService.getVariable(processInstanceId, "ValidationStatus");
			}
			catch(Exception exception){
				//LOGGER.info("createTaskQuery retuned empty results");
			}
			
		}
		LOGGER.info("Trying to get latest respponse");
		ApplicationFormResponse applicationFormResponse=(ApplicationFormResponse)runtimeService.getVariable(processInstanceId, "applicationFormResponse");
		LOGGER.info("Fetched latest response - applicationFormResponse");
		return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse,HttpStatus.OK);
	}

}
