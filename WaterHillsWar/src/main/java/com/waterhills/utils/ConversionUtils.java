package com.waterhills.utils;

import java.util.stream.Stream;

/**
 * Util class for conversions.
 * 
 */
public class ConversionUtils {

	public static int[]  parseStringToArray(String inputStr){
		return  Stream.of(inputStr.split("\\s+")).mapToInt(Integer::parseInt).toArray();
	}
	
}
