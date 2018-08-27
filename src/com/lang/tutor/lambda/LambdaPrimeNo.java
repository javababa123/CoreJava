package com.lang.tutor.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class LambdaPrimeNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LambdaPrimeNo.isPrime(4));
		System.out.println(LambdaPrimeNo.isPrime1(5));
		System.out.println(LambdaPrimeNo.isPrime2(4));
		
	}
	//Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	//Declarative approach
	private static boolean isPrime1(int number) {		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						index -> number % index == 0);
	}
	
	private static boolean isPrime2(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						isDivisible);
	}
}
