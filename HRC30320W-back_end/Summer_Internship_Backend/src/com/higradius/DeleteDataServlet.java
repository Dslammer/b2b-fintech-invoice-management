//package com.higradius;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class DeleteDataServlet
// */
//@WebServlet("/DeleteDataServlet")
//public class DeleteDataServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	static final String URL = "jdbc:mysql://localhost:3306/invoice";
//	
//	private static final String USER="root";
//	private static final String PASSWORD = "Netid(0081";
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DeleteDataServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter pr=response.getWriter();
//		pr.print("Hello:= Delete Data");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		String cname = request.getParameter("cname");
//		String cno = request.getParameter("cno");
//		long incno = Long.parseLong(request.getParameter("incno"));
//		double incamt = Double.parseDouble(request.getParameter("incamt"));
//		String ddt = request.getParameter("ddt");
//		
//		Connection conn = null;
//		PreparedStatement stmt=null;
//		int status=0;
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(URL,USER,PASSWORD); 
//			stmt= conn.prepareStatement("delete from H2HBABBA3076 where name_customer=? and cust_number=? and invoice_id=? and total_open_amount=? and due_in_date=?");
//			stmt.setString(1, cname);
//			stmt.setString(2, cno);
//			stmt.setLong(3, incno);
//			stmt.setDouble(4, incamt);
//			stmt.setString(5, ddt);
//			status = stmt.executeUpdate();
//			PrintWriter out = response.getWriter();
//			out.print(status+" rows Affected.");
//			
//			out.close();
//			conn.close();
//			stmt.close();
//					
//		}catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//		
//}
