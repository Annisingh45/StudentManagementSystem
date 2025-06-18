package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;
@WebServlet("/displayAllStudent")
public class DisplayAllStudentsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_Student_Management_System","root","root");
			PreparedStatement pst=conn.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			req.setAttribute("resultSet", rs);
			RequestDispatcher rd =req.getRequestDispatcher("displayAllStudent.jsp");
			rd.forward(req,resp);
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
			
		

