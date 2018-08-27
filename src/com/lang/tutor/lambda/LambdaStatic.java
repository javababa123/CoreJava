package com.lang.tutor.lambda;
interface MyData {

	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
}

public class LambdaStatic implements MyData{
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	public static void main(String[] args) {
		LambdaStatic obj = new LambdaStatic();
		obj.print("");
		obj.isNull("abc");
}

}