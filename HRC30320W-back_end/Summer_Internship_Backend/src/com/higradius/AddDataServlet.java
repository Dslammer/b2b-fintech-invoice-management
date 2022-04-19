package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDataServlet
 */
@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL = "jdbc:mysql://localhost:3306/invoice";
	
	private static final String USER="root";
	private static final String PASSWORD = "Netid(0081";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String cname = request.getParameter("cname");
		String cno = request.getParameter("cno");
		long incno = Long.parseLong(request.getParameter("incno"));
		double incamt = Double.parseDouble(request.getParameter("incamt"));
		String ddt = request.getParameter("ddt");
		String notes = request.getParameter("notes");
		
		Connection conn = null;
		PreparedStatement stmt=null;
		int status=0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD); 
			stmt= conn.prepareStatement("insert into H2HBABBA3076(name_customer,cust_number,invoice_id,total_open_amount,due_in_date,notes) values(?,?,?,?,?,?)");
			stmt.setString(1, cname);
			stmt.setString(2, cno);
			stmt.setLong(3, incno);
			stmt.setDouble(4, incamt);
			stmt.setString(5, ddt);
			stmt.setString(6, notes);
			status = stmt.executeUpdate();
			PrintWriter out = response.getWriter();
			out.print(status+" rows Affected.");
			
			out.close();
			conn.close();
			stmt.close();
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
