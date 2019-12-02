package com.cognizant.eas.ipm.camunda.cc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.eas.ipm.camunda.cc.app.data.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
	
	public CustomerAccount findByAccountNumber(@Param("accountNumber") String accountNumber) ;

}
