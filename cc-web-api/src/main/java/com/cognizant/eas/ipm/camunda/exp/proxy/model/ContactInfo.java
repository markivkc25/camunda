package com.cognizant.eas.ipm.camunda.exp.proxy.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContactInfo
 */
@Validated
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class ContactInfo   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("phoneNumberType")
  private String phoneNumberType = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("confirmEmail")
  private String confirmEmail = null;

  @JsonProperty("contactPreferences")
  private String contactPreferences = null;

  public ContactInfo id(Long id) {
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

  public ContactInfo phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public ContactInfo phoneNumberType(String phoneNumberType) {
    this.phoneNumberType = phoneNumberType;
    return this;
  }

  /**
   * Get phoneNumberType
   * @return phoneNumberType
  **/
  @ApiModelProperty(value = "")


  public String getPhoneNumberType() {
    return phoneNumberType;
  }

  public void setPhoneNumberType(String phoneNumberType) {
    this.phoneNumberType = phoneNumberType;
  }

  public ContactInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactInfo confirmEmail(String confirmEmail) {
    this.confirmEmail = confirmEmail;
    return this;
  }

  /**
   * Get confirmEmail
   * @return confirmEmail
  **/
  @ApiModelProperty(value = "")


  public String getConfirmEmail() {
    return confirmEmail;
  }

  public void setConfirmEmail(String confirmEmail) {
    this.confirmEmail = confirmEmail;
  }

  public ContactInfo contactPreferences(String contactPreferences) {
    this.contactPreferences = contactPreferences;
    return this;
  }

  /**
   * Get contactPreferences
   * @return contactPreferences
  **/
  @ApiModelProperty(value = "")


  public String getContactPreferences() {
    return contactPreferences;
  }

  public void setContactPreferences(String contactPreferences) {
    this.contactPreferences = contactPreferences;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfo contactInfo = (ContactInfo) o;
    return Objects.equals(this.id, contactInfo.id) &&
        Objects.equals(this.phoneNumber, contactInfo.phoneNumber) &&
        Objects.equals(this.phoneNumberType, contactInfo.phoneNumberType) &&
        Objects.equals(this.email, contactInfo.email) &&
        Objects.equals(this.confirmEmail, contactInfo.confirmEmail) &&
        Objects.equals(this.contactPreferences, contactInfo.contactPreferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, phoneNumber, phoneNumberType, email, confirmEmail, contactPreferences);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberType: ").append(toIndentedString(phoneNumberType)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    confirmEmail: ").append(toIndentedString(confirmEmail)).append("\n");
    sb.append("    contactPreferences: ").append(toIndentedString(contactPreferences)).append("\n");
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

