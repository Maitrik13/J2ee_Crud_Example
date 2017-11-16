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
 * Servlet implementation class EditDeleteRegisterStudent
 */
@WebServlet("/EditDeleteRegisterStudent")
public class EditDeleteRegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditDeleteRegisterStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String studentId = null;
		int successResult = 0;
		
		if("ViewData".equalsIgnoreCase(action)){
			studentId = request.getParameter("studentId");
			if(!studentId.isEmpty()){
				try {
					RegisterStudentModel getStudentDetailById = StudentManagementDao.getStudentByStudentId(studentId);
					request.setAttribute("detail", getStudentDetailById);
					RequestDispatcher rd = request.getRequestDispatcher("register_student.jsp");
					rd.include(request, response);
				} catch (StudentManagementException e) {
					System.out.println("Error occured while fetching student detail by student id :: EditDeleteRegisterStudent.doGet()"+e.getMessage());
				}
			}
		}

		if ("Edit".equalsIgnoreCase(action)) {
			studentId = request.getParameter("id");
			if (!studentId.isEmpty()) {
				RegisterStudentModel model = StudentUtil.getRegisterUserData(request);
				try {
					successResult = StudentManagementDao.updateStudentDeetail(studentId, model);
				} catch (StudentManagementException e) {
					System.out.println(
							"Error occured while deleting user at controller : EditDeleteRegisterStudent.doGet() "
									+ e.getMessage());
				}
				if (successResult == 1) {
					RequestDispatcher rd = request.getRequestDispatcher("GetRegisteredStudentsList");
					rd.include(request, response);
				} else {
					response.sendError(404);
				}

			}

		} else {
			studentId = request.getParameter("studentId");

			if (!studentId.isEmpty()) {
				try {
					successResult = StudentManagementDao.deleteStudentDetail(studentId);

				} catch (StudentManagementException e) {
					System.out.println(
							"Error occured while deleting user at controller : EditDeleteRegisterStudent.doGet() "
									+ e.getMessage());
				}
				if (successResult == 1) {
					RequestDispatcher rd = request.getRequestDispatcher("GetRegisteredStudentsList");
					rd.include(request, response);
				} else {
					response.sendError(404);
				}
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
