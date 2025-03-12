package com.student.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.student.dto.Student;
import com.student.connectors.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDaoImpl implements StudentDAO{
	private Connection con;
	
	
	public StudentDaoImpl() {
		this.con = ConnectorFactory.requestConnection();
	}

	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		
		String query = "INSERT INTO STUDENT2 VALUES(0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps = null;
		int res = 0;
		try {
			ps=con.prepareStatement(query); //platform
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMailId());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6,s.getPass());
			res = ps.executeUpdate(); //execute
			
			System.out.println(res + " row affected");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res >0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		String query  = "UPDATE STUDENT2 SET PASSWORD = ? WHERE PHONE = ?";
		PreparedStatement ps = null;
		int res = 0;
		try {
			ps.setString(1, s.getPass());
			ps.setLong(2, s.getPhone());
			res = ps.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Student s) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM TABLE WHERE ID = ?";
		PreparedStatement ps = null;
		int res = 0;
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, s.getId());
			res = ps.executeUpdate();
			System.out.println(res + " row affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String mail, String pass) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM STUDENT2 WHERE MAILID = ? AND PASSWORD = ?";
		Student s =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));;
				s.setPhone(rs.getLong(3)); 
				s.setMailId(rs.getString(4)); 
				s.setBranch(rs.getString(5)); 
				s.setLoc(rs.getString(6));
				s.setPass(rs.getString(7));
				s.setDate(rs.getString(8));
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList <Student>();
		Student s = null;
		String query = "SELECT * FROM STUDENT2";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));;
				s.setPhone(rs.getLong(3)); 
				s.setMailId(rs.getString(4)); 
				s.setBranch(rs.getString(5)); 
				s.setLoc(rs.getString(6));
				s.setPass(rs.getString(7));
				s.setDate(rs.getString(8));
				students.add(s);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
	
	@Override
	public Student getStudent(long phone, String mail) {
	 String query="SELECT * FROM STUDENT1 WHERE PHONE=? AND MAIL=?";
	 Student s=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 try {
	 ps=con.prepareStatement(query);
	 ps.setLong(1, phone);
	 ps.setString(2, mail);
	 rs=ps.executeQuery();
	 while(rs.next())
	 {
	 s=new Student();
	 //String name=rs.getString("name");
	 //s.setName(name);
	 s.setId(rs.getInt("id"));
	 s.setName(rs.getString("name"));
	 s.setPhone(rs.getLong("phone"));
	 s.setMailId(rs.getString("mail"));
	 s.setBranch(rs.getString("branch"));
	 s.setLoc(rs.getString("location"));
	 s.setPass(rs.getString("password"));
	 s.setDate(rs.getString("date"));
	 }
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return s;
	}

	
	
	

}
