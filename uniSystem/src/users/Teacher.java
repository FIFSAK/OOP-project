package users;

import java.util.Set;
import java.util.Vector;

public class Teacher extends Employee {

    private Set<Course> courses;
    private Student viewStudents;
    private TeacherType post;
    private Vector<Student> students;
    private Course course;
    private ResearcherDecorator researcherDecorator;
    private Manager manager;
    private Data data;
    private Student student;
    private EmployeeFactory employeeFactory;

    public String getViewCourses() {
        return this.viewCourses;
    }

    public void setViewCourses(String viewCourses) {
        this.viewCourses = viewCourses;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private Set<Course> getCourses() {
        return this.courses;
    }

    private void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student getViewStudents() {
        return this.viewStudents;
    }

    public void setViewStudents(Student viewStudents) {
        this.viewStudents = viewStudents;
    }

    public TeacherType getPost() {
        return this.post;
    }

    public void setPost(TeacherType post) {
        this.post = post;
    }

    public Vector<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Vector<Student> students) {
        this.students = students;
    }

    public ResearcherDecorator getResearcherDecorator() {
        return this.researcherDecorator;
    }

    public void setResearcherDecorator(ResearcherDecorator researcherDecorator) {
        this.researcherDecorator = researcherDecorator;
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

    public EmployeeFactory getEmployeeFactory() {
        return this.employeeFactory;
    }

    public void setEmployeeFactory(EmployeeFactory employeeFactory) {
        this.employeeFactory = employeeFactory;
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
}

