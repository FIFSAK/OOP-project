package users;

import java.io.Serializable;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import data.*;
import additional.*;
import course.*;
import enums.*;


/**
 * The Manager class represents a manager in the university, extending the Employee class.
 * It provides functionalities for managing news, viewing students, and performing various operations
 * related to student and teacher information.
 */

public class Manager extends Employee implements Serializable{
	
    /** The type of the manager. */


	private ManagerType type;
    private ResourceBundle messages;

	
	/**
     * Constructs a new Manager object with the specified personal and employment details.
     *
     * @param firstName      The first name of the manager.
     * @param lastName       The last name of the manager.
     * @param login          The login ID of the manager.
     * @param password       The password of the manager.
     * @param dateOfBirth    The date of birth of the manager.
     * @param phoneNumber    The phone number of the manager.
     * @param iin            The Individual Identification Number (IIN) of the manager.
     * @param gender         The gender of the manager.
     * @param nationality    The nationality of the manager.
     * @param familyStatus   The family status of the manager.
     */
	
	public Manager(String firstName, String lastName, String login, String password, Date dateOfBirth,
            String phoneNumber, int iin, Gender gender, String nationality, FamilyStatus familyStatus) {
		super(firstName,lastName, login, password, dateOfBirth, phoneNumber,iin, gender,  nationality,familyStatus  );
	}
	
	/**
     * Constructs a new Manager object with the specified personal and employment details,
     * including the manager type.
     *
     * @param firstName      The first name of the manager.
     * @param lastName       The last name of the manager.
     * @param login          The login ID of the manager.
     * @param password       The password of the manager.
     * @param dateOfBirth    The date of birth of the manager.
     * @param phoneNumber    The phone number of the manager.
     * @param iin            The Individual Identification Number (IIN) of the manager.
     * @param gender         The gender of the manager.
     * @param nationality    The nationality of the manager.
     * @param familyStatus   The family status of the manager.
     * @param managerType    The type of the manager.
     */
	
	public Manager(String firstName, String lastName, String login, String password, Date dateOfBirth,
            String phoneNumber, int iin, Gender gender, String nationality, FamilyStatus familyStatus, ManagerType managerType) {
		super(firstName,lastName, login, password, dateOfBirth, phoneNumber,iin, gender,  nationality,familyStatus  );
		this.type = managerType;
	}
	/**
     * Constructs a new Manager object with the specified login and password.
     *
     * @param login     The login ID of the manager.
     * @param password  The password of the manager.
     */
	public Manager(String login, String password) {
		super(login, password);
	}
	
	/**
     * Gets the type of the manager.
     *
     * @return The type of the manager.
     */

    public ManagerType getType() {
        return this.type;
    }
    
    /**
     * Sets the type of the manager.
     *
     * @param type The type of the manager.
     */

    public void setType(ManagerType type) {
        this.type = type;
    }
    
    /**
     * Allows the manager to create news by providing details such as title, content, topic, and whether it is pinned.
     */
    
    private void printMessage(String key, Object... args) {
        String message = messages.getString(key);
        System.out.println(args.length > 0 ? String.format(message, args) : message);
    }

    public void createNews() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            printMessage("enterNewsTitle");
            String title = reader.readLine();

            printMessage("enterNewsContent");
            String content = reader.readLine();

            // You might generate the date programmatically or take it as input
            Date datePublished = new Date();

            printMessage("enterNewsTopic");
            String topic = reader.readLine();

            printMessage("isNewsPinned");
            boolean isPinned = Boolean.parseBoolean(reader.readLine());

            // Create a new News object
            News news = new News(title, content, datePublished, topic, isPinned);

            // Add the news to the list
            Data.getInstance().addNews(news);

