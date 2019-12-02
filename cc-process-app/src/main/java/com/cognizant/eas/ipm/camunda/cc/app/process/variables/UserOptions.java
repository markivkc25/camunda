package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;
/**
 * UserOptions
 */

public class UserOptions   {
	//@JsonProperty("id")
  private Long id = null;

  //@JsonProperty("balanceTransfer")
  private Boolean balanceTransfer = null;

  // @JsonProperty("terms&amp;ConditionsAccepted")
  private Boolean termsConditionsAccepted = null;

  //@JsonProperty("cardImageURL")
  private String cardImageURL = null;

  public UserOptions id(Long id) {
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

  public UserOptions balanceTransfer(Boolean balanceTransfer) {
    this.balanceTransfer = balanceTransfer;
    return this;
  }

  /**
   * Get balanceTransfer
   * @return balanceTransfer
  **/
  //@ApiModelProperty(value = "")


  public Boolean isBalanceTransfer() {
    return balanceTransfer;
  }

  public void setBalanceTransfer(Boolean balanceTransfer) {
    this.balanceTransfer = balanceTransfer;
  }

  public UserOptions termsConditionsAccepted(Boolean termsConditionsAccepted) {
    this.termsConditionsAccepted = termsConditionsAccepted;
    return this;
  }

  /**
   * Get termsConditionsAccepted
   * @return termsConditionsAccepted
  **/
  //@ApiModelProperty(value = "")


  public Boolean isTermsConditionsAccepted() {
    return termsConditionsAccepted;
  }

  public void setTermsConditionsAccepted(Boolean termsConditionsAccepted) {
    this.termsConditionsAccepted = termsConditionsAccepted;
  }

  public UserOptions cardImageURL(String cardImageURL) {
    this.cardImageURL = cardImageURL;
    return this;
  }

  /**
   * Get cardImageURL
   * @return cardImageURL
  **/
  //@ApiModelProperty(value = "")


  public String getCardImageURL() {
    return cardImageURL;
  }

  public void setCardImageURL(String cardImageURL) {
    this.cardImageURL = cardImageURL;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserOptions userOptions = (UserOptions) o;
    return Objects.equals(this.id, userOptions.id) &&
        Objects.equals(this.balanceTransfer, userOptions.balanceTransfer) &&
        Objects.equals(this.termsConditionsAccepted, userOptions.termsConditionsAccepted) &&
        Objects.equals(this.cardImageURL, userOptions.cardImageURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, balanceTransfer, termsConditionsAccepted, cardImageURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserOptions {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    balanceTransfer: ").append(toIndentedString(balanceTransfer)).append("\n");
    sb.append("    termsConditionsAccepted: ").append(toIndentedString(termsConditionsAccepted)).append("\n");
    sb.append("    cardImageURL: ").append(toIndentedString(cardImageURL)).append("\n");
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

