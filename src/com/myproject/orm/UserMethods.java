package com.myproject.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserMethods {
	
	static Connection dbConnection = null;
	static Statement statement = null;
	
	public static void addUser(){		
		User user = new User();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Username: ");
		user.setUsername(Validation.validUsername(in.nextLine()));
				
		System.out.print("Password: ");
		user.setPassword(Validation.validPassword(in.nextLine()));
		
		System.out.print("Email: ");
		user.setEmail(Validation.validEmail(in.nextLine()));
		
				
		System.out.print("FirstName: ");
		user.setFirstName(in.nextLine());
		System.out.print("Surname: ");
		user.setSurname(in.nextLine());
		System.out.print("Admin role (true or false): ");
		user.setRole(in.nextBoolean());
		
		String addUser = "INSERT INTO users "
				+ "(username, password, email, firstName, surname, role) "
				+ "values ('"
				+ user.getUsername() + "', '" + user.getPassword() + "', '" 
				+ user.getEmail() + "', '" + user.getFirstName() + "', '" 
				+ user.getSurname() + "', '" + user.getRole() + "')";
				
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(addUser);
			System.out.println("New user created");
			
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAllUsers(){
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
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getUserByUsername(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Username for search: ");
		String usernameSearch = in.nextLine();
		
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
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAdmins(){
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
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getSimpleUser(){
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
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void changeAdminRole(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String usernameSearch = in.nextLine();
		System.out.print("Enter adminRole (true or false): ");
		String adminRole = in.nextLine();
		
		String updateUser = "UPDATE users SET role = '" + adminRole + "' WHERE username = " + "'" + usernameSearch + "'";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(updateUser);
			
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Admin updated");
	}
}
