package users;

import java.util.Date;
import java.util.Set;
import java.util.List;

import course.Course;
import enums.FamilyStatus;
import enums.Gender;
import enums.TeacherType;
import researcher.ResearchPaper;
import researcher.ResearcherDecorator;

public class Teacher extends Employee {

    public Teacher(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}

	public Teacher(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	private Set<Course> courses;
    private Student viewStudents;
    private TeacherType post;
    private List<Student> students;
    private Course course;
    private ResearcherDecorator researcherDecorator;
    private Manager manager;
    private Date data;
    private Student student;
	private String viewCourses;

    public String getViewCourses() {
        return this.getViewCourses();
    }

    private Set<Course> getCourses() {
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

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Student viewStudent() {
        return null;
    }

    public Set<Course> viewCourses() {
        return null;
    }

    public Student infoAboutStudents() {
        return null;
    }

    public Employee getDepartment() {
        return null;
    }

	public Object receiveRating(double rating) {
		return null;
	}
}

