package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;
import javax.validation.Valid;

/**
 * ApplicationFormResponse
 */
/*@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")*/
public class ApplicationFormResponse   {
  //@JsonProperty("applicationId")
  private String applicationId = null;

  //@JsonProperty("processingStatus")
  private ProcessingStatus processingStatus = null;

  //@JsonProperty("applicationForm")
  private ApplicationForm applicationForm = null;

  public ApplicationFormResponse applicationId(String applicationId) {
    this.applicationId = applicationId;
    return this;
  }



  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }

  public ApplicationFormResponse processingStatus(ProcessingStatus processingStatus) {
    this.processingStatus = processingStatus;
    return this;
  }



  @Valid

  public ProcessingStatus getProcessingStatus() {
    return processingStatus;
  }

  public void setProcessingStatus(ProcessingStatus processingStatus) {
    this.processingStatus = processingStatus;
  }

  public ApplicationFormResponse applicationForm(ApplicationForm applicationForm) {
    this.applicationForm = applicationForm;
    return this;
  }



  @Valid

  public ApplicationForm getApplicationForm() {
    return applicationForm;
  }

  public void setApplicationForm(ApplicationForm applicationForm) {
    this.applicationForm = applicationForm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationFormResponse applicationFormResponse = (ApplicationFormResponse) o;
    return Objects.equals(this.applicationId, applicationFormResponse.applicationId) &&
        Objects.equals(this.processingStatus, applicationFormResponse.processingStatus) &&
        Objects.equals(this.applicationForm, applicationFormResponse.applicationForm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, processingStatus, applicationForm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationFormResponse {\n");
    
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    processingStatus: ").append(toIndentedString(processingStatus)).append("\n");
    sb.append("    applicationForm: ").append(toIndentedString(applicationForm)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

