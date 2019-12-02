package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;

/**
 * Reference
 */

public class Reference   {
 // @JsonProperty("id")
  private Long id = null;

  //@JsonProperty("promoCode")
  private String promoCode = null;

  // @JsonProperty("application-Identifier")
  private String applicationIdentifier = null;

  public Reference id(Long id) {
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

  public Reference promoCode(String promoCode) {
    this.promoCode = promoCode;
    return this;
  }

  /**
   * PromoCode for the CC Application Form
   * @return promoCode
  **/
  //@ApiModelProperty(value = "PromoCode for the CC Application Form")


  public String getPromoCode() {
    return promoCode;
  }

  public void setPromoCode(String promoCode) {
    this.promoCode = promoCode;
  }

  public Reference applicationIdentifier(String applicationIdentifier) {
    this.applicationIdentifier = applicationIdentifier;
    return this;
  }

  /**
   * Unique Identifier for the CC Application Form
   * @return applicationIdentifier
  **/
  //@ApiModelProperty(value = "Unique Identifier for the CC Application Form")


  public String getApplicationIdentifier() {
    return applicationIdentifier;
  }

  public void setApplicationIdentifier(String applicationIdentifier) {
    this.applicationIdentifier = applicationIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reference reference = (Reference) o;
    return Objects.equals(this.id, reference.id) &&
        Objects.equals(this.promoCode, reference.promoCode) &&
        Objects.equals(this.applicationIdentifier, reference.applicationIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, promoCode, applicationIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reference {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    promoCode: ").append(toIndentedString(promoCode)).append("\n");
    sb.append("    applicationIdentifier: ").append(toIndentedString(applicationIdentifier)).append("\n");
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

