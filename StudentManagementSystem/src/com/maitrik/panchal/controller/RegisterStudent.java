package com.maitrik.panchal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maitrik.panchal.common.util.StudentUtil;
import com.maitrik.panchal.dao.StudentManagementDao;
import com.maitrik.panchal.exception.StudentManagementException;
import com.maitrik.panchal.model.RegisterStudentModel;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet({ "/RegisterStudent", "/addStudent" })
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private static final

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterStudent() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterStudentModel studentData = StudentUtil.getRegisterUserData(request);

		try {
			int successFailResult = StudentManagementDao.registerStudent(studentData);

			if (successFailResult == 1) {
				RequestDispatcher dispatch = request.getRequestDispatcher("GetRegisteredStudentsList");
				dispatch.include(request, response);
			}
		} catch (StudentManagementException e) {
			System.out.println("Error occuredd while registering students.. Please try again after some time.. :RegisterStudent.doPost()");
		}

		doGet(request, response);
	}

}
