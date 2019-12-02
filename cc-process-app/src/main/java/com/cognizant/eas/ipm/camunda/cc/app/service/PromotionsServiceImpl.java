package com.cognizant.eas.ipm.camunda.cc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.eas.ipm.camunda.cc.app.data.Promotion;
import com.cognizant.eas.ipm.camunda.cc.app.repository.PromotionsRepository;

@Component("promotionsService")
public class PromotionsServiceImpl implements PromotionsService {
	
	@Autowired 
	private PromotionsRepository promotionsRepository;

	@Override
	public Promotion getPromoDetailsByCode(String promoCode) {
		Promotion promotion = promotionsRepository.findByPromoCode(promoCode);
		return promotion;
	}

}
