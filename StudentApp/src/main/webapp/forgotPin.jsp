<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;
}
</style>
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Update your password here</h3>
		<form action="forgotPin" method="post">
		<%String success=(String)request.getAttribute("success");
		if(success!=null){%>
		<h3 class="success"><%=success %></h3>
		<%} %>
		<%String failure=(String)request.getAttribute("failure");
		if(failure!=null){%>
		<h3 class="failure"><%=failure %></h3>
		<%} %>
			<table>
				<tr>
					<td><b>Enter the Phone number:</b></td>

					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter a new password:</b></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>

				<tr>
					<td><b>Confirm the password:</b></td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Pin"></td>
					<td><a href="login.html">Back</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>