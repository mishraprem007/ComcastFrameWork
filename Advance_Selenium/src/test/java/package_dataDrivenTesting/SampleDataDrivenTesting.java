package package_dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {
//Getting data from property file
	public static void main(String[] args) throws IOException {
		// step 1 Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Premshankar Mishra\\OneDrive\\Desktop\\New folder\\commondata.properties");

		// step 2 Using property class, load all the key
		Properties pObj = new Properties();
		pObj.load(fis);
		pObj.getProperty("url");
		
		// step 3 get the value based on key
		System.out.println(pObj.getProperty("browser"));
	}
}