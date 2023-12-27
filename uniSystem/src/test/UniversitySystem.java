package test;

import java.io.*;
import java.util.*;

import additional.*;
import course.Course;
import data.Data;
import enums.Faculties;
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
	        System.out.println("7. View comments");
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
	                	logOut();
	                    return; // Exit from user menu
	                case 7:
//	                	user.viewComments private method
	                    return; 
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("An error occurred. Please try again.");
	        }
	    }
	}
	public void menuStudent(Student student) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int choice;

	    while (true) {
	        System.out.println("Student Menu:");
	        System.out.println("1. View Personal Information");
	        System.out.println("2. Edit Personal Information");
	        System.out.println("3. View Courses");
	        System.out.println("4. Register for a Course");
	        System.out.println("5. View Transcript");
	        System.out.println("6. View Marks");
	        System.out.println("7. Rate a Teacher");
	        System.out.println("8. View Schedule");
	        System.out.println("9. Join Student Organization");
	        System.out.println("10. Leave Student Organization");
	        System.out.println("11. Become Head of Organization");
	        System.out.println("12. Logout");
	        System.out.println("Enter your choice:");

	        try {
	            choice = Integer.parseInt(reader.readLine());

	            switch (choice) {
	                case 1:
	                    System.out.println(student.toString());
	                    break;
	                case 2:
	                    student.editData();
	                    break;
	                case 3:
	                    student.viewCourses();
	                    break;
	                case 4:
	                    System.out.println("Enter codeCourse:");
	                    String codeCourse = reader.readLine();
	                    System.out.println("Enter nameCourse:");
	                    String nameCourse = reader.readLine();
	                    System.out.println("Choose faculty (SITE, BS, SEOGI, SG, ISE, SMSGT, SAM, SCE, KMA):");
	                    String facultyInput = reader.readLine().toUpperCase();

	                    Faculties faculty;
	                    if (facultyInput.equals("SITE")) {
	                        faculty = Faculties.SITE;
	                    } else if (facultyInput.equals("BS")) {
	                        faculty = Faculties.BS;
	                    } else if (facultyInput.equals("SEOGI")) {
	                        faculty = Faculties.SEOGI;
	                    } // Add other faculties here
	                    else {
	                        System.out.println("Invalid faculty. Please try again.");
	                        break;
	                    }

	                    student.registerToCourse(new Course(codeCourse, nameCourse, faculty));
	                    break;

	                case 5:
	                    student.viewTranscript();
	                    break;
	                case 6:
	                    student.viewMarks();
	                    break;
	                case 7:
	                    // Logic to rate a teacher
	                    break;
	                case 8:
	                    student.viewSchedule();
	                    break;
	                case 9:
	                    // Logic to join student organization
	                    break;
	                case 10:
	                    // Logic to leave student organization
	                    break;
	                case 11:
	                    // Logic to become head of organization
	                    break;
	                case 12:
	                    return; // Exit from student menu
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("An error occurred. Please try again.");
	        }
	    }
	}
	
	public void menuEmployee(Employee employee) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int choice;

	    while (true) {
	        System.out.println("Employee Menu:");
	        System.out.println("1. View Personal Information");
	        System.out.println("2. Edit Personal Information");
	        System.out.println("3. View Work Details");
	        System.out.println("4. Edit Work Details");
	        System.out.println("5. Send Application to Tech Support");
	        System.out.println("6. Logout");
	        System.out.println("Enter your choice:");

	        try {
	            choice = Integer.parseInt(reader.readLine());

	            switch (choice) {
	                case 1:
	                    System.out.println(employee.toString());
	                    break;
	                case 2:
	                    employee.editData();
	                    break;
	                case 3:
	                    System.out.println("Work Department: " + employee.getWorkDepartment());
	                    System.out.println("Salary: " + employee.getSalary());
	                    System.out.println("Date of Employment: " + employee.getDateOfEmployment());
	                    break;
	                case 4:
	                    // Logic to edit work details
	                    break;
	                case 5:
	                    // employee.applicationToTechSupport(); // Uncomment and implement this method
	                    break;
	                case 6:
	                    return; // Exit from employee menu
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.out.println("An error occurred. Please try again.");
	        }
	    }
	}


	public void logIn() {
		changeLanguage();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
//			System.out.println(messages.getString("enterLogin"));
			String login = reader.readLine();

//			System.out.println(messages.getString("enterPassword"));
			String password = reader.readLine();

			// Use the UserFactory to create or retrieve the user
			User user = userFactory.createUser(login, password);
			if (user instanceof Student) {
				Student student = (Student) user;
				menuStudent(student);
				return;

			} else if (user instanceof Employee) {
				Employee employee = (Employee) user;
				menuEmployee(employee);
				return;
			}
			menuUser(user);
			return;
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
