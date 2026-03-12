package jdbcSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// Step 1- load/ register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		// Step 2- Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		System.out.println("Done");
		// Step 3- Create sql statement
		Statement stat = conn.createStatement();
		// step 4- execute Non-select query and get result
		// for Non select query we use executeUpdate() - returns 1- executed, 0 not
		// executed
		int result = stat.executeUpdate(
				"insert into employee values('NH_00438','Sr QA', '01/01/1994','test6780@gmail.com','spy','7','9934580135','hfassssssssssssssssssslg@_sakj&*****&aa','Test Project','user','mprem');");
		System.out.println(result);
		// step 5- close execution
		conn.close();

	}
}