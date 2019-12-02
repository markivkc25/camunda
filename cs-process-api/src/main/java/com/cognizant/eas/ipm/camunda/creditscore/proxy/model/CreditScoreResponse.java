package com.cognizant.eas.ipm.camunda.creditscore.proxy.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditScoreResponse
 */
@Validated
@javax.annotation.Generated(value = "com.cognizant.eas.ipm.camunda.creditscore.proxy.codegen.languages.SpringCodegen", date = "2019-11-24T03:50:21.291Z")

public class CreditScoreResponse   {
  @JsonProperty("equifaxScore")
  private Double equifaxScore = null;

  @JsonProperty("transunionScore")
  private Double transunionScore = null;

  @JsonProperty("creditHistoryInMonths")
  private BigDecimal creditHistoryInMonths = null;
  
  

  /**
   * Credit Status
   */
  public enum StatusEnum {
    ACTIVE("Active"),
    
    INACTIVE("InActive");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("complete")
  private Boolean complete = true;

  public CreditScoreResponse equifaxScore(Double equifaxScore) {
    this.equifaxScore = equifaxScore;
    return this;
  }

  /**
   * Get equifaxScore
   * @return equifaxScore
  **/
  


  public Double getEquifaxScore() {
    return equifaxScore;
  }

  public void setEquifaxScore(Double equifaxScore) {
    this.equifaxScore = equifaxScore;
  }

  public CreditScoreResponse transunionScore(Double transunionScore) {
    this.transunionScore = transunionScore;
    return this;
  }

  /**
   * Get transunionScore
   * @return transunionScore
  **/
  


  public Double getTransunionScore() {
    return transunionScore;
  }

  public void setTransunionScore(Double transunionScore) {
    this.transunionScore = transunionScore;
  }

  public CreditScoreResponse creditHistoryInMonths(BigDecimal creditHistoryInMonths) {
    this.creditHistoryInMonths = creditHistoryInMonths;
    return this;
  }

  /**
   * Get creditHistoryInMonths
   * @return creditHistoryInMonths
  **/
  

  @Valid

  public BigDecimal getCreditHistoryInMonths() {
    return creditHistoryInMonths;
  }

  public void setCreditHistoryInMonths(BigDecimal creditHistoryInMonths) {
    this.creditHistoryInMonths = creditHistoryInMonths;
  }

  public CreditScoreResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }




  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public CreditScoreResponse complete(Boolean complete) {
    this.complete = complete;
    return this;
  }

  /**
   * Get complete
   * @return complete
  **/
  


  public Boolean isComplete() {
    return complete;
  }

  public void setComplete(Boolean complete) {
    this.complete = complete;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditScoreResponse creditScoreResponse = (CreditScoreResponse) o;
    return Objects.equals(this.equifaxScore, creditScoreResponse.equifaxScore) &&
        Objects.equals(this.transunionScore, creditScoreResponse.transunionScore) &&
        Objects.equals(this.creditHistoryInMonths, creditScoreResponse.creditHistoryInMonths) &&
        Objects.equals(this.status, creditScoreResponse.status) &&
        Objects.equals(this.complete, creditScoreResponse.complete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equifaxScore, transunionScore, creditHistoryInMonths, status, complete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditScoreResponse {\n");
    
    sb.append("    equifaxScore: ").append(toIndentedString(equifaxScore)).append("\n");
    sb.append("    transunionScore: ").append(toIndentedString(transunionScore)).append("\n");
    sb.append("    creditHistoryInMonths: ").append(toIndentedString(creditHistoryInMonths)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
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

