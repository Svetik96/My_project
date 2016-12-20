package Console;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		while (true) {
			System.out.println("--------Menu--------");
			System.out.println("1. Add user");
			System.out.println("2. Show all users");
			System.out.println("3. Get user by username");
			System.out.println("4. Show admins");
			System.out.println("5. Show simple users");
			System.out.println("6. Change admin role");
			System.out.println("Enter 0 for exit");
			
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
