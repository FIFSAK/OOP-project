package users;

import java.util.Vector;

public class Manager extends Employee {

    private ManagerType type;
    private Course course;
    private Teacher teacher;
    private News news;
    private Data data;
    private Student student;

    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
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

