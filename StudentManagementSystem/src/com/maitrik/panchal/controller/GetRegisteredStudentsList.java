package com.maitrik.panchal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maitrik.panchal.dao.StudentManagementDao;
import com.maitrik.panchal.exception.StudentManagementException;
import com.maitrik.panchal.model.RegisterStudentModel;

/**
 * Servlet implementation class GetRegisteredStudentsList
 */
@WebServlet("/GetRegisteredStudentsList")
public class GetRegisteredStudentsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegisteredStudentsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<RegisterStudentModel> registerStudentList=  StudentManagementDao.getStudentLists();
			request.setAttribute("studentList", registerStudentList);
			RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
				rd.forward(request, response);
		} catch (StudentManagementException e) {
			System.out.println("Error occured while fetching record : GetRegisteredStudentsList.doGet()");
			
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
