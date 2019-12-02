package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;

/**
 * ProcessingStatus
 */
//@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-16T06:57:02.932Z")

public class ProcessingStatus   {
	//@JsonProperty("id")
  private Long id = null;

  //@JsonProperty("message")
  private String message = null;

  /**
   * Gets or Sets nextStage
   */
  public enum NextStageEnum {
    ENTERCUSTOMERDETAILS("EnterCustomerDetails"),
    
    ENTERPERSONALDETAILS("EnterPersonalDetails"),
    
    ENTERUSERPREFERENCES("EnterUserPreferences");

    private String value;

    NextStageEnum(String value) {
      this.value = value;
    }

    @Override
    //@JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    //@JsonCreator
    public static NextStageEnum fromValue(String text) {
      for (NextStageEnum b : NextStageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  //@JsonProperty("nextStage")
  private NextStageEnum nextStage = null;

  /**
   * Gets or Sets currentStage
   */
  public enum CurrentStageEnum {
    ENTERCUSTOMERDETAILS("EnterCustomerDetails"),
    
    ENTERPERSONALDETAILS("EnterPersonalDetails"),
    
    ENTERUSERPREFERENCES("EnterUserPreferences");

    private String value;

    CurrentStageEnum(String value) {
      this.value = value;
    }

    @Override
    //@JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    //@JsonCreator
    public static CurrentStageEnum fromValue(String text) {
      for (CurrentStageEnum b : CurrentStageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  //@JsonProperty("currentStage")
  private CurrentStageEnum currentStage = null;

  /**
   * status of the Stage
   */
  public enum StageResultEnum {
    PASSED("Passed"),
    
    FAILED("Failed");

    private String value;

    StageResultEnum(String value) {
      this.value = value;
    }

    @Override
    //@JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    // @JsonCreator
    public static StageResultEnum fromValue(String text) {
      for (StageResultEnum b : StageResultEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  //@JsonProperty("stageResult")
  private StageResultEnum stageResult = null;

  public ProcessingStatus id(Long id) {
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

  public ProcessingStatus message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  //@ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ProcessingStatus nextStage(NextStageEnum nextStage) {
    this.nextStage = nextStage;
    return this;
  }

  /**
   * Get nextStage
   * @return nextStage
  **/
  //@ApiModelProperty(value = "")


  public NextStageEnum getNextStage() {
    return nextStage;
  }

  public void setNextStage(NextStageEnum nextStage) {
    this.nextStage = nextStage;
  }

  public ProcessingStatus currentStage(CurrentStageEnum currentStage) {
    this.currentStage = currentStage;
    return this;
  }

  /**
   * Get currentStage
   * @return currentStage
  **/
  //@ApiModelProperty(value = "")


  public CurrentStageEnum getCurrentStage() {
    return currentStage;
  }

  public void setCurrentStage(CurrentStageEnum currentStage) {
    this.currentStage = currentStage;
  }

  public ProcessingStatus stageResult(StageResultEnum stageResult) {
    this.stageResult = stageResult;
    return this;
  }

  /**
   * status of the Stage
   * @return stageResult
  **/
  //@ApiModelProperty(value = "status of the Stage")


  public StageResultEnum getStageResult() {
    return stageResult;
  }

  public void setStageResult(StageResultEnum stageResult) {
    this.stageResult = stageResult;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessingStatus processingStatus = (ProcessingStatus) o;
    return Objects.equals(this.id, processingStatus.id) &&
        Objects.equals(this.message, processingStatus.message) &&
        Objects.equals(this.nextStage, processingStatus.nextStage) &&
        Objects.equals(this.currentStage, processingStatus.currentStage) &&
        Objects.equals(this.stageResult, processingStatus.stageResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message, nextStage, currentStage, stageResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessingStatus {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    nextStage: ").append(toIndentedString(nextStage)).append("\n");
    sb.append("    currentStage: ").append(toIndentedString(currentStage)).append("\n");
    sb.append("    stageResult: ").append(toIndentedString(stageResult)).append("\n");
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

