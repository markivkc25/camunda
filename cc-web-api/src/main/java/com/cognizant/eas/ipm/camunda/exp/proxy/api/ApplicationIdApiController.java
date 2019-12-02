package com.cognizant.eas.ipm.camunda.exp.proxy.api;

import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.ProcessingStatus;
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
public class ApplicationIdApiController implements ApplicationIdApi {

	private static final Logger log = LoggerFactory.getLogger(ApplicationIdApiController.class);

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Autowired
	private ProcessEngineService processEngineService;

	@org.springframework.beans.factory.annotation.Autowired
	public ApplicationIdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	}

	public ResponseEntity<ApplicationForm> submitCreditCardApplicationForApproval(
			@ApiParam(value = "Unique id for the application", required = true) @PathVariable("application-Id") String applicationId,
			@ApiParam(value = "Application Form with the PromoCode and Customer Details Populated", required = true) @Valid @RequestBody ApplicationForm applicationForm) {
		
        return new ResponseEntity<ApplicationForm>(applicationForm,HttpStatus.OK);
	}

	public ResponseEntity<ApplicationFormResponse> submitPersonalDetails(
			@ApiParam(value = "Unique id for the application", required = true) @PathVariable("application-Id") String applicationId,
			@ApiParam(value = "Application Form with the PromoCode and Customer Details Populated", required = true) @Valid @RequestBody ApplicationForm applicationForm) {
		ApplicationFormResponse applicationFormResponse=new ApplicationFormResponse();
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {        	
        	try {
				applicationFormResponse=processEngineService.submitPersonalDetails(applicationForm);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
        	if(applicationFormResponse!=null) {
    			applicationFormResponse.getApplicationForm().setOverAllStatus(com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm.OverAllStatusEnum.UNDERREVIEW);
    			if(applicationFormResponse.getProcessingStatus().getMessage()==null) {
    				applicationFormResponse.getProcessingStatus().setMessage("Successfully Validated Personal Details");
    				applicationFormResponse.getProcessingStatus().setStageResult(com.cognizant.eas.ipm.camunda.exp.proxy.model.ProcessingStatus.StageResultEnum.PASSED);
    			}    
    			return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.OK);
        	}			
        }
        return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse,HttpStatus.OK);
	}

	/***
	 * 
	 */
	public ResponseEntity<ApplicationFormResponse> submitPromoCodeAndCustomerIdentity(@ApiParam(value = "Unique id for the application",required=true) @PathVariable("application-Id") String applicationId,@ApiParam(value = "Application Form with the PromoCode and Customer Details Populated" ,required=true )  @Valid @RequestBody ApplicationForm applicationForm) {
		ApplicationFormResponse applicationFormResponse=new ApplicationFormResponse();
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {        	
        	try {
				applicationFormResponse=processEngineService.submitPromoCodeAndCustomerIdentity(applicationForm);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
        	if(applicationFormResponse!=null) {
    			applicationFormResponse.getApplicationForm().setOverAllStatus(com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm.OverAllStatusEnum.UNDERREVIEW);
    			if(applicationFormResponse.getProcessingStatus().getMessage()==null) {
    				applicationFormResponse.getProcessingStatus().setMessage("Successfully Validated Promocode and Customer Identity");
    				applicationFormResponse.getProcessingStatus().setStageResult(com.cognizant.eas.ipm.camunda.exp.proxy.model.ProcessingStatus.StageResultEnum.PASSED);
    			}    
    			return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.OK);
        	}
			
        }
        return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse,HttpStatus.OK);
    }


	public ResponseEntity<ApplicationFormResponse> submitUserOptions(
			@ApiParam(value = "Unique id for the application", required = true) @PathVariable("application-Id") String applicationId,
			@ApiParam(value = "Application Form with the PromoCode and Customer Details Populated", required = true) @Valid @RequestBody ApplicationForm applicationForm) {
		ApplicationFormResponse applicationFormResponse=new ApplicationFormResponse();
		String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {        	
        	try {
				applicationFormResponse=processEngineService.submitUserOptions(applicationForm);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
        	if(applicationFormResponse!=null) {
    			applicationFormResponse.getApplicationForm().setOverAllStatus(com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm.OverAllStatusEnum.UNDERREVIEW);
    			if(applicationFormResponse.getProcessingStatus().getMessage()==null) {
    				applicationFormResponse.getProcessingStatus().setMessage("Successfully Validated User Options");
    				applicationFormResponse.getProcessingStatus().setStageResult(com.cognizant.eas.ipm.camunda.exp.proxy.model.ProcessingStatus.StageResultEnum.PASSED);
    			}    
    			return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse, HttpStatus.OK);
        	}
			
        }
        return new ResponseEntity<ApplicationFormResponse>(applicationFormResponse,HttpStatus.OK);
	}

}
