package com.cognizant.eas.ipm.camunda.exp.proxy.service;

import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationForm;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationFormResponse;

@Service
public interface ProcessEngineService {
	
	/**
	 * 
	 * @param applicationForm
	 * @return ApplicationFormResponse
	 */
    public ApplicationFormResponse submitCreditCardApplicationForApproval(ApplicationForm applicationForm) throws Exception;
    
    /**
     * 
     * @return ApplicationFormResponse
     * @throws Exception 
     */
    public ApplicationFormResponse getIdForCCApplication() throws Exception;
    
    /**
     * 
     * @param applicationForm
     * @return ApplicationFormResponse
     */
    public ApplicationFormResponse submitPersonalDetails(ApplicationForm applicationForm) throws Exception;;
    
    /**
     * 
     * @param applicationForm
     * @return ApplicationFormResponse
     */
    public ApplicationFormResponse submitPromoCodeAndCustomerIdentity(ApplicationForm applicationForm) throws Exception;;
    
    
    /**
     * 
     * @param applicationForm
     * @return ApplicationFormResponse
     */
    public ApplicationFormResponse  submitUserOptions(ApplicationForm applicationForm) throws Exception;;


}
