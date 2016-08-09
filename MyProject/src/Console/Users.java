package Console;

public class Users {
	
	private static String username;
	private static String password;
	private static String email;
	private static String first_name;
	private static String surname;
	private static boolean role;
	
/*	public Users(String username, String password, String email, String first_name, String surname, boolean role)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.surname = surname;
		this.role = role;
	}
*/	
	public static void setUsername(String username1)
	{
		username = username1;
	}
	
	public static void setPassword(String password1)
	{
		password = password1;
	}
	
	public static void setEmail(String email1)
	{
		email = email1;
	}
	
	public static void setFirstName(String first_name1)
	{
		first_name = first_name1;
	}
	
	public static void setSurname(String surname1)
	{
		surname = surname1;
	}
	
	public static void setRole(boolean role1)
	{
		role = role1;
	}
	
	public static String getUsername()
	{
		return username;
	}
	
	public static String getPassword()
	{
		return password;
	}
	
	public static String getEmail()
	{
		return email;
	}
	
	public static String getFirstName()
	{
		return first_name;
	}
	
	public static String getSurname()
	{
		return surname;
	}
	
	public static boolean getRole()
	{
		return role;
	}

}
