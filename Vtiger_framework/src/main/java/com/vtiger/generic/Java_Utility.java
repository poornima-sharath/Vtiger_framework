package com.vtiger.generic;

import java.util.Random;

  
  public class Java_Utility {
	  
	  /*
	     Method to avoid duplicate values
	     @author poornima
	  */

	public int getRandomNum() {
		
		Random r = new Random();
		int RanNum = r.nextInt(1000);
		return RanNum;
		}
}
