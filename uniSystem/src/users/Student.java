package users;

import java.util.Date;
import java.util.HashMap;

import javax.xml.crypto.Data;

import additional.*;
import course.Course;
import course.Mark;
import enums.Faculties;
import researcher.ResearcherDecorator;

public class Student extends User {

    private Faculties faculty;
    private int yearOfStudy;
    private StudentOrganisation organisation;
    private HashMap<Course, Mark> courseInfo;
    private Teacher teacher;
    private Course course;
    private StudentOrganisation studentOrganization;
    private ResearcherDecorator researcherDecorator;
    private Manager manager;
    private Data data;
    private Mark mark;

    public Student(String login, String password) {
        super(login, password);
        this.faculty = Faculties.BS;
        this.yearOfStudy = 1;
    }


    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public StudentOrganisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(StudentOrganisation organisation) {
        this.organisation = organisation;
    }

    public HashMap<Course, Mark> getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(HashMap<Course, Mark> courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentOrganisation getStudentOrganization() {
        return studentOrganization;
    }

    public void setStudentOrganization(StudentOrganisation studentOrganization) {
        this.studentOrganization = studentOrganization;
    }

    public ResearcherDecorator getResearcherDecorator() {
        return researcherDecorator;
    }

    public void setResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researcherDecorator = researcherDecorator;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    // Additional methods and operations
    // Implement the remaining methods based on project requirements
//     TODO: Implement viewTranscript, viewMarks, rateTeacher, viewCourses, viewSchedule, registerToCourse, viewInfoAboutTeachers
}
