package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDataServlet
 */
@WebServlet("/EditData")
public class EditDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL = "jdbc:mysql://localhost:3306/invoice";
	
	private static final String USER="root";
	private static final String PASSWORD = "Netid(0081";
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String cname = request.getParameter("editcname");
		String cno = request.getParameter("editcno");
		long incno = Long.parseLong(request.getParameter("editincno"));
		double incamt = Double.parseDouble(request.getParameter("editincamt"));
		String ddt = request.getParameter("editddt");
		double editincamt= Double.parseDouble(request.getParameter("editInvoiceAmt"));
		String editnotes = request.getParameter("editInvoiceNote");
		Connection conn = null;
		PreparedStatement stmt=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD); 
			stmt= conn.prepareStatement("UPDATE H2HBABBA3076 SET total_open_amount=?,notes=? WHERE name_customer=? AND cust_number=? AND invoice_id=? AND total_open_amount=? AND due_in_date=?");
			stmt.setDouble(1,editincamt);
			stmt.setString(2, editnotes);
			stmt.setString(3, cname);
			stmt.setString(4, cno);
			stmt.setLong(5, incno);
			stmt.setDouble(6, incamt);
			stmt.setString(7,ddt);
			stmt.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println(cname+cno+incno+incamt+ddt+editincamt+editnotes);
			
			out.close();
			conn.close();
			stmt.close();
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

		
		
}
