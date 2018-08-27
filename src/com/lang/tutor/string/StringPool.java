package com.lang.tutor.string;

public class StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
       
    	//    	 String st = "hello";
//    	    System.out.println(" String st = \"hello\" :"+System.identityHashCode(st));

    	 String s = new String("hello"); // "abc" will not be added to String constants pool.
    	    System.out.println("String s = new String(new char[] { 'h', 'e', 'l','l','o' }): "+System.identityHashCode(s));
    	    String   s1 = s.intern();// add s to String constants pool
    	    System.out.println("s1 = s.intern() :"+System.identityHashCode(s1));

    	    String str1 = new String("hello");
    	    String str2 = "hello";
    	    String str3 = str1.intern();
    	    String str4="hello";
    	    System.out.println("String str1 = new String(\"hello\"); :"+System.identityHashCode(str1));
    	    System.out.println("String str2 = \"hello\"; :"+System.identityHashCode(str2));
    	    System.out.println(" String str3 = str1.intern(); :"+System.identityHashCode(str3));
    	    System.out.println("String s = new String(new char[] { 'h', 'e', 'l','l','o' }): "+System.identityHashCode(s));
    	    System.out.println(System.identityHashCode("hello"));
    }

}
