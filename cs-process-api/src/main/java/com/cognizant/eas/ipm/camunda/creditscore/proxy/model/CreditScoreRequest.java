package com.cognizant.eas.ipm.camunda.creditscore.proxy.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditScoreRequest
 */
@Validated
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.creditscore.proxy.codegen.languages.SpringCodegen", date = "2019-11-24T03:50:21.291Z")

public class CreditScoreRequest   {
  @JsonProperty("requestId")
  private Long requestId = null;

  @JsonProperty("dob")
  private String dob = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("ssn")
  private String ssn = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("address")
  private String address = null;

  public CreditScoreRequest requestId(Long requestId) {
    this.requestId = requestId;
    return this;
  }




  public Long getRequestId() {
    return requestId;
  }

  public void setRequestId(Long requestId) {
    this.requestId = requestId;
  }

  public CreditScoreRequest dob(String dob) {
    this.dob = dob;
    return this;
  }




  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public CreditScoreRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreditScoreRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }




  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreditScoreRequest email(String email) {
    this.email = email;
    return this;
  }




  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreditScoreRequest ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }



  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public CreditScoreRequest phone(String phone) {
    this.phone = phone;
    return this;
  }




  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CreditScoreRequest address(String address) {
    this.address = address;
    return this;
  }




  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditScoreRequest creditScoreRequest = (CreditScoreRequest) o;
    return Objects.equals(this.requestId, creditScoreRequest.requestId) &&
        Objects.equals(this.dob, creditScoreRequest.dob) &&
        Objects.equals(this.firstName, creditScoreRequest.firstName) &&
        Objects.equals(this.lastName, creditScoreRequest.lastName) &&
        Objects.equals(this.email, creditScoreRequest.email) &&
        Objects.equals(this.ssn, creditScoreRequest.ssn) &&
        Objects.equals(this.phone, creditScoreRequest.phone) &&
        Objects.equals(this.address, creditScoreRequest.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, dob, firstName, lastName, email, ssn, phone, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditScoreRequest {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

