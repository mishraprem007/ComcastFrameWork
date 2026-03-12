package jdbcSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQuesryTest {

	public static void main(String[] args) throws SQLException {
		// Step 1- load/ register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		// Step 2- Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		System.out.println("Done");
		// Step 3- Create sql statement
		Statement stat = conn.createStatement();
		// step 4- execute select query and get result
		ResultSet resultSet = stat.executeQuery("select * from employee;");

		// Print all data of first, 2nd and 3rd column
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
		}

		// step 5- close execution
		conn.close();

	}
}
