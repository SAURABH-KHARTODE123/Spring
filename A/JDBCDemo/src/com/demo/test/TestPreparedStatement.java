package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"root","welcome");
			
			if(conn != null) {
				System.out.println("Connected");
				PreparedStatement st = conn.prepareStatement("select * from employee");
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int salary = rs.getInt(3);
					String gender = rs.getString(4);
					System.out.println(id + " " + name + " " + salary + " " + gender);
				}
				
				PreparedStatement insEmp = conn.prepareStatement("insert into employee values(?,?,?,?)");
				insEmp.setInt(1, 10);
				insEmp.setString(2, "Rahul");
				insEmp.setInt(3, 450000);
				insEmp.setString(4, "male");
				
				int n = insEmp.executeUpdate();
				if(n > 0) {
					System.out.println("added successfully...");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error message" + e.getMessage());
			e.printStackTrace();
		}

	}

}
