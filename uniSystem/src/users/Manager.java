package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import data.*;


import additional.News;
import course.Course;
import enums.FamilyStatus;
import enums.Gender;
import enums.ManagerType;
import researcher.ResearchPaper;

public class Manager extends Employee {

    public Manager(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus, dateOfEmployment);
		// TODO Auto-generated constructor stub
	}

	public Manager(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	private ManagerType type;
    private Course course;
    private Teacher teacher;
//    private News news;
    private Date data;
    private Student student;
	private News news;

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
    
    public void createNews() {
    	
    }
    
    ArrayList<News> newsList = new ArrayList<News>();
    
    public void manageNews(News news, String title ) {
        int index = newsList.indexOf(news);
        if (title != null) {
            News _news = newsList.get(index);
            _news.setTopic(title);
            newsList.set(index, _news);
        }
    }
    
    public void viewStudents() {
    	Data
        .getInstance()
        .getAllStudent()
        .stream()
        .forEach(student -> System.out.println(student));
    }
    
    public void viewTeachers(List<Teacher> teachers) {
    	Data
        .getInstance()
        .getAllTeacher()
        .stream()
        .forEach(student -> System.out.println(student));
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

