package com.lang.tutor.lambda;

@FunctionalInterface
interface FunctioanlInterface extends Baz, Bar {
}
     
@FunctionalInterface
 interface Baz {  
    String method();    
    
}


@FunctionalInterface
 interface Bar {  
    String method();    

}

public class LambdaTest implements FunctioanlInterface{
	
	public static void main(String args[])
	{
		FunctioanlInterface foo = () -> {
			System.out.println(" from Foo"); return "";
			};
		foo.method();
		FunctioanlInterface foo1 = new FunctioanlInterface() {

			@Override
			public String method() {
				System.out.println(" from Foo1"); return "";
				
			}
			
			};
			foo1.method();
		new LambdaTest().method();
	}

	@Override
	public String method() {
		System.out.println("Tws");
		return null;
	}
}