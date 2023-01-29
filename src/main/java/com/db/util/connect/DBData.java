package com.db.util.connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBData {

	public static void main(String[] args) throws Throwable {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select salary from employees");

		List<String> columnValue = new ArrayList<String>();

		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));
				columnValue.add(rs.getString(1));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// System.out.println(columnValue);
		// step5 close the connection object

		System.out.println(columnValue);
	}
	

}
