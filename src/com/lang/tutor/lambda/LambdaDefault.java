package com.lang.tutor.lambda;

interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
}
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}
public class LambdaDefault implements Interface1, Interface2 {

	@Override
	public void method2() {
		System.out.println("MyClass method2");
		
	}

	@Override
	public void method1(String str) {
		System.out.println("MyClass method1::"+str);
		
	}

	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.super.log("abc");
		Interface2.super.log("abc");
	}
	
	public static void main(String[] args) {
		LambdaDefault obj = new LambdaDefault();
		obj.log("hello");
		obj.method2();
		obj.method1("test");
	}
}
