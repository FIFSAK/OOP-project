package users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import data.*;
import additional.*;
import course.*;
import enums.*;

public class Manager extends Employee implements Serializable{

	private ManagerType type;
	
	public Manager(String firstName, String lastName, String login, String password, Date dateOfBirth,
            String phoneNumber, int iin, Gender gender, String nationality, FamilyStatus familyStatus) {
		super(firstName,lastName, login, password, dateOfBirth, phoneNumber,iin, gender,  nationality,familyStatus  );
	}
	
	public Manager(String firstName, String lastName, String login, String password, Date dateOfBirth,
            String phoneNumber, int iin, Gender gender, String nationality, FamilyStatus familyStatus, ManagerType managerType) {
		super(firstName,lastName, login, password, dateOfBirth, phoneNumber,iin, gender,  nationality,familyStatus  );
		this.type = managerType;
	}

	public Manager(String login, String password) {
		super(login, password);
	}

    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public void createNews() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter news title:");
            String title = reader.readLine();

            System.out.println("Enter news content:");
            String content = reader.readLine();

            // You might generate the date programmatically or take it as input
            Date datePublished = new Date();

            System.out.println("Enter news topic:");
            String topic = reader.readLine();

            System.out.println("Is news pinned? (true/false):");
            boolean isPinned = Boolean.parseBoolean(reader.readLine());

            // Create a new News object
            News news = new News(title, content, datePublished, topic, isPinned);

            // Add the news to the list
            Data.getInstance().addNews(news);

            System.out.println("News created successfully!");
        } catch (IOException e) {
            System.out.println("Error reading input. News creation failed.");
            e.printStackTrace();
        }
    }
    
    public void manageNews() {
        try {
            // Display available news
            System.out.println("Available News:");
            Data.getInstance().getAllNews().forEach(news -> System.out.println("- " + news.getTitle()));

            // Get the title of the news to manage
            System.out.print("Enter the title of the news you want to manage: ");
            String newsTitle = new BufferedReader(new InputStreamReader(System.in)).readLine();

            // Find the news by title
            News newsToManage = Data.getInstance().getAllNews().stream()
                    .filter(news -> news.getTitle().equalsIgnoreCase(newsTitle))
                    .findFirst()
                    .orElse(null);

            if (newsToManage != null) {
                // Display current details of the selected news
                System.out.println("Current Topic: " + newsToManage.getTopic());

                // Get the new topic from the user
                System.out.print("Enter the new topic (or press Enter to keep the current topic): ");
                String newTopic = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

                if (!newTopic.isEmpty()) {
                    // Update the topic
                    newsToManage.setTopic(newTopic);
                    System.out.println("News topic updated successfully!");
                } else {
                    System.out.println("No changes made. Keeping the current topic.");
                }
            } else {
                System.out.println("News with the given title not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input. News management failed.");
            e.printStackTrace();
        }
    }
    
    public void viewStudents() {
        try {
            System.out.println("List of Students:");

            Data.getInstance().getAllStudent().forEach(student -> System.out.println("- " + student.getFirstName() + " " + student.getLastName()));

            System.out.println("End of Student List.");
        } catch (Exception e) {
            System.out.println("Error viewing students.");
            e.printStackTrace();
        }
    }

    // Operations

    public Student infoAboutStudent(String name, String surname) {
        List<Student> students = Data.getInstance().getAllStudent();

        Optional<Student> foundStudent = students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(name) &&
                                   student.getLastName().equalsIgnoreCase(surname))
                .findFirst();

        return foundStudent.orElse(null);
    }

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

    public boolean assignCourse() {
        try {
            // Display available teachers
            System.out.println("Available Teachers:");
            Data.getInstance().getAllTeacher().forEach(teacher -> System.out.println("- " + teacher.getFirstName()));

            // Get the name of the teacher to assign the course
            System.out.print("Enter the name of the teacher to assign the course: ");
            String teacherName = new BufferedReader(new InputStreamReader(System.in)).readLine();

            // Find the teacher by name
            Optional<Teacher> foundTeacher = Data.getInstance().getAllTeacher().stream()
                    .filter(teacher -> teacher.getFirstName().equalsIgnoreCase(teacherName))
                    .findFirst();

            if (foundTeacher.isPresent()) {
                // Display available courses
                System.out.println("Available Courses:");
                Data.getInstance().getAllCourses().forEach(course -> System.out.println("- " + course.getNameCourse()));

                // Get the name of the course to assign
                System.out.print("Enter the name of the course to assign: ");
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
                    System.out.println("Course assigned successfully.");
                    return true;
                } else {
                    System.out.println("Course not found.");
                }
            } else {
                System.out.println("Teacher not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading input. Course assignment failed.");
            e.printStackTrace();
        }

        return false;
    }

    public void academicReportPerformance() {
        try {
            System.out.println("Generating Academic Performance Report...");

            // Fetch student data from the data instance
            List<Student> students = Data.getInstance().getAllStudent();

            // Calculate average GPA
            double averageGPA = students.stream()
                    .mapToDouble(Student::getAvgGPA)
                    .average()
                    .orElse(0.0);

            System.out.println("Average GPA: " + averageGPA);

            // Rank students based on GPA (descending order)
            List<Student> rankedStudents = students.stream()
                    .sorted(Comparator.comparingDouble(Student::getAvgGPA).reversed())
                    .collect(Collectors.toList());

            // Display the ranking
            System.out.println("Student Ranking based on GPA:");
            for (int i = 0; i < rankedStudents.size(); i++) {
                Student student = rankedStudents.get(i);
                System.out.println((i + 1) + ". " + student.getFirstName() + " - GPA: " + student.getAvgGPA());
            }

            // Compare each student's GPA with the average GPA
            System.out.println("Comparison with Average GPA:");
            for (Student student : students) {
                String comparison = (student.getAvgGPA() > averageGPA) ? "Above Average" : "Below Average";
                System.out.println(student.getFirstName() + " - GPA: " + student.getAvgGPA() + " - " + comparison);
            }

            System.out.println("Academic Performance Report generated successfully.");

        } catch (Exception e) {
            System.out.println("Error generating Academic Performance Report.");
            e.printStackTrace();
        }
    }
}

