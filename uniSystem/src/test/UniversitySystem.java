package test;

import java.io.*;
import java.util.*;

import additional.*;
import data.Data;
import enums.UserType;
import users.*;

public class UniversitySystem {

	private ResourceBundle messages;
	private Locale locale;
	private UserFactory userFactory;
	Data data = Data.getInstance();

	public UniversitySystem() {
		super();
		this.userFactory = new UserFactory();
	}
	
	
	public void menuUser(User user) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int choice;

	    while(true) {
	        System.out.println("User Menu:");
	        System.out.println("1. View Personal Information");
	        System.out.println("2. Edit Personal Information");
	        System.out.println("3. View News");
	        System.out.println("4. View University Journal");
	        System.out.println("5. Subscribe to Journal");
	        System.out.println("6. Logout");
	        System.out.println("Enter your choice:");

	        try {
	            choice = Integer.parseInt(reader.readLine());

	            switch (choice) {
	                case 1:
	                    System.out.println(user.toString());
	                    break;
	                case 2:
	                    user.editData();
	                    break;
	                case 3:
	                    user.viewNews();
	                    break;
	                case 4:
	                    user.viewUniversityJournal();
	                    break;
	                case 5:
	                    // Assuming the method to subscribe to journal
//	                    user.subscribeToJournal(subscribedJournals);
	                    break;
	                case 6:
	                    return; // Exit from user menu
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("An error occurred. Please try again.");
	        }
	    }
	}
	public void menuStudent(Student student) {
		
	}
	
	public void menuEmployee(Employee employee) {

	}

	public void logIn() {
		changeLanguage();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println(messages.getString("enterLogin"));
			String login = reader.readLine();

			System.out.println(messages.getString("enterPassword"));
			String password = reader.readLine();

			// Use the UserFactory to create or retrieve the user
			User user = userFactory.createUser(login, password);
			if (user instanceof Student) {
				Student student = (Student) user;
				menuStudent(student);

			} else if (user instanceof Student) {
				Employee employee = (Employee) user;
				menuEmployee(employee);
			}
			menuUser(user);
			
//			System.out.println(messages.getString("loginSuccess"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void logOut() {
	}

	public void changeLanguage() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please choose a language:");
			System.out.println("1. English");
			System.out.println("2. Russian");
			System.out.println("3. Spanish");
			System.out.println("4. Kazakh");

			int languageChoice = Integer.parseInt(reader.readLine());

			switch (languageChoice) {
			case 1:
				locale = new Locale.Builder().setLanguage("en").build();
				break;
			case 2:
				locale = new Locale.Builder().setLanguage("ru").build();
				break;
			case 3:
				locale = new Locale.Builder().setLanguage("es").build();
				break;
			case 4:
				locale = new Locale.Builder().setLanguage("kz").build();
				break;
			default:
				System.out.println("Invalid choice. Using default locale (English).");
				locale = new Locale.Builder().setLanguage("en").build();
				break;
			}

			// Load messages based on the selected locale
			this.messages = ResourceBundle.getBundle("messages", locale);

			System.out.println(messages.getString("welcomeMessage"));
			System.out.println(messages.getString("loginPrompt"));

			// Your login logic here
//                System.out.println(messages.getString("invalidChoice"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
	    UniversitySystem universitySystem = new UniversitySystem();
	    File dataFile = new File("data.ser");

	    if (dataFile.exists() && !dataFile.isDirectory()) {
	        // If file exists, load the data
	        Data.getInstance().loadFromFile("data.ser");
	    } else {
	        // If file does not exist, create and initialize it
	        System.out.println("Data file not found. Creating a new file.");

	        // Initialize your Data instance here
	        // For example, you could initialize it with default values or a new Data object
	        // Data instance = new Data(); // or any other initial setup

	        // Then save this instance to create the file
	        Data.getInstance().saveToFile("data.ser");
	    }

	    universitySystem.logIn();

	    // Save the Data instance at the end of the program
	    Data.getInstance().saveToFile("data.ser");
	}
}
