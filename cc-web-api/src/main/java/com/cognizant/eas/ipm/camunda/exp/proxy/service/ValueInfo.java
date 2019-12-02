package com.cognizant.eas.ipm.camunda.exp.proxy.service;

public class ValueInfo {
	 private String objectTypeName;
	 private String serializationDataFormat;


	 // Getter Methods 

	 public String getObjectTypeName() {
	  return objectTypeName;
	 }

	 public String getSerializationDataFormat() {
	  return serializationDataFormat;
	 }

	 // Setter Methods 

	 public void setObjectTypeName(String objectTypeName) {
	  this.objectTypeName = objectTypeName;
	 }

	 public void setSerializationDataFormat(String serializationDataFormat) {
	  this.serializationDataFormat = serializationDataFormat;
	 }
	}