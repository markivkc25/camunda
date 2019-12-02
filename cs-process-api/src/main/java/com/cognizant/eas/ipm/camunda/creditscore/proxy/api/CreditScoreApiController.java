package com.cognizant.eas.ipm.camunda.creditscore.proxy.api;

import io.swagger.annotations.*;

import com.cognizant.eas.ipm.camunda.creditscore.process.delegate.TransUnionServiceTask;
import com.cognizant.eas.ipm.camunda.creditscore.proxy.model.CreditScoreRequest;
import com.cognizant.eas.ipm.camunda.creditscore.proxy.model.CreditScoreResponse;
import com.cognizant.eas.ipm.camunda.creditscore.proxy.model.CreditScoreResponse.StatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.Level;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.creditscore.proxy.codegen.languages.SpringCodegen", date = "2019-11-24T03:50:21.291Z")

@Controller
public class CreditScoreApiController implements CreditScoreApi {

	private static final String STATUS = "status";

	private static final String CREDIT_HISTORY_IN_MONTHS = "creditHistoryInMonths";

	private static final String ADDRESS = "Address";

	private static final String SSN = "SSN";

	private static final String DOB = "DOB";

	private static final String LAST_NAME = "LastName";

	private static final String FIRST_NAME = "FirstName";

	private static final String TRANS_UNION_SCORE = "transUnionScore";

	private static final String EQUIFAX_SCORE = "equifaxScore";

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	  private final Logger LOGGER = Logger.getLogger(TransUnionServiceTask.class.getName());


	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public CreditScoreApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<CreditScoreResponse> getCreditScore(
			@ApiParam(value = "Credit Score Request", required = true) @Valid @RequestBody CreditScoreRequest creditScoreRequest) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				// Instantiate a "creditscore-process-api" Process
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("creditscore-process-api");
				// Get the Task Id
				Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
				// Populate the Variables
				Map<String, Object> processReqVariables = prepareRequest(creditScoreRequest);
				VariableMap processInstanceVariables = taskService.completeWithVariablesInReturn(task.getId(), processReqVariables,false);
				CreditScoreResponse creditScoreResponse= prepareResponse(processInstanceVariables);
				return new ResponseEntity<CreditScoreResponse>(creditScoreResponse, HttpStatus.OK);
			} catch (Exception e) {
				LOGGER.log(java.util.logging.Level.SEVERE, "Couldn't serialize response for content type application/json",e);
				return new ResponseEntity<CreditScoreResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<CreditScoreResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	private CreditScoreResponse prepareResponse(VariableMap processInstanceVariables) {
		List<CreditScoreResponse> creditScoreResponseList=new ArrayList<CreditScoreResponse>();
		CreditScoreResponse creditScoreResponse=new CreditScoreResponse();
		creditScoreResponse.setEquifaxScore(Double.valueOf((Integer)processInstanceVariables.get(EQUIFAX_SCORE)));
		creditScoreResponse.setTransunionScore(Double.valueOf((Integer)processInstanceVariables.get(TRANS_UNION_SCORE)));
		creditScoreResponse.setCreditHistoryInMonths(BigDecimal.valueOf((Integer)processInstanceVariables.get(CREDIT_HISTORY_IN_MONTHS)));
		creditScoreResponse.setStatus((String)processInstanceVariables.get(STATUS)!=null?StatusEnum.ACTIVE:StatusEnum.INACTIVE);
		creditScoreResponseList.add(creditScoreResponse);
		return creditScoreResponse;
	}

	private Map<String, Object> prepareRequest(CreditScoreRequest creditScoreRequest) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(FIRST_NAME, creditScoreRequest.getFirstName());
		variables.put(LAST_NAME, creditScoreRequest.getLastName());
		variables.put(DOB, creditScoreRequest.getDob());
		variables.put(SSN, creditScoreRequest.getSsn().replaceAll("-", ""));
		variables.put(ADDRESS, creditScoreRequest.getAddress());
		return variables;
	}

}
