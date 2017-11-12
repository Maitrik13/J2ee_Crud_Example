package com.maitrik.panchal.validator.util;

import java.util.List;

public class ValidatorUtil {

	public static boolean validateNullEmptyString(List<String> validateData) {

		boolean validateNullEmpty = true;
		
		for(String str : validateData){
			if(str == null || str == ""){
				validateNullEmpty = false;
			}
		}
		
		return validateNullEmpty;
	}
	
	

}
