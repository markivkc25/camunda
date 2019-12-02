package com.cognizant.eas.ipm.camunda.exp.proxy.api;

import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.exp.proxy.service.ProcessEngineService;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.List;

@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

@Controller
public class ApplyApiController implements ApplyApi {

	private static final Logger log = LoggerFactory.getLogger(ApplyApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private ProcessEngineService processEngineService;

	public ProcessEngineService getProcessEngineService() {
		return processEngineService;
	}

	public void setProcessEngineService(ProcessEngineService processEngineService) {
		this.processEngineService = processEngineService;
	}

	@org.springframework.beans.factory.annotation.Autowired
	public ApplyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		this.request = request;
	}

	public ResponseEntity<ApplicationFormResponse> getIdForCCApplication() {
		String accept = request.getHeader("Accept");
		ApplicationFormResponse applicationFormResponse = new ApplicationFormResponse();
		if (accept != null && accept.contains("application/json")) {
			try {
				applicationFormResponse = processEngineService.getIdForCCApplication();
				return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ApplicationFormResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ApplicationFormResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
