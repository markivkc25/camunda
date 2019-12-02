int ssn=Integer.parseInt(execution.getVariable('SSN'));
println('SSN entered is:'+ssn);
if (ssn%2==0) { 
         //If the condition is true print the following statement 
         execution.setVariable('transUnionScore',700)
      } else { 
         //If the condition is false print the following statement 
         execution.setVariable('transUnionScore',400)
      } 
