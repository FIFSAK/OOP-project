package users;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import course.Course;
import course.Mark;
import data.Data;
import enums.FamilyStatus;
import enums.Gender;
import enums.Grade;
import enums.TeacherType;
import researcher.ResearchPaper;
import researcher.ResearcherDecorator;

/**
 * Represents a Teacher, extending the Employee class.
 */
public class Teacher extends Employee implements Serializable{

	
	private Set<Course> courses;
    private TeacherType post;
    private List<Student> students;
    private ResearcherDecorator researcherDecorator;
    private ResourceBundle messages;

    
    /**
     * Constructor to initialize a Teacher with specified attributes.
     *
     * @param firstName         The first name of the teacher.
     * @param lastName          The last name of the teacher.
     * @param password          The password for the teacher's account.
     * @param login             The login username for the teacher's account.
     * @param userId            The unique identifier for the teacher.
     * @param subscribedJournals The research papers subscribed by the teacher.
     * @param name              The name of the teacher.
     * @param dateOfBirth       The date of birth of the teacher.
     * @param phoneNumber       The phone number of the teacher.
     * @param iin               The Individual Identification Number of the teacher.
     * @param category          The gender category of the teacher.
     * @param nationality       The nationality of the teacher.
     * @param familyStatus      The family status of the teacher.
     * @param dateOfEmployment  The date of employment of the teacher.
     */

    public Teacher(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
    	super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}
    
    private void printMessage(String key, Object... args) {
        String message = messages.getString(key);
        System.out.println(args.length > 0 ? String.format(message, args) : message);
    }
    
    /**
     * Constructor to create a Teacher with specified login and password.
     *
     * @param login    The login username for the teacher's account.
     * @param password The password for the teacher's account.
     */

	public Teacher(String login, String password) {
		super(login, password);
	}
	
	/**
     * Gets the set of courses taught by the teacher.
     *
     * @return The set of courses taught by the teacher.
     */

    public Set<Course> getCourses() {
        return this.courses;
    }
    
    /**
     * Sets the courses taught by the teacher.
     *
     * @param courses The set of courses to be set for the teacher.
     */

    private void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    
    /**
     * Gets the post or position of the teacher.
     *
     * @return The post or position of the teacher.
     */

    public TeacherType getPost() {
        return this.post;
    }
    
    /**
     * Sets the post or position of the teacher.
     *
     * @param post The post or position to be set for the teacher.
     */

    public void setPost(TeacherType post) {
        this.post = post;
    }
    
    /**
     * Gets the list of students associated with the teacher.
     *
     * @return The list of students associated with the teacher.
     */

    public List<Student> getStudents() {
        return this.students;
    }
    
    /**
     * Sets the list of students associated with the teacher.
     *
     * @param students The list of students to be set for the teacher.
     */

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    /**
     * Gets the researcher decorator associated with the teacher.
     *
     * @return The researcher decorator associated with the teacher.
     */

    public ResearcherDecorator getResearcherDecorator() {
        return this.researcherDecorator;
    }
    
    /**
     * Sets the researcher decorator for the teacher.
     *
     * @param researcherDecorator The researcher decorator to be set for the teacher.
     */

    public void setResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researcherDecorator = researcherDecorator;
    }
    
    /**
     * Displays the list of students associated with the teacher.
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
     * Displays the list of courses taught by the teacher.
     */

    public void viewCourses() {
        try {
            printMessage("courseListHeader");

            if (courses != null && !courses.isEmpty()) {
                courses.forEach(course -> System.out.println("- " + course.getNameCourse()));
            } else {
                printMessage("noCoursesAvailable");
            }

            printMessage("endOfCourseList");
        } catch (Exception e) {
            printMessage("errorViewingCourses");
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves information about a specific student based on the provided name and surname.
     *
     * @param name    The first name of the student.
     * @param surname The last name of the student.
     * @return The Student object if found, or null if not found.
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
     * Adds a course to the set of courses taught by the teacher.
     *
     * @param course The course to be added.
     */

	public void addCourse(Course course) {
        this.courses.add(course);
    }
	
	public void putMark(String studentFirstName, String studentLastName, Course course,
            double secondAttestation, double firstAttestation, double finalExam) {
// Find the student by name and surname
Optional<Student> optionalStudent = students.stream()
    .filter(student -> student.getFirstName().equalsIgnoreCase(studentFirstName) &&
                       student.getLastName().equalsIgnoreCase(studentLastName))
    .findFirst();

// Check if the student is found
if (optionalStudent.isPresent()) {
Student student = optionalStudent.get();

// Check if the teacher teaches the specified course
if (!courses.contains(course)) {
    printMessage("errorCourseNotTaught");
    return;
}

// Create a new Mark object with the associated course
Mark mark = new Mark();
mark.setSecondAttestation(secondAttestation);
mark.setFirstAttestation(firstAttestation);
mark.setFinalExam(finalExam);

// Calculate and set the GPA
mark.calculateGPA();

// Set the grade based on your logic
mark.setGrade(determineGrade(mark.getGPA()));

// Associate the Mark object with the student and course
student.addMarkForCourse(course, mark);

printMessage("marksAddedSuccessfully", student.getFirstName(), student.getLastName(),
        course.getNameCourse(), mark.getGrade());
} else {
    printMessage("errorStudentNotFound", studentFirstName, studentLastName);
}
}

private Grade determineGrade(double GPA) {
// Your logic to determine the Grade based on GPA
// Example logic (you may adjust this based on your grading scale)
if (GPA >= 3.7) {
return Grade.A;
} else if (GPA >= 3.3) {
return Grade.A_M;
} else if (GPA >= 3.0) {
return Grade.B_P;
} else if (GPA >= 2.7) {
return Grade.B;
} else if (GPA >= 2.3) {
return Grade.B_M;
} else if (GPA >= 2.0) {
return Grade.C_P;
} else if (GPA >= 1.7) {
return Grade.C;
} else if (GPA >= 1.3) {
return Grade.C_M;
} else if (GPA >= 1.0) {
return Grade.D_P;
} else if (GPA >= 0.7) {
return Grade.D;
} else if (GPA >= 0.0) {
return Grade.D_M;
} else {
return Grade.F;
}
}

}

