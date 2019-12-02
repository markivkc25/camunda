package com.cognizant.eas.ipm.camunda.cc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.eas.ipm.camunda.cc.app.data.Promotion;

@Repository
public interface PromotionsRepository extends JpaRepository<Promotion, Long>{
	
	public Promotion findByPromoCode(@Param("promoCode") String promoCode) ;

}
