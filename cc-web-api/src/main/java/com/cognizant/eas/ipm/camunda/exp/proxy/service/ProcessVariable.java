package com.cognizant.eas.ipm.camunda.exp.proxy.service;

public class ProcessVariable {
	 private String value;
	 private String type;
	 private ValueInfo ValueInfoObject;


	 // Getter Methods 

	 public String getValue() {
	  return value;
	 }

	 public String getType() {
	  return type;
	 }

	 public ValueInfo getValueInfo() {
	  return ValueInfoObject;
	 }

	 // Setter Methods 

	 public void setValue(String value) {
	  this.value = value;
	 }

	 public void setType(String type) {
	  this.type = type;
	 }

	 public void setValueInfo(ValueInfo valueInfoObject) {
	  this.ValueInfoObject = valueInfoObject;
	 }
	}
	
	