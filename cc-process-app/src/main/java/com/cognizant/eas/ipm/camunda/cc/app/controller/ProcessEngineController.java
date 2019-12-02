package com.cognizant.eas.ipm.camunda.cc.app.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.Task;
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

	@Autowired
	private TaskService taskService;

	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("/user-task/submit")
	public ResponseEntity<ApplicationFormResponse> completeTaskWithValidation(@RequestParam("processinstanceid")String processInstanceId) {			
		// Get the Task Id
		LOGGER.info("processInstanceId-"+processInstanceId);
		
		boolean isNewTaskCreated= false;
		boolean timeOutOccured=false;
		// Keep Looping till it reaches next token
		long timeoutExpiredMs = System.currentTimeMillis()+30000;
		while(!isNewTaskCreated && !timeOutOccured) {
			LOGGER.info("Waiting for the task to complete.......timeOutOccured.....isNewTaskCreated........."+isNewTaskCreated+"--"+timeOutOccured);
			try{
				TimeUnit.SECONDS.sleep(2);				
				long waitMillis = timeoutExpiredMs - System.currentTimeMillis();
				LOGGER.info("WaitMillis -"+waitMillis);
			    if (waitMillis <= 0) {				    	
			       timeOutOccured=true;
			       LOGGER.info("timeOutOccured -"+timeOutOccured);
			    }
			    List<Execution> executions = runtimeService.createExecutionQuery().signalEventSubscriptionName("PromoCodeValidationSuccesful").list();
			    
			    if(executions!=null) {
			    	LOGGER.info("executions"+executions.get(0).getProcessInstanceId());
			    }
			    
				Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).list().get(0);
				if(task.getName().equals("Enter Promo Code and Customer Details")){
					LOGGER.info("New Task Created"+task.getName());
					isNewTaskCreated=true;	
				} 
				else if(task.getName().equals("Enter or Review Personal Details")){
					LOGGER.info("New Task Created"+task.getName());
					isNewTaskCreated=true;	
				} 
				else if(task.getName().equals("Enter the User Preferences and validate")){
					LOGGER.info("New Task Created"+task.getName());
					isNewTaskCreated=true;	
				}
			}
			catch(Exception exception){
				LOGGER.info("createTaskQuery retuned empty results");
			}
			
		}
		LOGGER.info("Trying to get latest respponse");
		ApplicationFormResponse applicationFormResponse=(ApplicationFormResponse)runtimeService.getVariable(processInstanceId, "applicationFormResponse");
		LOGGER.info("applicationFormResponse after new task created======" +applicationFormResponse);
		return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse,HttpStatus.OK);
	}

}
