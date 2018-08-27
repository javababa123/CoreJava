package com.lang.tutor.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listOfStrings = Arrays.asList("Mark", "Howard", "Anthony D'Cornian");
		Optional<String> largeString 
		  = listOfStrings.stream().filter(str -> str.length() > 5).findAny();
		largeString.ifPresent(System.out::println);

		Optional<String> veryLargeString 
		  = listOfStrings.stream().filter(str -> str.length() > 20).findAny();
		veryLargeString.ifPresent(System.out::println);
		
		
	}
	
}
