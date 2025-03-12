package com.student.servlets;
import java.io.IOException;
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
@WebServlet("/updateAccount")
public class UpdateAccount extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse
resp) throws ServletException, IOException {
String name=req.getParameter("name");
String phonenumber=req.getParameter("phone");
 long phone=Long.parseLong(phonenumber);
String mail=req.getParameter("mail");
String branch=req.getParameter("branch");
String loc=req.getParameter("loc");

HttpSession session=req.getSession(false);
Student s1=(Student)session.getAttribute("student");
StudentDAO sdao=new StudentDaoImpl();
if(s1!=null)
{
 s1.setName(name);
 s1.setPhone(phone);
 s1.setMailId(mail);
 s1.setBranch(branch);
 s1.setLoc(loc);
 boolean res=sdao.updateStudent(s1);
 if(res)
 {
 req.setAttribute("success","Account updated successfully");
 RequestDispatcher
rd=req.getRequestDispatcher("updateAccount.jsp");
 rd.forward(req, resp);
 }
 else
 {
 req.setAttribute("failure","Failed to update");
 RequestDispatcher
rd=req.getRequestDispatcher("updateAccount.jsp");
 rd.forward(req, resp);
 }
}
else
{
 req.setAttribute("failure","An error occured!, login again");
 RequestDispatcher
rd=req.getRequestDispatcher("updateAccount.jsp");
 rd.forward(req, resp);
}
}
}
