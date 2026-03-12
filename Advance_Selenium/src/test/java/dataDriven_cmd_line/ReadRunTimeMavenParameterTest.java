package dataDriven_cmd_line;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {

	@Test
	public void runtimeParameterTest() {
		System.out.println("test my test");
		/*
		 * 1. To get the location of the project Project-> Right click click -
		 * properties - copy full path C:\Users\Premshankar
		 * Mishra\eclipse_Workspace_TekPY\Advance_Selenium
		 * 
		 * 
		 * 2. Window->Cmd propmpt - Location without space mvn test (will execute all
		 * test cases of this project)
		 * 
		 * 
		 * 3. To execute specific test - Location without space mvn -Dtest=Name of the
		 * class test
		 * 
		 * 
		 * 
		 * C:\Users\Premshankar Mishra\eclipse_Workspace_TekPY\Advance_Selenium>mvn
		 * -Dtest=ReadRunTimeMavenParameterTest test
		 * 
		 */
	}
}