package com.cognizant.eas.ipm.camunda.exp.proxy.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class CamundaProcessEngineService implements ProcessEngineService {

	private final Logger LOGGER = Logger.getLogger(CamundaProcessEngineService.class.getName());

	@Value("${camunda.cc.app.url}")
	private String url;
	@Value("${camunda.cc.app.api.context.path}")
	private String processApplicationName;
	@Value("${camunda.cc.app.workflow.name}")
	private String processName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processNamee) {
		this.processName = processNamee;
	}

	

	@Override
	public ApplicationFormResponse getIdForCCApplication() throws Exception {
		LOGGER.info("Entered getIdForCCApplication.execute");
		ApplicationFormResponse response=new ApplicationFormResponse();
		ApplicationForm  applicationForm=new ApplicationForm();
		response.setApplicationForm(applicationForm);
		applicationForm.setReference(new Reference());
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = populateHeader();
		
		final String baseUrl = url+"/"+processApplicationName + "/process-definition/key/" + processName + "/start";
		URI uri = new URI(baseUrl);
		LOGGER.info("URI- "+uri.toString());
		
		JSONObject processExecutionRequest = new JSONObject();
		processExecutionRequest.put("variables", new JSONObject());
		processExecutionRequest.put("businessKey", "CC-APP-"+UUID.randomUUID().toString());
		processExecutionRequest.put("withVariablesInReturn", true);
		
		LOGGER.info("ProcessExecutionRequest for getIdForCCApplication"+processExecutionRequest.toString());
		HttpEntity<String> entity = new HttpEntity<>(processExecutionRequest.toString(), headers);
		LOGGER.info("entity"+ReflectionToStringBuilder.toString(entity));
		ResponseEntity<String> result = restTemplate.postForEntity(uri,entity,String.class);
		LOGGER.info("getIdForCCApplication response from Process Application"+result.getBody());
		JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
	    String applciationId = (String)jsonObject.get("id").getAsString();
	    LOGGER.info("Process Application Id:"+applciationId);
	    response.setApplicationId(applciationId);
	    response.getApplicationForm().getReference().setApplicationIdentifier(applciationId);		
		return response;
	}
	

	@Override
	public ApplicationFormResponse submitPersonalDetails(ApplicationForm applicationForm) throws Exception  {
		RestTemplate restTemplate = new RestTemplate();		
		String taskId = getTaskId(applicationForm, restTemplate);
		LOGGER.info("GetTaskId for submitPersonalDetails- "+taskId);
	    //Complete the task
		ApplicationFormResponse applicationFormResponse=completeTask(taskId,applicationForm, restTemplate);
		LOGGER.info("Completed Task for submitPersonalDetails- "+taskId);
		//Get the Latest applicationFormResponse if there are errors.
		applicationFormResponse=getLatestResponse(taskId,applicationForm.getReference().getApplicationIdentifier(), restTemplate);
		LOGGER.info("Fetched latest applicationFormResponse");
		return applicationFormResponse;
	}

	@Override
	public ApplicationFormResponse submitPromoCodeAndCustomerIdentity(ApplicationForm applicationForm) throws Exception {
		RestTemplate restTemplate = new RestTemplate();		
		String taskId = getTaskId(applicationForm, restTemplate);
		LOGGER.info("GetTaskId for submitPromoCodeAndCustomerIdentity- "+taskId);
	    //Complete the task
		ApplicationFormResponse applicationFormResponse=completeTask(taskId,applicationForm, restTemplate);
		LOGGER.info("Completed Task for submitPromoCodeAndCustomerIdentity- "+taskId);
		//Get the Latest applicationFormResponse if there are errors.
		applicationFormResponse=getLatestResponse(taskId,applicationForm.getReference().getApplicationIdentifier(), restTemplate);
		LOGGER.info("Fetched latest applicationFormResponse");
		return applicationFormResponse;
	}
	
	private ApplicationFormResponse getLatestResponse(String taskId, String processId,RestTemplate restTemplate) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);		
		String taskURL = url+"/user-task/submit";
		URI uri = new URI(taskURL);
		LOGGER.info("processinstanceid- "+uri.toString());
		LOGGER.info("taskid- "+taskId);
		LOGGER.info("URI- "+processId);
		
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(taskURL)
			    // Add query parameter
			    .queryParam("processinstanceid", processId);
						
		ResponseEntity<String> result=null;
		try {
			result = restTemplate.getForEntity(builder.toUriString(),String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    ApplicationFormResponse applicationFormResponse=null;	
		if (result!=null) {
			JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
			applicationFormResponse = new Gson().fromJson(jsonObject, ApplicationFormResponse.class);
		}
		return applicationFormResponse;

	}
	
	
	@Override
	public ApplicationFormResponse submitCreditCardApplicationForApproval(ApplicationForm applicationForm) throws Exception {
		RestTemplate restTemplate = new RestTemplate();		
		
		ApplicationFormResponse applicationFormResponse=getLatestResponse("",applicationForm.getReference().getApplicationIdentifier(), restTemplate);
		return applicationFormResponse;
	}
	
	@Override
	public ApplicationFormResponse submitUserOptions(ApplicationForm applicationForm) throws Exception {
		RestTemplate restTemplate = new RestTemplate();		
		String taskId = getTaskId(applicationForm, restTemplate);
		LOGGER.info("GetTaskId for submitUserOptions- "+taskId);
	    //Complete the task
		ApplicationFormResponse applicationFormResponse=completeTask(taskId,applicationForm, restTemplate);
		LOGGER.info("Completed Task for submitUserOptions- "+taskId);
		
		return applicationFormResponse;
	}
	
	/**
	 * Completes the Process Engine Task based on the TaskId
	 * 
	 * @param taskId
	 * @param applicationForm
	 * @param restTemplate
	 * @return
	 * @throws Exception
	 */
	private ApplicationFormResponse completeTask(String taskId,ApplicationForm applicationForm, RestTemplate restTemplate) throws Exception {
		RestTemplate task = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);		
		final String taskURL = url+"/"+processApplicationName + "/task/"+taskId+"/complete";
		URI uri = new URI(taskURL);
		LOGGER.info("URI- "+uri.toString());
		
		JSONObject valueInfo = new JSONObject();
		valueInfo.put("objectTypeName", "com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm");
		valueInfo.put("serializationDataFormat", "application/json");		
		ObjectMapper objectMapper = new ObjectMapper();		
		JSONObject applicationFormJSON = new JSONObject();
		applicationFormJSON.put("type", "Object");
		applicationFormJSON.put("value", objectMapper.writeValueAsString(applicationForm));
		applicationFormJSON.put("valueInfo",valueInfo);
		
		JSONObject applicationFormJSONWrapper = new JSONObject();
		applicationFormJSONWrapper.put("applicationForm", applicationFormJSON);

		JSONObject processExecutionRequest = new JSONObject();
		processExecutionRequest.put("variables", applicationFormJSONWrapper);		
		processExecutionRequest.put("withVariablesInReturn", true);
		
		HttpEntity<String> entity = new HttpEntity<>(processExecutionRequest.toJSONString(), headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri,entity,String.class);
		LOGGER.info("completeTask response"+result.getBody());
		JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
		JsonObject jsonObjectResponse = (JsonObject)jsonObject.get("applicationFormResponse").getAsJsonObject();
	    ApplicationFormResponse applicationFormResponse = new Gson().fromJson(jsonObjectResponse.get("value").getAsString(), ApplicationFormResponse.class);	
		return applicationFormResponse;

	}
	
	/**
	 * Get the latest Task Id for the Process
	 * 
	 * @param applicationForm
	 * @param restTemplate
	 * @return
	 * @throws URISyntaxException
	 */
	private String getTaskId(ApplicationForm applicationForm, RestTemplate restTemplate)
			throws URISyntaxException {
		HttpHeaders headers = populateHeader();		
		//http://localhost:9090/cc-api/task?processInstanceId=a90fa3b0-0cc0-11ea-
		final String taskURL = url+"/"+processApplicationName + "/task?processInstanceId=" + applicationForm.getReference().getApplicationIdentifier();
		URI uri = new URI(taskURL);
		ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);
	 
		JsonArray jsonArray  = new JsonParser().parse(result.getBody()).getAsJsonArray();
	    String taskId = (String)jsonArray.get(0).getAsJsonObject().get("id").getAsString();
		return taskId;
	}
	
	/**
	 * 
	 * @return
	 */
	private HttpHeaders populateHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	

}
