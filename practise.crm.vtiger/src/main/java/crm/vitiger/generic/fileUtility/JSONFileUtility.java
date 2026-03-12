package crm.vitiger.generic.fileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtility {

	public String getDataFromJSON(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(
				new FileReader("C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\appCommonData.json"));
		JSONObject jObj = (JSONObject) obj;
		String value = (String) jObj.get(key);
		return value;
	}
}
