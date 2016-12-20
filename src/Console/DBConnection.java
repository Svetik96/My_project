package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

public class DBConnection {
	public static Connection getConnection(){	
		Connection dbConnection = null;
		FileInputStream configFile;
		Properties property = new Properties();
				
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			configFile = new FileInputStream("src/Console/config.properties");
			property.load(configFile);
			
			try {
				dbConnection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.login"), property.getProperty("db.password"));
				return dbConnection;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
			
		return dbConnection;
	}
}
