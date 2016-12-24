package Console;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

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
				UserDAO.addUser();
				break;
			case 2:
				UserDAO.getAllUsers();
				break;
			case 3:
				UserDAO.getUserByUsername();
				break;
			case 4:
				UserDAO.getAdmins();
				break;
			case 5:
				UserDAO.getSimpleUser();
				break;
			case 6:
				UserDAO.changeAdminRole();
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
