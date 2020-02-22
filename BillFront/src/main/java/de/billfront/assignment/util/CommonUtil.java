package de.billfront.assignment.util;

import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Common Utility class
 * 
 * @author Sai Krishna Sowmith Sanakkayala
 *
 */
public class CommonUtil {

	public static JsonElement loadResourceJsonFile(String fileName){
		
		JsonElement jsonElement = null;
		
		try {
			JsonParser jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)));
			
		} catch (JsonIOException e) {
			
			e.printStackTrace();
		} catch (JsonSyntaxException e) {

			e.printStackTrace();
		} 
		
		return jsonElement;
	}
	
}
