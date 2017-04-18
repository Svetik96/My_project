package com.myproject.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Autorization_1 {

	//public static String login;
	//public static String password;
	
	public static void Login_1(){
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Password: ");
		String password = ScannerCommandAdapter.newPassword();
		
		Connection dbConnection = null;
		Statement statement = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = " + "'" + login + "'";
		String checkRole = "SELECT password FROM users WHERE username = " + "'" + login + "'";
		System.out.println(checkPassword);
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(checkPassword);
			
			if(rs.next()) {
				if(password.equals(rs.getString(1))) {
					System.out.println("Успішний вхід адміна");
				} else {
					System.out.println("Невірний пароль");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void Login_2(){
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Password: ");
		String password = ScannerCommandAdapter.newPassword();
		
		Connection dbConnection = null;
		Statement statement = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = " + "'" + login + "'";
		String checkRole = "SELECT password FROM users WHERE username = " + "'" + login + "'";
		
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(checkPassword);
			
			if(rs.next()) {
				if(password.equals(rs.getString(1))) {
					System.out.println("Успішний вхід користувача");
				} else {
					System.out.println("Невірний пароль");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void Login_3(){
		final int systemNumber = 100;
		int randomNumber = (int)(Math.random() * 100);
		System.out.print("Підказка: " + randomNumber + "\n");
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Password: ");
		int number = ScannerCommandAdapter.newNumber();
		
		int difference = systemNumber - randomNumber;
		
		Connection dbConnection = null;
		Statement statement = null;
		
		String checkLogin = "SELECT * FROM users WHERE username = " + "'" + login + "'";
		
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(checkLogin);
			
			if(rs.next()) {
				if(number == difference) {
					System.out.println("Успішний вхід користувача");
				} else {
					System.out.println("Невірне число");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void Login_4(){
		int randomNumber = 1000 + (int)(Math.random() * 9999);
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		String textMessage = "Your code for login is\n" + randomNumber;
				
		SendEmailSSL sslSender = new SendEmailSSL("ovcharuksveta@ukr.net", "svetka72");
		Connection dbConnection = null;
		Statement statement = null;
		
		String email = "SELECT email FROM users WHERE username = " + "'" + login + "'";
		
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(email);
			
			if(rs.next()) {				
				sslSender.send("Code for login", textMessage, "ovcharuksveta@ukr.net", rs.getString(1));
				
				System.out.print("Password: ");
				int number = ScannerCommandAdapter.newNumber();
				
				if(number == randomNumber) {
					System.out.println("Успішний вхід користувача");
				} else {
					System.out.println("Невірне число");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
