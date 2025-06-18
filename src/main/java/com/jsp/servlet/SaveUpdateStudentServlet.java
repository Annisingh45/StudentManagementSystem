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
@WebServlet("/save-update-student")
public class SaveUpdateStudentServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		String studentName=req.getParameter("studentName");
		String studentEmail=req.getParameter("studentEmail");
		int studentAge=Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse=req.getParameter("studentCourse");
		String studentCity=req.getParameter("studentCity");
		Connection conn=null;
		try {
			
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_Student_Management_System","root","root");
			PreparedStatement pst=conn.prepareStatement("update student set studentName=?,studentEmail=?,studentAgel=?,studentCourse=?,studentCity=? where studentId=?");
			pst.setInt(6,studentId);
			pst.setString(1,studentName);
			pst.setString(2,studentEmail);
			pst.setInt(3,studentAge);
			pst.setString(4,studentCourse);
			pst.setString(5,studentCity);
			pst.execute();
			resp.sendRedirect("displayAllStudent");
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
