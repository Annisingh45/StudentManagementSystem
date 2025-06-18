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

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_Student_Management_System","root","root");
			PreparedStatement pst = con.prepareStatement("delete from student where studentId=?");
			pst.setInt(1, studentId);
			pst.executeUpdate();
			resp.sendRedirect("displayAllStudent");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {	
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
