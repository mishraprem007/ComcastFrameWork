package crm.vitiger.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String dataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\commondata - Copy.properties");
		Properties pop = new Properties();
		pop.load(fis);
		String value = pop.getProperty(key);
		return value;

	}
}
