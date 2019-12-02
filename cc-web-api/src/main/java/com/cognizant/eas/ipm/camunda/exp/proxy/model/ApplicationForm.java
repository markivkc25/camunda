package com.cognizant.eas.ipm.camunda.exp.proxy.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.Applicant;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.Reference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApplicationForm
 */
@Validated
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class ApplicationForm   {
  @JsonProperty("id")
  private Long id = null;

  /**
   * Gets or Sets overAllStatus
   */
  public enum OverAllStatusEnum {
    APPROVED("APPROVED"),
    
    DENIED("DENIED"),
    
    UNDERREVIEW("UNDERREVIEW"),
    
    ONHOLD("ONHOLD");

    private String value;

    OverAllStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OverAllStatusEnum fromValue(String text) {
      for (OverAllStatusEnum b : OverAllStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("overAllStatus")
  private OverAllStatusEnum overAllStatus = null;

  @JsonProperty("applicant")
  private Applicant applicant = null;

  @JsonProperty("reference")
  private Reference reference = null;

  @JsonProperty("existingCustomer")
  private Boolean existingCustomer = null;

  public ApplicationForm id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ApplicationForm overAllStatus(OverAllStatusEnum overAllStatus) {
    this.overAllStatus = overAllStatus;
    return this;
  }

  /**
   * Get overAllStatus
   * @return overAllStatus
  **/
  @ApiModelProperty(value = "")


  public OverAllStatusEnum getOverAllStatus() {
    return overAllStatus;
  }

  public void setOverAllStatus(OverAllStatusEnum overAllStatus) {
    this.overAllStatus = overAllStatus;
  }

  public ApplicationForm applicant(Applicant applicant) {
    this.applicant = applicant;
    return this;
  }

  /**
   * Get applicant
   * @return applicant
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }

  public ApplicationForm reference(Reference reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Reference getReference() {
    return reference;
  }

  public void setReference(Reference reference) {
    this.reference = reference;
  }

  public ApplicationForm existingCustomer(Boolean existingCustomer) {
    this.existingCustomer = existingCustomer;
    return this;
  }

  /**
   * Get existingCustomer
   * @return existingCustomer
  **/
  @ApiModelProperty(value = "")


  public Boolean isexistingCustomer() {
    return existingCustomer;
  }

  public void setexistingCustomer(Boolean existingCustomer) {
    this.existingCustomer = existingCustomer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationForm applicationForm = (ApplicationForm) o;
    return Objects.equals(this.id, applicationForm.id) &&
        Objects.equals(this.overAllStatus, applicationForm.overAllStatus) &&
        Objects.equals(this.applicant, applicationForm.applicant) &&
        Objects.equals(this.reference, applicationForm.reference) &&
        Objects.equals(this.existingCustomer, applicationForm.existingCustomer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, overAllStatus, applicant, reference, existingCustomer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationForm {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    overAllStatus: ").append(toIndentedString(overAllStatus)).append("\n");
    sb.append("    applicant: ").append(toIndentedString(applicant)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    existingCustomer: ").append(toIndentedString(existingCustomer)).append("\n");
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

