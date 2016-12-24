package Console;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean checkUsernameRepeats(String username){
		Connection dbConnection = null;
		Statement statement = null;
		
		boolean b = true;
		List<String> names = new ArrayList();
		String allUsernames = "SELECT username FROM users";
		
		try {
			dbConnection = DBConnection.getConnection();
			statement = dbConnection.createStatement();
			
			ResultSet rs = statement.executeQuery(allUsernames);
			
			while (rs.next()) {
				names.add(rs.getString(1));
			}
			rs.close();
			statement.close();
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for (int i=0; i<names.size(); i++) {
			if (username.equals(names.get(i))) {
				b = false;
				break;
			}
		}
			
		return b;
	}
	
	public static boolean checkUsernameAndPassword(String line){
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u005F]*[a-zA-Z\\d]{1}");
		Matcher m = p.matcher(line);
		return m.matches();
	}
	
	public static boolean checkEmail(String email){
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F\\u002D]*+@[A-Za-z0-9-]+(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static String validUsername(String username){
		boolean b = false;
		Scanner in = new Scanner(System.in);
		
		while (b == false) {
			if ((Validation.checkUsernameRepeats(username) == true) &&
				(Validation.checkUsernameAndPassword(username) == true)) {
				b = true;
			} else if (Validation.checkUsernameRepeats(username) == false) {
				System.out.print("This username is already exist, please, write again: ");
				username = in.nextLine();
			} else if (Validation.checkUsernameAndPassword(username) == false) {
				System.out.print("Invalid username, please, write again: ");
				username = in.nextLine();
			}
		}
		return username;
	}
	
	public static String validPassword(String password){
		Scanner in = new Scanner(System.in);
		
		if (Validation.checkUsernameAndPassword(password) == true){
			return password;
		} else {
			while (Validation.checkUsernameAndPassword(password) == false) {
				System.out.print("Invalid password, please, write again: ");
				password = in.nextLine();
				if (Validation.checkUsernameAndPassword(password) == true){
					return password;
				}
			}
		}
		return password;
	}
	
	public static String validEmail(String email){
		Scanner in = new Scanner(System.in);
		
		if (Validation.checkEmail(email) == true){
			return email;
		} else {
			while (Validation.checkEmail(email) == false) {
				System.out.print("Invalid email, please, write again: ");
				email = in.nextLine();
				if (Validation.checkEmail(email) == true){
					return email;
				}
			}
		}
		return email;
	}
}
