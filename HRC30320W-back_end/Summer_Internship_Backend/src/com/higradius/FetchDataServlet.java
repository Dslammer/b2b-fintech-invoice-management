package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("http://localhost/dashboard/")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String URL = "jdbc:mysql://localhost:3306/invoice";
//	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	
	private static final String USER="root";
	private static final String PASSWORD = "Netid(0081";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt= null;
		ResultSet result = null;
//		
		List<Response> responserows = new ArrayList<>(); 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.createStatement();
			result = stmt.executeQuery("Select name_customer,cust_number,invoice_id,total_open_amount,due_in_date,Predicted_Payment_date,Notes from H2HBABBA3076");
					
			
			while(result.next()) {
				Response responsedata = new Response();
				responsedata.setName_customer(result.getString("name_customer"));
				responsedata.setCust_number(result.getString("cust_number"));
				responsedata.setInvoice_id(result.getLong("invoice_id"));
				responsedata.setTotal_open_amount(result.getDouble("total_open_amount"));
				responsedata.setDue_in_date(result.getString("due_in_date"));
				responsedata.setPredicted_payment_date(result.getString("Predicted_payment_date"));
				responsedata.setNotes(result.getString("Notes"));
				
				responserows.add(responsedata);
				
			}
			
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			String json = gson.toJson(responserows);
////			System.out.println(json);
//			response.setContentType("application/json");
//			response.getWriter().write(json);
//			PrintWriter out = response.getWriter();
			
			 Gson gson = new Gson();
			 String jsonData = gson.toJson(responserows);
			 PrintWriter out = response.getWriter();
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 out.print(jsonData);
			
			
			out.close();
			conn.close();
			stmt.close();
			result.close();
			
			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
