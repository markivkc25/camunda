package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

/**
 * EmploymentDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class EmploymentDetails   {
  //@JsonProperty("id")
  private Long id = null;

  // @JsonProperty("occupation")
  private String occupation = null;

  //@JsonProperty("duration")
  private String duration = null;
  
//@JsonProperty("income")
  private String income = null;

  public EmploymentDetails id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  //@ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EmploymentDetails occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * Get occupation
   * @return occupation
  **/
  //@ApiModelProperty(value = "")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public EmploymentDetails duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  **/
  //@ApiModelProperty(value = "")


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }
  
  public EmploymentDetails income(String income) {
	    this.income = income;
	    return this;
	  }

	  /**
	   * Get duration
	   * @return duration
	  **/
	  //@ApiModelProperty(value = "")


	  public String getIncome() {
	    return income;
	  }

	  public void setIncome(String income) {
	    this.income = income;
	  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmploymentDetails employmentDetails = (EmploymentDetails) o;
    return Objects.equals(this.id, employmentDetails.id) &&
        Objects.equals(this.occupation, employmentDetails.occupation) &&
        Objects.equals(this.duration, employmentDetails.duration) &&
        Objects.equals(this.income, employmentDetails.income);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, occupation, duration, income);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmploymentDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
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

