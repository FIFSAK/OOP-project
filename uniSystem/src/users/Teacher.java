package users;

import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.Optional;

import course.Course;
import data.Data;
import enums.FamilyStatus;
import enums.Gender;
import enums.TeacherType;
import researcher.ResearchPaper;
import researcher.ResearcherDecorator;

public class Teacher extends Employee {
	
	private Set<Course> courses;
    private TeacherType post;
    private List<Student> students;
    private ResearcherDecorator researcherDecorator;

    public Teacher(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
    	super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}

	public Teacher(String login, String password) {
		super(login, password);
	}

    public Set<Course> getCourses() {
        return this.courses;
    }

    private void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public TeacherType getPost() {
        return this.post;
    }

    public void setPost(TeacherType post) {
        this.post = post;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ResearcherDecorator getResearcherDecorator() {
        return this.researcherDecorator;
    }

    public void setResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researcherDecorator = researcherDecorator;
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

    public void viewCourses() {
        try {
            System.out.println("List of Courses:");

            if (courses != null && !courses.isEmpty()) {
                courses.forEach(course -> System.out.println("- " + course.getNameCourse()));
            } else {
                System.out.println("No courses available.");
            }

            System.out.println("End of Course List.");
        } catch (Exception e) {
            System.out.println("Error viewing courses.");
            e.printStackTrace();
        }
    }

    public Student infoAboutStudent(String name, String surname) {
        List<Student> students = Data.getInstance().getAllStudent();

        Optional<Student> foundStudent = students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(name) &&
                                   student.getLastName().equalsIgnoreCase(surname))
                .findFirst();

        return foundStudent.orElse(null);
    }

	public void addCourse(Course course) {
        this.courses.add(course);
    }
}

