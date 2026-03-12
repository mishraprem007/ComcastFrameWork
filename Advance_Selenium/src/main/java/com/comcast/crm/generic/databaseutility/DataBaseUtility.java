package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;

	public void getDbConnection(String url, String username, String password) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	public void getDbConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		} catch (Exception e) {
		}
	}

	public void closeDbConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet resultSet = null;
		try {
			Statement state = conn.createStatement();
			resultSet = state.executeQuery(query);
		} catch (Exception e) {
		}
		return resultSet;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}

}