            printMessage("newsCreatedSuccessfully");
        } catch (IOException e) {
            System.out.println("Error reading input. News creation failed.");
            e.printStackTrace();
        }
    }
    
    /**
     * Allows the manager to manage existing news by updating the topic.
     */
    
    public void manageNews() {
        try {
            // Display available news
            printMessage("availableNewsHeader");
            Data.getInstance().getAllNews().forEach(news -> System.out.println("- " + news.getTitle()));

            // Get the title of the news to manage
            printMessage("enterNewsTitleToManage");
            String newsTitle = new BufferedReader(new InputStreamReader(System.in)).readLine();

            // Find the news by title
            News newsToManage = Data.getInstance().getAllNews().stream()
                    .filter(news -> news.getTitle().equalsIgnoreCase(newsTitle))
                    .findFirst()
                    .orElse(null);

            if (newsToManage != null) {
                // Display current details of the selected news
                printMessage("currentTopic", newsToManage.getTopic());

                // Get the new topic from the user
                printMessage("enterNewTopic");
                String newTopic = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

                if (!newTopic.isEmpty()) {
                    // Update the topic
                    newsToManage.setTopic(newTopic);
                    printMessage("newsTopicUpdatedSuccessfully");
                } else {
                    printMessage("noChangesMade");
                }
            } else {
                printMessage("newsNotFoundWithTitle", newsTitle);
            }
        } catch (IOException e) {
            printMessage("errorReadingInput");
            e.printStackTrace();
        }
    }
    
    /**
     * Displays a list of students.
     */
    
    public void viewStudents() {
        try {
            printMessage("studentListHeader");

            Data.getInstance().getAllStudent().forEach(student -> System.out.println("- " + student.getFirstName() + " " + student.getLastName()));

            printMessage("endOfStudentList");
        } catch (Exception e) {
            printMessage("errorViewingStudents");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves information about a specific student.
     *
     * @param name     The first name of the student.
     * @param surname  The last name of the student.
     * @return The Student object if found, otherwise null.
     */
    public Student infoAboutStudent(String name, String surname) {
        List<Student> students = Data.getInstance().getAllStudent();

        Optional<Student> foundStudent = students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(name) &&
                                   student.getLastName().equalsIgnoreCase(surname))
                .findFirst();

        return foundStudent.orElse(null);
    }
    
    /**
     * Retrieves information about a specific teacher.
     *
     * @param name     The first name of the teacher.
     * @param surname  The last name of the teacher.
     * @return The Teacher object if found, otherwise null.
     */

    public Teacher infoAboutTeacher(String name, String surname) {
        // Fetch teacher data from the data instance
        List<Teacher> teachers = Data.getInstance().getAllTeacher();

        // Use streams to find the teacher by name and surname
        Optional<Teacher> foundTeacher = teachers.stream()
                .filter(teacher -> teacher.getFirstName().equalsIgnoreCase(name) &&
                                   teacher.getLastName().equalsIgnoreCase(surname))
                .findFirst();

        return foundTeacher.orElse(null);
    }
    
    /**
     * Assigns a course to a teacher.
     *
     * @return True if the course is successfully assigned, otherwise false.
     */

    public boolean assignCourse() {
        try {
            // Display available teachers
            printMessage("availableTeachersHeader");
            Data.getInstance().getAllTeacher().forEach(teacher -> System.out.println("- " + teacher.getFirstName()));

            // Get the name of the teacher to assign the course
            printMessage("enterTeacherNameToAssignCourse");
            String teacherName = new BufferedReader(new InputStreamReader(System.in)).readLine();

            // Find the teacher by name
            Optional<Teacher> foundTeacher = Data.getInstance().getAllTeacher().stream()
                    .filter(teacher -> teacher.getFirstName().equalsIgnoreCase(teacherName))
                    .findFirst();

            if (foundTeacher.isPresent()) {
                // Display available courses
                printMessage("availableCoursesHeader");
                Data.getInstance().getAllCourses().forEach(course -> System.out.println("- " + course.getNameCourse()));

                // Get the name of the course to assign
                printMessage("enterCourseNameToAssign");
                String courseName = new BufferedReader(new InputStreamReader(System.in)).readLine();

                // Find the course by name
                Optional<Course> foundCourse = Data.getInstance().getAllCourses().stream()
                        .filter(course -> course.getNameCourse().equalsIgnoreCase(courseName))
                        .findFirst();

                if (foundCourse.isPresent()) {
                    // Assign the course to the teacher
                    Teacher teacher = foundTeacher.get();
                    Course course = foundCourse.get();

                    teacher.addCourse(course);
                    printMessage("courseAssignedSuccessfully");
                    return true;
                } else {
                    printMessage("courseNotFound");
                }
            } else {
                printMessage("teacherNotFound");
            }
        } catch (IOException e) {
            printMessage("errorReadingInput");
            e.printStackTrace();
        }

        return false;
    }
    
    /**
     * Generates an academic performance report for students.
     */

    public void academicReportPerformance() {
        try {
            printMessage("generatingAcademicPerformanceReport");

            // Fetch student data from the data instance
            List<Student> students = Data.getInstance().getAllStudent();

            // Calculate average GPA
            double averageGPA = students.stream()
                    .mapToDouble(Student::getAvgGPA)
                    .average()
                    .orElse(0.0);

            printMessage("averageGPA", averageGPA);

            // Rank students based on GPA (descending order)
            List<Student> rankedStudents = students.stream()
                    .sorted(Comparator.comparingDouble(Student::getAvgGPA).reversed())
                    .collect(Collectors.toList());

            // Display the ranking
            printMessage("studentRankingHeader");
            for (int i = 0; i < rankedStudents.size(); i++) {
                Student student = rankedStudents.get(i);
                printMessage("studentRankingItem", i + 1, student.getFirstName(), student.getAvgGPA());
            }

            // Compare each student's GPA with the average GPA
            printMessage("comparisonWithAverageGPAHeader");
            for (Student student : students) {
                String comparison = (student.getAvgGPA() > averageGPA) ? "Above Average" : "Below Average";
                printMessage("comparisonWithAverageGPAItem", student.getFirstName(), student.getAvgGPA(), comparison);
            }

            printMessage("academicPerformanceReportGeneratedSuccessfully");

        } catch (Exception e) {
            printMessage("errorGeneratingAcademicPerformanceReport");
            e.printStackTrace();
        }
    }
}

