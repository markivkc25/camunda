package com.cognizant.eas.ipm.camunda.creditscore.proxy.api;

@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.creditscore.proxy.codegen.languages.SpringCodegen", date = "2019-11-24T03:50:21.291Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
