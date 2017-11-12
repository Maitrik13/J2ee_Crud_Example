<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h2 ALIGN="CENTER">Registration form</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="RegisterStudent" name="registerStudent" method="post">
		<table border="0" align="center">
			<tbody>

				<tr>
					<td><label for="id">Id: </label></td>
					<td><input id="id" maxlength="50" name="id" type="text" /></td>
				</tr>

				<tr>
					<td><label for="name">Name: </label></td>
					<td><input id="name" maxlength="50" name="name" type="text" /></td>
				</tr>

				<tr>
					<td><label for="course">Course: </label></td>
					<td><input id="course" maxlength="50" name="course"
						type="text" /></td>
				</tr>

				<tr>
					<td><label for="branch">Branch: </label></td>
					<td><input id="branch" maxlength="50" name="branch"
						type="text" /></td>
				</tr>

				<tr>
					<td><label for="rolln0">Rollno: </label></td>
					<td><input id="rollno" maxlength="50" name="rollno"
						type="text" /></td>
				</tr>

				<tr>
					<td><label for="email">Email_Address:</label></td>
					<td><input id="email" maxlength="50" name="email" type="text" /></td>
				</tr>

				<tr>
					<td><label for="username">User_Name:</label></td>
					<td><input id="username" maxlength="50" name="username"
						type="text" /></td>
				</tr>


				<tr>
					<td><label for="password">Password:</label></td>
					<td><input id="password" maxlength="50" name="password"
						type="password" /></td>
				</tr>

				<tr>
					<td align="right"><input name="Submit" type="Submit"
						value="Add" /></td>
				</tr>

			</tbody>
		</table>
	</form>

</body>
</html>