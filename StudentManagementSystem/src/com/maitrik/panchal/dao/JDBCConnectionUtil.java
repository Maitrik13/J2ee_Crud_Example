package com.maitrik.panchal.dao;

import java.rmi.StubNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.maitrik.panchal.exception.StudentManagementException;

public class JDBCConnectionUtil {

	public static Connection getConnection() throws StudentManagementException {

		Connection conn = null;
		String URL = "jdbc:mysql://localhost:3306/student_management";
		String USER = "root";
		String PASS = "root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		}
		catch (ClassNotFoundException e) {
			throw new StudentManagementException("Error while getting connection : Class not found : JDBCConnectionUtil.getConnection()", e);
		}
		catch (SQLException e) {
			throw new StudentManagementException("Error while getting connection : Sql Exception : JDBCConnectionUtil.getConnection()", e);
		}
		catch (Exception e) {
			throw new StudentManagementException("Error while getting connection : Unexpected Error Occure : JDBCConnectionUtil.getConnection()", e);
		}
		return conn;

	}

}
