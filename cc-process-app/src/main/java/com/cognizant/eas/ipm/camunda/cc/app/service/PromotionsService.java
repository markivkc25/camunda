package com.cognizant.eas.ipm.camunda.cc.app.service;

import com.cognizant.eas.ipm.camunda.cc.app.data.Promotion;

public interface PromotionsService {
	
	 public abstract Promotion getPromoDetailsByCode(String promoCode);

}
