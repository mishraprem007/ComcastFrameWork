package dataDriven_cmd_line;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest3 {

	@Test
	public void runtimeParameterTest() {
		// Using System Java class we can getProperty using getProperty()
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println("Env data: URL " + url);
		System.out.println("Env data: browser " + browser);
		System.out.println("Env data: username " + username);
		System.out.println("Env data: password " + password);

	}
}
