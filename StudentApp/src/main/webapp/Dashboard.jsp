<%@page import="com.student.dto.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initialscale=1.0">
 <title>Student Management</title>
 <link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstr
ap.min.css"
 rel="stylesheet">
</head>
<body>
<%Student s=(Student)request.getAttribute ("Student");%>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
 <div class="container-fluid">
 <a class="navbar-brand" href="#">Welcome </a>
 
 <button class="navbar-toggler" type="button" data-bstoggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle
navigation">
 <span class="navbar-toggler-icon"></span>
 </button>
 <div class="collapse navbar-collapse" id="navbarNav">
 <ul class="navbar-nav ms-auto">
 <li class="nav-item">
 <a class="nav-link" href="forgotPin.jsp">Reset
Password</a>
 </li>
 <li class="nav-item">
 <a class="nav-link" href="updateAccount.jsp">Update
Data</a>
 </li>
 <li class="nav-item">
 <a class="btn btn-danger" href="#">Logout</a>
 </li>
 </ul>
 </div>
 </div>
 </nav>
 <div class="container mt-4">
 <h1 class="text-center mb-4">Dashboard</h1>
</div>
<!-- User Section -->
 <div class="row">
 <div class="col-md-12">
 <h3>View Your Data</h3>
 <table class="table table-hover">
 <thead>
 <tr>
 <th>Id</th>
 <th>Name</th>
 <th>Phone</th>
 <th>Mail ID</th>
 <th>Branch</th>
 <th>Location</th>
 </tr>
 </thead>
 <tbody>
 <tr>
 <td><%=s.getId() %></td>
 <td><%=s.getName() %></td>
 <td><%=s.getPhone() %></td>
 <td><%=s.getMailId() %></td>
 <td><%=s.getBranch() %></td>
 <td><%=s.getLoc() %></td>
 
 </tr>
 </tbody>
 </table>
 </div>
 </div>
</body>
</html>