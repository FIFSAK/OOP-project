package test;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


import additional.*;
import course.Course;
import data.Data;
import enums.Faculties;
import enums.Format;
import enums.UserType;
import researcher.LowHIndex;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import researcher.ResearcherDecorator;
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
	
	public void menuResearcher(ResearcherDecorator researcher) throws LowHIndex {
		if(researcher.getWrapped() instanceof User) {
			while (true) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int choice;
				System.out.println("User Menu:");
				System.out.println("1. View Personal Information");
				System.out.println("2. Edit Personal Information");
				System.out.println("3. View News");
				System.out.println("4. View University Journal");
				System.out.println("5. Logout");
				System.out.println("6. View comments");
				System.out.println("7. add comment");
				System.out.println("8. stop be researcher");
				System.out.println("9. calc hindex");
				System.out.println("10. look hindex");
				System.out.println("11. look papers");
				System.out.println("12. look projects");
				System.out.println("13. join paper");
				System.out.println("14. join project");
				System.out.println("15. new paper");
				System.out.println("16. new project");
				System.out.println("17. add paper to project");
				System.out.println("18. print papers");
				System.out.println("19. getcitations");
				System.out.println("Enter your choice:");

				try {
					choice = Integer.parseInt(reader.readLine());

					switch (choice) {
					case 1:
						System.out.println(researcher.getWrapped().toString());
						break;
					case 2:
						researcher.getWrapped().editData();
						break;
					case 3:
						researcher.getWrapped().viewNews();
						break;
					case 4:
						researcher.getWrapped().viewUniversityJournal();
						break;
					case 5:
						logOut();
						break; // Exit from user menu
					case 6:
						System.out.println("enter title of news which comments want read");
						String title = reader.readLine();
						Optional<News> newsItem = Data.getInstance().getAllNews().stream()
								.filter(n -> n.getTitle().equals(title)).findFirst();

						if (newsItem.isPresent()) {
							News news = newsItem.get();
							// Do something with the news object
							researcher.getWrapped().viewComments(news);
						} else {
							// Handle the case where no news item was found
							System.out.println("No news item found with title: " + title);
						}
						break;
					case 7:
						System.out.println("enter title of news which comments want add");
						String title1 = reader.readLine();
						Optional<News> newsItem1 = Data.getInstance().getAllNews().stream()
								.filter(n -> n.getTitle().equals(title1)).findFirst();

						if (newsItem1.isPresent()) {
							News news = newsItem1.get();
							String content = reader.readLine();
							// Do something with the news object
							LocalDate localDate = LocalDate.now();
							Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
							news.addComment(new Comment(content, date, researcher.getWrapped()));
						} else {
							// Handle the case where no news item was found
							System.out.println("No news item found with title: " + title1);
						}
						break;
					case 8:
						Data.getInstance().getResearcherDatabase().remove(researcher);
						break;
					case 9:
						researcher.calculateHIndex();
						break;

					case 10:
						System.out.println(researcher.hindex); 
						break;

					case 11:
						System.out.println(researcher.papers);
						break;

					case 12:
						System.out.println(researcher.projects);
						break;

					case 13:
						System.out.println("write papers title");
						String title11 = reader.readLine();
						researcher.joinPaper(title11);
						break;

					case 14:
						System.out.println("write projects topic");
						String topic = reader.readLine();
						researcher.joinProject(topic);
						break;

					case 15:
						System.out.println("write name");
						String name = reader.readLine();
						System.out.println("write pages");
						int pages = Integer.parseInt(reader.readLine());
						System.out.println("write journal");
						String journal = reader.readLine();
						System.out.println("write text");
						String text = reader.readLine();
						researcher.newPaper(name, pages, journal, text);
						break;

					case 16:
						System.out.println("write topic");
						String topic1 = reader.readLine();
						researcher.newProject(topic1);
						break;

					case 17:
						System.out.println("write name paper");
						System.out.println(researcher.papers);
						name = reader.readLine();
						System.out.println("write name project");
						System.out.println(researcher.projects);
						String pname=reader.readLine();
						ResearchProject temp = null;
						for (ResearchProject rp : researcher.projects) {
							if(rp.topic.equals(pname)) {
								temp = rp;
							}
						}
						if(temp == null) {
							System.out.println("not exist project");
							break;
						}
						for (ResearchPaper rp : researcher.papers) {
							if(rp.name.equals(name)) {
								temp.addPaper(rp);
							}
						}
						break;

					case 18:
						System.out.println("how sort by citations?");
						String sortType = reader.readLine();
						researcher.printPapers(sortType);
						break;
					case 19:
						System.out.println("write paper name");
						name = reader.readLine();
						for (ResearchPaper rp : researcher.papers) {
							if(rp.name.equals(name)) {
								System.out.println("chose format b or p");
								String format = reader.readLine();
								if(format == "b") {
									rp.getCitation(Format.BIBTEX);

								}
								else {
									rp.getCitation(Format.PLAIN_TEXT);

								}
							}
						}
						break;

					default:
						
						System.out.println("Invalid choice. Please try again.");
					}
				} catch (IOException | NumberFormatException e) {
					System.out.println("An error occurred. Please try again.");
				}
			}
		}
	}
	
	public void menuUser(User user) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		while (true) {
			System.out.println("User Menu:");
			System.out.println("1. View Personal Information");
			System.out.println("2. Edit Personal Information");
			System.out.println("3. View News");
			System.out.println("4. View University Journal");
			System.out.println("5. Logout");
			System.out.println("6. View comments");
			System.out.println("7. add comment");
			System.out.println("8. be researcher");
			System.out.println("9. update");
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
					logOut();
					return; // Exit from user menu
				case 6:
					System.out.println("enter title of news which comments want read");
					String title = reader.readLine();
					Optional<News> newsItem = Data.getInstance().getAllNews().stream()
							.filter(n -> n.getTitle().equals(title)).findFirst();

					if (newsItem.isPresent()) {
						News news = newsItem.get();
						// Do something with the news object
						user.viewComments(news);
					} else {
						// Handle the case where no news item was found
						System.out.println("No news item found with title: " + title);
					}
					break;
				case 7:
					System.out.println("enter title of news which comments want add");
					String title1 = reader.readLine();
					Optional<News> newsItem1 = Data.getInstance().getAllNews().stream()
							.filter(n -> n.getTitle().equals(title1)).findFirst();

					if (newsItem1.isPresent()) {
						News news = newsItem1.get();
						String content = reader.readLine();
						// Do something with the news object
						LocalDate localDate = LocalDate.now();
						Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						news.addComment(new Comment(content, date, user));
					} else {
						// Handle the case where no news item was found
						System.out.println("No news item found with title: " + title1);
					}
					break;
				case 8:
					ResearcherDecorator userResearcher = new ResearcherDecorator(user);
					Data.getInstance().addResearcherDatabase(userResearcher);
					break;
				case 9:
					user.update();
					break;
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
			System.out.println("User Menu:");
			System.out.println("1. View Personal Information");
			System.out.println("2. Edit Personal Information");
			System.out.println("3. View News");
			System.out.println("4. View University Journal");
			System.out.println("5. Logout");
			System.out.println("6. View comments");
			System.out.println("7. add comment");
			System.out.println("Student Menu:");
			System.out.println("8. View Courses");
			System.out.println("9. Register for a Course");
			System.out.println("10. View Transcript");
			System.out.println("11. View Marks");
			System.out.println("12. Rate a Teacher");
			System.out.println("13. View Schedule");
			System.out.println("14. Join Student Organization");
			System.out.println("15. Leave Student Organization");
			System.out.println("16. Become Head of Organization");
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
					student.viewNews();
					break;
				case 4:
					student.viewUniversityJournal();
					break;
				case 5:
					logOut();
					 // Exit from user menu
					return;
				case 6:
					System.out.println("enter title of news which comments want read");
					String title = reader.readLine();
					Optional<News> newsItem = Data.getInstance().getAllNews().stream()
							.filter(n -> n.getTitle().equals(title)).findFirst();

					if (newsItem.isPresent()) {
						News news = newsItem.get();
						// Do something with the news object
						student.viewComments(news);
					} else {
						// Handle the case where no news item was found
						System.out.println("No news item found with title: " + title);
					}
					break;
				case 7:
					System.out.println("enter title of news which comments want add");
					String title1 = reader.readLine();
					Optional<News> newsItem1 = Data.getInstance().getAllNews().stream()
							.filter(n -> n.getTitle().equals(title1)).findFirst();

					if (newsItem1.isPresent()) {
						News news = newsItem1.get();
						String content = reader.readLine();
						// Do something with the news object
						LocalDate localDate = LocalDate.now();
						Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						news.addComment(new Comment(content, date, student));
					} else {
						// Handle the case where no news item was found
						System.out.println("No news item found with title: " + title1);
					}
					break;
				case 8:
					student.viewCourses();
					break;
				case 9:
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

				case 10:
					student.viewTranscript();
					break;
				case 11:
					student.viewMarks();
					break;
				case 12:
					// Logic to rate a teacher
					break;
				case 13:
					student.viewSchedule();
					break;
				case 14:
				    System.out.println("Choose an organization and write the name:");
				    List<StudentOrganisation> organizations = Data.getInstance().getStudentOrganizationDatabase();
				    
				    // Check if the organization database is not null and not empty
				    if (organizations != null && !organizations.isEmpty()) {
				        // Display each organization (assuming StudentOrganisation has a proper toString method)
				        organizations.forEach(System.out::println);

				        String name = reader.readLine();
				        Optional<StudentOrganisation> organizationOpt = organizations.stream()
				            .filter(org -> org.name.equals(name))
				            .findFirst();

				        if (organizationOpt.isPresent()) {
				            StudentOrganisation organization = organizationOpt.get();
				            student.joinStudentOrganization(organization);
				            System.out.println("Joined organization: " + organization.name);
				        } else {
				            System.out.println("Organization not found.");
				        }
				    } else {
				        System.out.println("No organizations are available.");
				    }
				    break;

				case 15:
					System.out.println("write name org to leave");
					System.out.println(Data.getInstance().getStudentOrganizationDatabase());
					String name1 = reader.readLine();
					Optional<StudentOrganisation> organizationOpt1 = Data.getInstance().getStudentOrganizationDatabase().stream()
						    .filter(org -> org.name.equals(name1))
						    .findFirst();

						if (organizationOpt1.isPresent()) {
						    StudentOrganisation organization = organizationOpt1.get();
						    student.leaveStudentOrganization(organization);
						    System.out.println("leaved organization: " + organization.name);
						} else {
						    System.out.println("Organization not found.");
						}
					break;
				case 16:
					System.out.println("write name of organization");
					String name11 = reader.readLine();
					student.createOrganisation(new StudentOrganisation(name11));
					break;
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

	public void logIn() throws LowHIndex {
		changeLanguage();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
//			System.out.println(messages.getString("enterLogin"));
			String login = reader.readLine();

//			System.out.println(messages.getString("enterPassword"));
			String password = reader.readLine();

			// Use the UserFactory to create or retrieve the user
			User user = userFactory.createUser(login, password);
			
			ResearcherDecorator userResearcher = null; // Initialize to null
			
		    Vector<ResearcherDecorator> researchers = Data.getInstance().getResearcherDatabase();
			for (ResearcherDecorator researcher : researchers) {
		        // Assuming ResearcherDecorator has a method to get the login
		        if (researcher.getWrapped().getLogin().equals(login)) {
		            userResearcher = researcher;
		            break;
		        }
		    }
			if(userResearcher!= null) {
				menuResearcher(userResearcher);
			}
			
			else if (user instanceof Student) {
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

	public static void main(String[] args) throws LowHIndex {
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
