package com.neusoft.util;

public class ValidataUtils {
   public static boolean validataEmpty(Object data)
   {  
	   
	   if(data==null||"".equals(data))
	   {
		   return false;
	   }
	   return true;
	   
   }
   
}
