package com.myproject.orm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class Reflection {

	public static void refl() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		UserDAO dao = new UserDAO();
		Autorization login = new Autorization();
		Class c = dao.getClass();
		Class l = login.getClass();
		Method[] methods = c.getDeclaredMethods();
		Method[] methods2 = l.getDeclaredMethods();
		HashMap<Integer, Method> myMap = new HashMap<Integer, Method>();
		FileOutputStream labelsFileWrite;
		Properties property = new Properties();
		labelsFileWrite = new FileOutputStream("properties/labels_test.properties");
		
		for (Integer i=0; i<methods.length; i++) {
			myMap.put(i, methods[i]);
			property.setProperty(i.toString(), methods[i].getName());
		}
		for (Integer i=0; i<methods2.length; i++) {
			myMap.put(i+methods.length, methods2[i]);
			Integer k = i+methods.length;
			property.setProperty(k.toString(), methods2[i].getName());
		}
		
		property.store(labelsFileWrite, null);
		
		FileInputStream labelsFile;
		
		while(true) {
			labelsFile = new FileInputStream("properties/labels_test.properties");
			property.load(labelsFile);
			for(Integer i=0; i<myMap.size(); i++) {
				System.out.println(i+1 + ". " + property.getProperty(i.toString()));
			}
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
						
			switch (choice) {
			case 1:
				myMap.get(0).invoke(myMap.get(0).getDeclaringClass());
				break;
			case 2:
				myMap.get(1).invoke(myMap.get(1).getDeclaringClass());
				break;
			case 3:
				myMap.get(2).invoke(myMap.get(2).getDeclaringClass());
				break;
			case 4:
				myMap.get(3).invoke(myMap.get(3).getDeclaringClass());
				break;
			case 5:
				myMap.get(4).invoke(myMap.get(4).getDeclaringClass());
				break;
			case 6:
				myMap.get(5).invoke(myMap.get(5).getDeclaringClass());
				break;
			case 7:
				myMap.get(6).invoke(myMap.get(6).getDeclaringClass());
				break;
			case 8:
				myMap.get(7).invoke(myMap.get(7).getDeclaringClass());
				break;
			case 9:
				myMap.get(8).invoke(myMap.get(8).getDeclaringClass());
				break;
			case 10:
				myMap.get(9).invoke(myMap.get(9).getDeclaringClass());
				break;
			default:
				break;
			}
			
			if (choice == 0) {
				break;
			}
		}
	}
}
