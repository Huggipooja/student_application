<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-
1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update your account</title>
<style>
.heading {
color: #000080;
}
.sub {
color: #1e90ff;
}
.success
{
color:green;
}
.failure
{
color:red;
}
.buttons
{
text-decoration: none;
}
</style>
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstr
ap.min.css">
</head>
<body bgcolor='#add8e6'>
<div align="center">
 <h1 class="heading">Pentagon Space</h1>
 <h3 class="sub">Update your Account here</h3>
 <%Student s=(Student)session.getAttribute("student"); %>
 <%String success=(String)request.getAttribute("success");
 if(success!=null){%>
 <h3 class="success"><%=success%></h3>
 <%}%>
 <%String failure=(String)request.getAttribute("failure");
 if(failure!=null){%>
 <h3 class="failure"><%=failure%></h3>
 <%}%>
 <form action="updateAccount" method="post">
 <table>
 <tr>
 <td><b>Enter the name to be updated:</b></td>
 <td><input type="text" name="name"
value="<%=s.getName()%>"></td>
 </tr>
 <tr>
 <td><br></td>
 <td><br></td>
 </tr>
 <tr>
 <td><b>Enter the Phone number to be updated:</b></td>
 <td><input type="tel" name="phone"
value="<%=s.getPhone()%>"></td>
 </tr>
 <tr>
 <td><br></td>
 <td><br></td>
 </tr>
 <tr>
 <td><b>Enter the Mail ID to be updated:</b></td>
 <td><input type="email" name="mail"
value="<%=s.getMailId()%>"></td>
 </tr>
 <tr>
 <td><br></td>
 <td><br></td>
 </tr>
 <tr>
 <td><b>Enter the Branch to be updated:</b></td>
 <td><input type="text" name="branch"
value="<%=s.getBranch()%>"></td>
 </tr>
 <tr>
 <td><br></td>
 <td><br></td>
 </tr>
 <tr>
 <td><b>Enter the location to be updated:</b></td>
 <td><input type="text" name="loc"
value="<%=s.getLoc()%>"></td>
 </tr>
 <tr>
 <td><br></td>
 <td><br></td>
 </tr>
 <tr>
 <td><input class="btn btn-success" type="submit"
value="Update account"></td>
 <td align="right"><a class="btn btn-primary
buttons" href="dashboard.jsp" >Back</a></td>
 </tr>
 </table>
 </form>
</div>
</body>
</html>