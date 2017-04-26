package com.myproject.orm;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	public static void addUser() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Connection dbConnection = null;
		Statement statement = null;
				
		User user = UserAction.createUser();
		
		String encryptPassword = Encryption.encrypt(user.getPassword());
		
		String addUser = "INSERT INTO users "
				+ "(username, password, email, firstName, surname, role) "
				+ "values ('"
				+ user.getUsername() + "', '" + encryptPassword + "', '" 
				+ user.getEmail() + "', '" + user.getFirstName() + "', '" 
				+ user.getSurname() + "', '" + user.getRole() + "')";
				
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(addUser);
			System.out.println("New user created");
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
	
	public static void getAllUsers(){
		Connection dbConnection = null;
		Statement statement = null;
		
		String selectUser = "SELECT * FROM users";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {				
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("firstName") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println("Admin: " + rs.getBoolean("role"));
				System.out.println();
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
	
	public static void getUserByUsername(){
		Connection dbConnection = null;
		Statement statement = null;
		
		System.out.print("Username for search: ");
		String usernameSearch = ScannerCommandAdapter.newUsername();
		
		String searchUser = "SELECT * FROM users WHERE username = " + "'" + usernameSearch + "'";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(searchUser);
			
			if(rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("firstName") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
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
	
	public static void getAdmins(){
		Connection dbConnection = null;
		Statement statement = null;
		
		String selectUser = "SELECT * FROM users WHERE role = 'true'";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("firstName") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
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
	
	public static void getSimpleUser(){
		Connection dbConnection = null;
		Statement statement = null;
		
		String selectUser = "SELECT * FROM users WHERE role = 'false'";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("firstName") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
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
	
	public static void changeAdminRole(){
		Connection dbConnection = null;
		Statement statement = null;
		
		System.out.print("Enter username: ");
		String usernameSearch = ScannerCommandAdapter.newUsername();
		System.out.print("Enter adminRole (true or false): ");
		boolean adminRole = ScannerCommandAdapter.newRole();
		
		String updateUser = "UPDATE users SET role = '" + adminRole + "' WHERE username = " + "'" + usernameSearch + "'";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(updateUser);
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
		
		System.out.println("Admin updated");
	}
}
