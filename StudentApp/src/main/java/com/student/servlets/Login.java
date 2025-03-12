package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.student.dao.StudentDAO;

import com.student.dao.StudentDaoImpl;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Creation of session Object
		HttpSession session = req.getSession();
		
		
		
		// collect the data from the user
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();

		// jdbc implementation
		StudentDAO sdao = new StudentDaoImpl();
		Student s = sdao.getStudent(mail, password);
		if (s != null) {
			
			//By using SendRedirect Method 
//			req.setAttribute("student", s);
//			RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
//			rd.forward(req, resp);
			
			
			//By using Session Method
			session.setAttribute("student", s);
			RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
			
		} else {
			
			//By using Sendredirect Method
//			req.setAttribute("failure", "Login Failed");
//			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//			rd.forward(req, resp);
			
			
			//By using Session method
			session.setAttribute("failure", "Login Failed");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}