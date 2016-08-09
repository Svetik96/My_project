package Console;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while (true)
		{
			System.out.println("--------Menu--------");
			System.out.println("1. Add user");
			System.out.println("2. Show all users");
			System.out.println("3. Show admins");
			System.out.println("4. Show simple users");
			System.out.println("5. Change admin role");
			System.out.println("Enter 0 for exit");
			
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			switch (choice) 
			{
			case 1: DB_connection.addUser();
					break;
			case 2: DB_connection.getAllUsers();
					break;
			case 3: DB_connection.getAdmins();
					break;
			case 4: DB_connection.getSimpleUsers();
					break;
			case 5: DB_connection.changeAdminRole();
					break;
			default: break;
			}
			
			if (choice == 0)
			{
				break;
			}
			
			System.out.println();
		}

	}

}
