package Console;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

	public static void main(String[] args){
		FileInputStream labelsFile;
		Properties property = new Properties();
		
		while (true) {
			try {
				labelsFile = new FileInputStream("properties/labels.properties");
				property.load(labelsFile);
				
				System.out.println(property.getProperty("menu_lbl"));
				System.out.println(property.getProperty("add_user_lbl"));
				System.out.println(property.getProperty("show_all_users_lbl"));
				System.out.println(property.getProperty("get_user_lbl"));
				System.out.println(property.getProperty("show_admins_lbl"));
				System.out.println(property.getProperty("show_users_lbl"));
				System.out.println(property.getProperty("change_role_lbl"));
				System.out.println(property.getProperty("exit_lbl"));
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
			
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			switch (choice) {
			case 1:
				UserMethods.addUser();
				break;
			case 2:
				UserMethods.getAllUsers();
				break;
			case 3:
				UserMethods.getUserByUsername();
				break;
			case 4:
				UserMethods.getAdmins();
				break;
			case 5:
				UserMethods.getSimpleUser();
				break;
			case 6:
				UserMethods.changeAdminRole();
				break;
			default:
				break;
			}
			
			if (choice == 0) {
				break;
			}
			
			System.out.println();
		}
	}
}
