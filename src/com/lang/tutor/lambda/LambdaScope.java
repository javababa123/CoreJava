package com.lang.tutor.lambda;

public class LambdaScope {

	public static void main(String[] args) {
		System.out.println(new LambdaScope().scopeExperiment());
	}
	
	
	
	public String scopeExperiment() {
	    Foo fooIC = new Foo() {
	        String value = "Inner class value";
	 
	        @Override
	        public String method(String string) {
	        	// this works
	            return this.value;
	        }
	    };
	    
	    String resultIC = fooIC.method("");
	 
	    Foo fooLambda = parameter -> {
	        String value = "Lambda value";
	       // This will given error bcz lambda doesn't work like inner class
	        //return this.value;
	  	  
	        return value;
	    };
	    String resultLambda = fooLambda.method("");
	 
	    return "Results: resultIC = " + resultIC + 
	      ", resultLambda = " + resultLambda;
	}
}
@FunctionalInterface
interface Foo {  
   String method(String s);    
   
}
