package jSONDataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// Step 1: parse JSON physical into java OBject using JSONParse class

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(
				new FileReader("C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\appCommonData.json"));

		// Step 2: down casting - convert java object to json object
		JSONObject map = (JSONObject) obj;

//step 3: Read the json value using get()
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));
	}

}
