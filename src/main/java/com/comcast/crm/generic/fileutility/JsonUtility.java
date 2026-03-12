package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDatafromJsonFile(String key) throws Throwable, ParseException {
		FileReader fileR=new FileReader("./configAppData/appCommonData.json");
		//parse json physical file in to java object using Json parse  class
				JSONParser parser=new JSONParser();
				Object obj = parser.parse(fileR);
				
				//convert java object in to JsonObject using down casting
				JSONObject map = (JSONObject)obj;
				
				// get value from json file using key in string 
			String data = (String) map.get(key);
				return data;
	
	}
}
