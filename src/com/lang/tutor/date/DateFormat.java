package com.lang.tutor.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String sDate1="31:12:1998";  
		String time ="11:11:11";
		  
	    SimpleDateFormat formatter6=new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	   
	    System.out.println( formatter6.parse(sDate1+" "+time)); 
	}  
}
