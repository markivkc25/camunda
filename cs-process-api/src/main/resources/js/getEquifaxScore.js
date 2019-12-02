var ssn = parseInt(execution.getVariable('SSN'), 10);

if(ssn % 2 === 0){
	execution.setVariable('equifaxScore', 725);
}else{
	execution.setVariable('equifaxScore', 425);
}
execution.setVariable('creditHistoryInMonths', 22);
execution.setVariable('status', 'active');