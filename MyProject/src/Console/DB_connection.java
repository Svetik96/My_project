package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.beans.*;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

public class DB_connection {
	
	static Connection dbConnection = null;
	static Statement statement = null;
	
	private static Connection getConnection()
	{		
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/project_db","postgres", "deadghost199669");
			return dbConnection;
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	
	public static void getAllUsers()
	{
		String selectUser = "SELECT * FROM users";
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next())
			{				
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println("Admin: " + rs.getBoolean("role_user"));
				System.out.println();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void getAdmins()
	{
		String selectUser = "SELECT * FROM users WHERE role_user = 'true'";
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next())
			{
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void getSimpleUsers()
	{
		String selectUser = "SELECT * FROM users WHERE role_user = 'false'";
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(selectUser);
			
			while (rs.next())
			{
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void addUser()
	{		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Username: ");
		Users.setUsername(in.nextLine());
		System.out.print("Password: ");
		Users.setPassword(in.nextLine());
		System.out.print("Email: ");
		Users.setEmail(in.nextLine());
		System.out.print("First_name: ");
		Users.setFirstName(in.nextLine());
		System.out.print("Surname: ");
		Users.setSurname(in.nextLine());
		System.out.print("Adin role (true or false): ");
		Users.setRole(in.nextBoolean());
		
		String addUser = "INSERT INTO users "
				+ "(username, password_user, email, first_name, surname, role_user) "
				+ "values ('"
				+ Users.getUsername() + "', '" + Users.getPassword() + "', '" 
				+ Users.getEmail() + "', '" + Users.getFirstName() + "', '" 
				+ Users.getSurname() + "', '" + Users.getRole() + "')";
				
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(addUser);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("New user created");
	}
	
	public static void getUserByUsername()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Username for search: ");
		String usernameSearch = in.nextLine();
		
		String searchUser = "SELECT * FROM users WHERE username = " + "'" + usernameSearch + "'";
		
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(searchUser);
			
			while (rs.next())
			{
				System.out.println("username: " + rs.getString("username"));
				System.out.println("name: " + rs.getString("first_name") + " " + rs.getString("surname"));
				System.out.println("email: " + rs.getString("email"));
				System.out.println();
			}
			
			if (!rs.next())
			{
				System.out.println("User doesn't exist");
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void changeAdminRole()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String usernameSearch = in.nextLine();
		System.out.print("Enter adminRole (true or false): ");
		String adminRole = in.nextLine();
		
		String updateUser = "UPDATE users SET role_user = '" + adminRole + "' WHERE username = " + "'" + usernameSearch + "'";
		
		try
		{
			dbConnection = getConnection();
			statement = dbConnection.createStatement();
			
			statement.executeUpdate(updateUser);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Admin updated");
	}

}
