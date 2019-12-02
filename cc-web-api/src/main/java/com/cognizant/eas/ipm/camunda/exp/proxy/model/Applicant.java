package com.cognizant.eas.ipm.camunda.exp.proxy.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.Address;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.ContactInfo;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.Customer;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.EmploymentDetails;
import com.cognizant.eas.ipm.camunda.exp.proxy.model.UserOptions;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Applicant
 */
@Validated
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.exp.proxy.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class Applicant   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("ssn")
  private String ssn = null;

  @JsonProperty("isExistingCustomer")
  private Boolean isExistingCustomer = null;

  @JsonProperty("contactInfo")
  private ContactInfo contactInfo = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("employmentDetails")
  private EmploymentDetails employmentDetails = null;

  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("userOptions")
  private UserOptions userOptions = null;

  public Applicant id(Long id) {
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

  public Applicant firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Applicant lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Applicant ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }

  /**
   * Get ssn
   * @return ssn
  **/
  @ApiModelProperty(value = "")


  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public Applicant isExistingCustomer(Boolean isExistingCustomer) {
    this.isExistingCustomer = isExistingCustomer;
    return this;
  }

  /**
   * Get isExistingCustomer
   * @return isExistingCustomer
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsExistingCustomer() {
    return isExistingCustomer;
  }

  public void setIsExistingCustomer(Boolean isExistingCustomer) {
    this.isExistingCustomer = isExistingCustomer;
  }

  public Applicant contactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
    return this;
  }

  /**
   * Get contactInfo
   * @return contactInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  public Applicant address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Applicant employmentDetails(EmploymentDetails employmentDetails) {
    this.employmentDetails = employmentDetails;
    return this;
  }

  /**
   * Get employmentDetails
   * @return employmentDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public EmploymentDetails getEmploymentDetails() {
    return employmentDetails;
  }

  public void setEmploymentDetails(EmploymentDetails employmentDetails) {
    this.employmentDetails = employmentDetails;
  }

  public Applicant customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Applicant userOptions(UserOptions userOptions) {
    this.userOptions = userOptions;
    return this;
  }

  /**
   * Get userOptions
   * @return userOptions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserOptions getUserOptions() {
    return userOptions;
  }

  public void setUserOptions(UserOptions userOptions) {
    this.userOptions = userOptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Applicant applicant = (Applicant) o;
    return Objects.equals(this.id, applicant.id) &&
        Objects.equals(this.firstName, applicant.firstName) &&
        Objects.equals(this.lastName, applicant.lastName) &&
        Objects.equals(this.ssn, applicant.ssn) &&
        Objects.equals(this.isExistingCustomer, applicant.isExistingCustomer) &&
        Objects.equals(this.contactInfo, applicant.contactInfo) &&
        Objects.equals(this.address, applicant.address) &&
        Objects.equals(this.employmentDetails, applicant.employmentDetails) &&
        Objects.equals(this.customer, applicant.customer) &&
        Objects.equals(this.userOptions, applicant.userOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, ssn, isExistingCustomer, contactInfo, address, employmentDetails, customer, userOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Applicant {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
    sb.append("    isExistingCustomer: ").append(toIndentedString(isExistingCustomer)).append("\n");
    sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    employmentDetails: ").append(toIndentedString(employmentDetails)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    userOptions: ").append(toIndentedString(userOptions)).append("\n");
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

