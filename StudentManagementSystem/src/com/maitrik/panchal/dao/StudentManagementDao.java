package com.maitrik.panchal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maitrik.panchal.exception.StudentManagementException;
import com.maitrik.panchal.model.RegisterStudentModel;

public class StudentManagementDao {

	public static int registerStudent(RegisterStudentModel registerStudentModel) throws StudentManagementException {

		int result = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		String query = "insert into ";
		conn = JDBCConnectionUtil.getConnection();

		try {
			ps = conn.prepareStatement("insert into student_register values(null,?,?,?,?,?,?,?,?)");
			ps.setString(1, registerStudentModel.getId());
			ps.setString(2, registerStudentModel.getStudentName());
			ps.setString(3, registerStudentModel.getCourse());
			ps.setString(4, registerStudentModel.getBranch());
			ps.setString(5, registerStudentModel.getRollNumber());
			ps.setString(6, registerStudentModel.getEmail());
			ps.setString(7, registerStudentModel.getUserName());
			ps.setString(8, registerStudentModel.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new StudentManagementException(
					"Error occured while registering student : StudentManagementDao.registerStudent() : SQL Exception : ",
					e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new StudentManagementException(
						"Error occured while closing Prepared statement : StudentManagementDao.registerStudent() : Unexpected Exception : ",
						e);
			}
		}
		return result;

	}

	public static List<RegisterStudentModel> getStudentLists() throws StudentManagementException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<RegisterStudentModel> studentList = new ArrayList<>();

		conn = JDBCConnectionUtil.getConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from student_register");

			while (rs.next()) {
				RegisterStudentModel model = new RegisterStudentModel();
				model.setId(rs.getString("id"));
				model.setStudentName(rs.getString("name"));
				model.setCourse(rs.getString("course"));
				model.setBranch(rs.getString("branch"));
				model.setRollNumber(rs.getString("roll_number"));
				model.setEmail(rs.getString("email"));
				model.setUserName(rs.getString("userName"));
				model.setPassword(rs.getString("password"));

				studentList.add(model);
			}
		} catch (SQLException e) {
			throw new StudentManagementException(
					"Error occured while fetching List of students : StudentManagementDao.getStudentLists() : SQl Exception "+e.getMessage(),
					e);
		}
		return studentList;

	}

	public static int deleteStudentDetail(String studentId) throws StudentManagementException {

		Connection conn = null;
		Statement st = null;
		int result = 0;
		
		conn = JDBCConnectionUtil.getConnection();
		try {
			st = conn.createStatement();
		result = st.executeUpdate("delete from student_register where id = "+studentId);
		} catch (SQLException e) {
			throw new StudentManagementException("Error occured while ddeleteing user : SQL Exception : StudentManagementDao.deleteStudentDetail() : "+e.getMessage(), e);
		}
		return result;
	}

	public static int updateStudentDeetail(String studentId, RegisterStudentModel model) throws StudentManagementException {
		
		Connection conn = null;
		Statement st = null;
		int result = 0;
		
		conn = JDBCConnectionUtil.getConnection();
		try {
			st = conn.createStatement();
		result = st.executeUpdate("update student_register set name='"+model.getStudentName()+"' , course = '"+model.getCourse()+"'"
				+ ", branch = '"+model.getBranch()+"' , roll_number = '"+model.getRollNumber()+"'"
						+ " ,email = '"+model.getEmail()+"' , userName = '"+model.getUserName()+"' "
								+ ", password = '"+model.getPassword()+"'where id = "+studentId);
		} catch (SQLException e) {
			throw new StudentManagementException("Error occured while updating user : SQL Exception : StudentManagementDao.updateStudentDeetail() : "+e.getMessage(), e);
		}
		return result;
	}

	public static RegisterStudentModel getStudentByStudentId(String studentId) throws StudentManagementException {

		RegisterStudentModel studentDetail = new RegisterStudentModel();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCConnectionUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from student_register where id="+studentId);
			
			while(rs.next()){
				studentDetail.setId(rs.getString("id"));
				studentDetail.setStudentName(rs.getString("name"));
				studentDetail.setCourse(rs.getString("course"));
				studentDetail.setBranch(rs.getString("branch"));
				studentDetail.setRollNumber(rs.getString("roll_number"));
				studentDetail.setEmail(rs.getString("email"));
				studentDetail.setUserName(rs.getString("userName"));
				studentDetail.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new StudentManagementException("Error occured while fetching user detail by student id : SQL Exception : StudentManagementDao.getStudentByStudentId() : "+e.getMessage(), e);
		}
		
		
		
		return studentDetail;
	}

}
