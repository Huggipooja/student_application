package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.student.dao.*;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")

public class Signup extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Collect the data from user
		String name = req.getParameter("name");
		String phoneNumber = req.getParameter("phone");
		String mail = req.getParameter("mail");
		String branch = req.getParameter("branch");
		String location = req.getParameter("loc");
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");
		
		//Converting neccesarry datatype
		long phone = Long.parseLong(phoneNumber);
		PrintWriter out = resp.getWriter();
		
		//JDBC Implementation
		Student s = new Student();
		StudentDAO sdao = new StudentDaoImpl();
		if(password.equals(confirm)) {
			s.setName(name);
			s.setPhone(phone);
			s.setMailId(mail);
			s.setBranch(branch);
			s.setLoc(location);
			s.setPass(password);
			boolean result=sdao.insertStudent(s);
			 if(result)
			 {
				 req.setAttribute("success", "signup successful");
				 RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				 rd.forward(req, resp);
				 
			 }
			 else
			 {
				 req.setAttribute("failure", "failed to signup");
				 RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				 rd.forward(req, resp);
			 
			 }

		}
	}

}
