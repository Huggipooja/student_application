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

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// collect the data from the user
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();

		// jdbc implementation
		StudentDAO sdao = new StudentDaoImpl();
		Student s = sdao.getStudent(mail, password);
		if (s != null) {
			resp.sendRedirect("success.html");
		} else {
			resp.sendRedirect("failure.html");
		}
	}
}