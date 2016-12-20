package Console;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserMethods {
	
	static Connection dbConnection = null;
	static Statement statement = null;
	
	public static void addUser(){		
		User user = new User();
		Scanner in = new Scanner(System.in);
				
		System.out.print("Username: ");
		user.setUsername(in.nextLine());
		System.out.print("Password: ");
		user.setPassword(in.nextLine());
		System.out.print("Email: ");
		user.setEmail(in.nextLine());
		System.out.print("First_name: ");
		user.setFirstName(in.nextLine());
		System.out.print("Surname: ");
		user.setSurname(in.nextLine());
		System.out.print("Adin role (true or false): ");
		user.setRole(in.nextBoolean());
		
		String addUser = "INSERT INTO users "
				+ "(username, password_user, email, first_name, surname, role_user) "
				+ "values ('"
				+ user.getUsername() + "', '" + user.getPassword() + "', '" 
				+ user.getEmail() + "', '" + user.getFirstName() + "', '" 
				+ user.getSurname() + "', '" + user.getRole() + "')";
				
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(addUser);
			
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("New user created");
	}
	
	public static void getAllUsers(){
		String selectUser = "SELECT * FROM users";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {				
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println("Admin: " + rs.getBoolean("role_user"));
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
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
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
		String selectUser = "SELECT * FROM users WHERE role_user = 'true'";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
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
		String selectUser = "SELECT * FROM users WHERE role_user = 'false'";
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
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
		
		String updateUser = "UPDATE users SET role_user = '" + adminRole + "' WHERE username = " + "'" + usernameSearch + "'";
		
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
