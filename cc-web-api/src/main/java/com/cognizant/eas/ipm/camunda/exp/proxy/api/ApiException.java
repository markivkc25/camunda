package com.cognizant.eas.ipm.camunda.exp.proxy.api;

@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
