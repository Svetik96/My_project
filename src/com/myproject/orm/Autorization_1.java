package com.myproject.orm;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Autorization_1 {
	
	public static void Login_1() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Password: ");
		String password = ScannerCommandAdapter.newPassword();
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementRole = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = ?";
		String checkRole = "SELECT role FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(checkPassword);
			preparedStatement.setString(1, login);
			preparedStatementRole = dbConnection.prepareStatement(checkRole);
			preparedStatementRole.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			ResultSet rsRole = preparedStatementRole.executeQuery();
			
			
			if(rsRole.next() && rsRole.getBoolean(1) == true) {
				rs.next();
				if(Encryption.verifyPassword(rs.getString(1), password)) {
					System.out.println("Successful entry");
				} else {
					System.out.println("Incorrect password");
				}
			} else {
				System.out.println("You are not admin");
			}
			
			rs.close();
			rsRole.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
	
	public static void Login_2() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Password: ");
		String password = ScannerCommandAdapter.newPassword();
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String checkPassword = "SELECT password FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(checkPassword);
			preparedStatement.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				if(Encryption.verifyPassword(rs.getString(1), password)) {
					System.out.println("Successful entry");
				} else {
					System.out.println("Incorrect password");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
		System.out.print("Hint: " + randomNumber + "\n");
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		System.out.print("Numeric: ");
		int number = ScannerCommandAdapter.newNumber();
		
		int difference = systemNumber - randomNumber;
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String checkLogin = "SELECT COUNT(id) FROM users WHERE username = ?";
		
		if(number == difference) {
			try {
				dbConnection = DBConnection.getConnection();
				preparedStatement = dbConnection.prepareStatement(checkLogin);
				preparedStatement.setString(1, login);
				
				ResultSet rs = preparedStatement.executeQuery();
				
				if((rs.next()) && rs.getInt(1) == 1) {
					System.out.println("Successful entry");
				} else {
					System.out.println("User doesn't exist");
				}
				
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
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
		} else {
			System.out.println("Incorrect numeric");
		}
	}
	
	public static void Login_4(){
		int randomNumber = 1000 + (int)(Math.random() * 9999);
		System.out.print("Username: ");
		String login = ScannerCommandAdapter.newUsername();
		String textMessage = "Your code for login is\n" + randomNumber;
				
		SendEmailSSL sslSender = new SendEmailSSL(PropertyProvider.getInstance().getProperty("email.login"), 
										PropertyProvider.getInstance().getProperty("email.password"));
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String email = "SELECT email FROM users WHERE username = ?";
		
		try {
			dbConnection = DBConnection.getConnection();
			preparedStatement = dbConnection.prepareStatement(email);
			preparedStatement.setString(1, login);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {				
				sslSender.send("Code for login", textMessage, PropertyProvider.getInstance().getProperty("email.login"), rs.getString(1));
				System.out.println("Letter was sent.");
				System.out.print("Code: ");
				int number = ScannerCommandAdapter.newNumber();
				
				if(number == randomNumber) {
					System.out.println("Successful entry");
				} else {
					System.out.println("Incorrect code");
				}
			} else {
				System.out.println("User doesn't exist");
			}
			
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
