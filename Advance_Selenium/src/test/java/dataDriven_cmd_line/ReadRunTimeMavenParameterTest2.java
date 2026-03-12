package dataDriven_cmd_line;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest2 {

	@Test
	public void runtimeParameterTest() {
		//Using System Java class we can getProperty using getProperty()
	String url=	System.getProperty("url");
		System.out.println("Env data: "+url);
		
	}
}

