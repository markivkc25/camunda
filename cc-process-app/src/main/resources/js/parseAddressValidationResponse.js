// fetch execution variables
var response = connector.getVariable("response");
// parse response variable with camunda-spin
var json = S(response);

var  errorCodeProperty = json.prop("ErrorCode");
var  errorCodeValue = errorCodeProperty.stringValue();

execution.setVariable("ErrorCode",errorCodeValue);
print('This prints to the console'+ErrorCode);
if ( errorCodeValue != null ) {
	throw new org.camunda.bpm.engine.delegate.BpmnError("CC-WF-008","InvalidAddress");
}





