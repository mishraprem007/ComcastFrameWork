package jdbcSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class CheckConditionsWithQueryResult {

	@Test
	public void projectCheckTest() throws SQLException {
		boolean flag = false;
		String expectedProjectName = "Test Project";
// Step 1- Register/laod the data base
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
// Step 2- Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
//Step-3- create sql statement
		Statement stat = conn.createStatement();
//Step-4- execute select query and get result
		ResultSet resultSet = stat.executeQuery("select * from employee;");
		while (resultSet.next()) {
			String actProject = resultSet.getString(9);
			if (expectedProjectName.equals(actProject)) {
				flag = true;
				System.out.println(expectedProjectName + " is avialble ===Pass");
			}
		}
		if (flag == false) {
			System.out.println(expectedProjectName + " is not avialble ===Fail");
		Assert.fail();
		}
//Step-5-Close connection
		conn.close();
	}
}
