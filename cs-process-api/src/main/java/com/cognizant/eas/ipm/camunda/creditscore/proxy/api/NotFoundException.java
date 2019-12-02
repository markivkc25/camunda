package com.cognizant.eas.ipm.camunda.creditscore.proxy.api;

@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.creditscore.proxy.codegen.languages.SpringCodegen", date = "2019-11-24T03:50:21.291Z")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
