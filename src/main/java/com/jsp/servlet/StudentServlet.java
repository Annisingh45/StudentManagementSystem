package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;
@WebServlet("/add-student" )
public class StudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		String studentName =req.getParameter("studentName");
		String studentEmail=req.getParameter("studentEmail");
		
		int studentAge=Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse=(req.getParameter("studentCourse"));
		String studentCity=(req.getParameter("studentCity"));
		//jdbc logic
		Connection conn=null;
		try {
			
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_Student_Management_System","root","root");
			PreparedStatement pst=conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			pst.setInt(1,studentId);
			pst.setString(2,studentName);
			pst.setString(3,studentEmail);
			pst.setInt(4,studentAge);
			pst.setString(5,studentCourse);
			pst.setString(6,studentCity);
			pst.execute();
			resp.sendRedirect("index.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

	}
			
		

		

