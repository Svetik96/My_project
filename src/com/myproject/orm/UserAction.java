package com.myproject.orm;

public class UserAction {

	public static User createUser(){
		User user = new User();
		
		System.out.print("Username: ");
		user.setUsername(Validation.validUsername(ScannerCommandAdapter.newUsername()));
				
		System.out.print("Password: ");
		user.setPassword(Validation.validPassword(ScannerCommandAdapter.newPassword()));
		
		System.out.print("Email: ");
		user.setEmail(Validation.validEmail(ScannerCommandAdapter.newEmail()));
		
		System.out.print("FirstName: ");
		user.setFirstName(ScannerCommandAdapter.newFirstname());
		
		System.out.print("Surname: ");
		user.setSurname(ScannerCommandAdapter.newSurname());
		
		System.out.print("Admin role (true or false): ");
		user.setRole(ScannerCommandAdapter.newRole());
		
		return user;
	}
}
