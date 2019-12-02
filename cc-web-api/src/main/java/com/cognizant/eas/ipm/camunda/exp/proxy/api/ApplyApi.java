/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cognizant.eas.ipm.camunda.exp.proxy.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.eas.ipm.camunda.exp.proxy.model.ApplicationFormResponse;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")


@Api(value = "apply", description = "the apply API")
public interface ApplyApi {

	@CrossOrigin(origins = "*", methods = RequestMethod.GET, allowedHeaders = "*")
    @ApiOperation(value = "Initiates a Credit Card Application", nickname = "getIdForCCApplication", notes = "", response = ApplicationFormResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ApplicationFormResponse.class) })
    @RequestMapping(value = "/apply",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ApplicationFormResponse> getIdForCCApplication();

}