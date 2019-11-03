package com.easybusiness.hrmanagement.utils;

import java.util.Date;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;

/**
 * @author Mainak
 *
 */
public class HRManagementUtils {

	/**
	 * Method to create six digit
	 * Alpha numeric
	 *
	 */
	public static String randomAlphaNumeric() {
		StringBuilder builder = new StringBuilder();
		int lemgth = 3;
		while (lemgth-- != 0) {
			int character = (int) (Math.random() * HRManagementConstant.ALPHA_STRING.length());
			builder.append(HRManagementConstant.ALPHA_STRING.charAt(character));
			int numeric = (int) (Math.random() * HRManagementConstant.NUMERIC_STRING.length());
			builder.append(HRManagementConstant.NUMERIC_STRING.charAt(numeric));
		}
		return builder.toString();
	}
	
	public static String primaryKeyGenrator(String module) {
		return new StringBuilder(module).append(HRManagementConstant.UNDERSCORE).append(new Date().getTime()).toString();
	}
}
