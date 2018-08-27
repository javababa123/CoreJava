
interface A {
	 default void display() { 
		 System.out.println("Common code");
	 }
}
 interface B extends A{ 
	 default void display() { 
		 System.out.println("Common code2");
	 }
	 
 }
 interface C extends A{ 
	 default void display() { 
		 System.out.println("Common code3");
	 }
 }
 public class DiamondProblem implements B,C{
  public void display() { 
    B.super.display();       
  }
  
  public static void main(String ar[])
  {
	  new DiamondProblem().display();
  }
}
