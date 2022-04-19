//package com.higradius;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
///**
// * Servlet implementation class dummyServlet
// */
//@WebServlet("/dummyServlet")
//public class DummyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	static final String URL = "jdbc:mysql://localhost:3306/lab";
////	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
//	
//	private static final String USER="root";
//	private static final String PASSWORD = "Netid(0081";
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DummyServlet() {
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
////		 String name = request.getParameter("name");
////		 Response resp = new Response();
////		 resp.setName(name);
////		 Gson gson = new Gson();
////		 String data = gson.toJson(resp);
////		 PrintWriter out = response.getWriter();
////		 response.setContentType("application/json");
////		 response.setCharacterEncoding("UTF-8");
////		 out.print(data);
////		 out.flush();
//		
//		Connection conn = null;
//		Statement stmt= null;
//		ResultSet result = null;
////		
//		List<Response> responserows = new ArrayList<>(); 
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(URL,USER,PASSWORD);
//			stmt = conn.createStatement();
//			result = stmt.executeQuery("Select * from emp");
//					
//			
//			while(result.next()) {
//				Response responsedata = new Response();
//				responsedata.setEno(result.getInt("empno"));
//				responsedata.setEname(result.getString("ename"));
//				responsedata.setJob(result.getString("job"));
//				responserows.add(responsedata);
//				
//			}
//			
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			String json = gson.toJson(responserows);
////			System.out.println(json);
//			response.setContentType("application/json");
//			response.getWriter().write(json);
//			PrintWriter out = response.getWriter();
//			out.println();
//			
//			conn.close();
//			stmt.close();
//			result.close();
//			
//			
//		}catch (Exception ex) {
//			// TODO: handle exception
//			ex.printStackTrace();
//		}
//		
//	}
//
//}
