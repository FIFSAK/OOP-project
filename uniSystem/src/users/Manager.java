package users;

import java.util.Date;
import java.util.Vector;


import additional.News;
import course.Course;
import enums.FamilyStatus;
import enums.Gender;
import enums.ManagerType;
import researcher.ResearchPaper;

public class Manager extends Employee {

    public Manager(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}

	public Manager(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	private ManagerType type;
    private Course course;
    private Teacher teacher;
    private News news;
    private Date data;
    private Student student;

    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public News getNews() {
        return this.news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Operations

    public Vector<Student> infoAboutStudent() {
        // TODO
        return null;
    }

    public Vector<Teacher> infoAboutTeacher() {
        // TODO
        return null;
    }

    public boolean assignCourse() {
        // TODO
        return false;
    }

    public void academicReportPerformance() {
        // TODO
    }
}

