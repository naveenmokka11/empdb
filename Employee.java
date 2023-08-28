package com.tasks.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loding and Rigister is Completed properly");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3307/emp";
		String username = "root";
		String pwd = "root";
		System.out.println("would you like to inset data into Emp Database");
		String choice=sc.next().toLowerCase();
		switch(choice) {
		case "yes":{
		try {
			Connection con = DriverManager.getConnection(url, username, pwd);
			System.out.println("connection Establishing is completed properly");
			Statement sta = con.createStatement();
			System.out.println("Enter Employee id");
			String id = sc.next();
			System.out.println("Enter Employee Name");
			String name = sc.next();
			System.out.println("Enter Employee job");
			String job = sc.next();
			System.out.println("Enter Employee Email");
			String mail = sc.next();
			System.out.println("Enter Employee Phone");
			String phone = sc.next();
			sta.execute("insert into emp values(" + id + "," + name + "," + job + "," + mail + "," + phone + ")");
			//sta.execute("insert into emp values(4,'varun','hr','varun@gmail.com',79885690)");
			System.out.println(" 1 row data insertion is done");
			sta.close();
			con.close();
		
			}
		catch (SQLException e) {
			e.printStackTrace();
			}
		
			}

				
		case "no":{
			System.out.println("Applaction is terminated !!");
		}
		if(choice=="no") {
			break;
		}
		sc.close();

	}

 }
}
