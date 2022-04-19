package com.higradius;
import java.sql.*;

public class Response {

	private String name_customer;
	private String cust_number;
	private long invoice_id;
	private double total_open_amount;
	private String due_in_date;
	private String Predicted_payment_date;
	private String Notes;
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(double total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	public String getPredicted_payment_date() {
		return Predicted_payment_date;
	}
	public void setPredicted_payment_date(String predicted_payment_date) {
		this.Predicted_payment_date = predicted_payment_date;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	



}
//public static void main(String[] args) throws Exception {
//			// TODO Auto-generated method stub
//			String url = "jdbc:mysql://localhost:3306/lab";
//			String uname="root";
//			String pass= "Netid(0081";
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url,uname,pass);
//			PreparedStatement pst = con.prepareStatement("update emp set sal=? where empno=?");
//			pst.setInt(1,45000);
//			pst.setInt(2, 2);
//			
//			int i = pst.executeUpdate();
//			System.out.println("Rows Affected: "+i);
//			
//			
//			Statement st = con.createStatement();
//			ResultSet result = st.executeQuery("select * from emp");
//			while(result.next()) {	
//				System.out.println("empno: "+result.getInt(1)+" ename: "+result.getString(2)+" job: "+result.getString(3)+" deptno: "+result.getInt(4)+" Sal: "+result.getInt(5));
//			
//			}
//			con.close();
//			pst.close();
//			result.close();
//			
//			
//}

//
//
//

