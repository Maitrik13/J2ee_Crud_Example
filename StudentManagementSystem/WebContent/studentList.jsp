<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>

	<table border="3">
		<tr>
		<th>Student Name</th>
		<th>Student Course</th>
		<th>Student Branch</th>
		<th>Student Roll_Number</th>
		<th>Student Email</th>
		<th>Student UserName</th>
		<th>Student Password</th>
		<th> Action</th>
		</tr>
		
		<c:forEach var="studentList" items="${studentList}">
		<tr>
			<td>${studentList.studentName }</td>
			<td>${studentList.course }</td>
			<td>${studentList.branch }</td>
			<td>${studentList.rollNumber }</td>
			<td>${studentList.email }</td>
			<td>${studentList.userName }</td>
			<td>${studentList.password }</td>
			<td>
			<a href="EditDeleteRegisterStudent?action=edit&studentId=<c:out value="${studentList.id}"/>">Edit</a>
			<a href="EditDeleteRegisterStudent?action=delete&studentId=<c:out value="${studentList.id }"/>">Delete</a>
			</td>
			</tr>		
	</c:forEach>
	</table>

	

</body>
</html>