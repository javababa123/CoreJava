package com.lang.tutor.lambda;

import java.util.Arrays;
import java.util.List;

public class InternalIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> namesList=Arrays.asList("Tom", "Dick", "Harry");
	    namesList.forEach(name -> System.out.println(name));//Internal Iteration
	 
	}

}
