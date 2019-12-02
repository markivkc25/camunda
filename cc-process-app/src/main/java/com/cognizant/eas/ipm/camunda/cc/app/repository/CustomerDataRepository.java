package com.cognizant.eas.ipm.camunda.cc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.eas.ipm.camunda.cc.app.data.CustomerData;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {
	
	public CustomerData  findByCustomerId(@Param("id") Long id) ;

}
