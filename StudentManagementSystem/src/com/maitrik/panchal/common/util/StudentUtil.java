package com.maitrik.panchal.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.maitrik.panchal.model.RegisterStudentModel;
import com.maitrik.panchal.validator.util.ValidatorUtil;

public class StudentUtil {

	
	public static RegisterStudentModel getRegisterUserData(HttpServletRequest request) {

		RegisterStudentModel registerStudentModel = new RegisterStudentModel();

		String registerId = request.getParameter("id");
		String studentName = request.getParameter("name");
		String studentCourse = request.getParameter("course");
		String studentBranch = request.getParameter("branch");
		String studentReollNumber = request.getParameter("rollno");
		String studentEmail = request.getParameter("email");
		String studentUserName = request.getParameter("username");
		String studentPassword = request.getParameter("password");

		List<String> validateData = new ArrayList<>();
		validateData.add(registerId);
		validateData.add(studentName);
		validateData.add(studentCourse);
		validateData.add(studentBranch);
		validateData.add(studentReollNumber);
		validateData.add(studentEmail);
		validateData.add(studentUserName);
		validateData.add(studentPassword);

		boolean validateNullEmptyData = ValidatorUtil.validateNullEmptyString(validateData);

		if (validateNullEmptyData) {
			registerStudentModel = new RegisterStudentModel(registerId, studentName, studentCourse, studentBranch,
					studentReollNumber, studentEmail, studentUserName, studentPassword);
		}

		return registerStudentModel;
	}

}
