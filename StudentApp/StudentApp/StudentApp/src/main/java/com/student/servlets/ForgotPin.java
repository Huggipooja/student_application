package com.student.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import com.student.dao.StudentDAO;
import com.student.dao.StudentDaoImpl;
import com.student.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotPin")
public class ForgotPin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// collect the data from user
		String phonenumber = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm");

		// conversion of datatypes
		long phone = Long.parseLong(phonenumber);
		PrintWriter out = resp.getWriter();

		// JDBC Implementation
		StudentDAO sdao = new StudentDaoImpl();
		Student s1 = sdao.getStudent(phone, mail);
		if (s1 != null && password.equals(confirmPassword)) {
			s1.setPass(confirmPassword);
			boolean result = sdao.updateStudent(s1);
			if (result) {
				out.println("<h1>Password updated successfully</h1>");
			}

			else {
				out.println("<h1>Failed to update the password</h1>");
			}
		}
	}

}