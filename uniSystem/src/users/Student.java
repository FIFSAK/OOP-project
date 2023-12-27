package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import additional.StudentOrganisation;
import course.Course;
import course.Mark;
import course.Transcript;
import data.Data;
import enums.Faculties;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;
import researcher.ResearcherDecorator;

public class Student extends User implements Serializable{

    private Faculties faculty;
    private int yearOfStudy;
    private int yearOfReceipt;
    private StudentOrganisation organisation;
    private HashMap<Course, Mark> courseInfo;
    private List<Teacher> teachers;
    private StudentOrganisation studentOrganization;
    private Set<Teacher> instructors;
    private String diplomaProject; 

    public Student(String login, String password) {
        super(login, password);
        this.yearOfStudy = 1;
        this.courseInfo = new HashMap<>();
        this.instructors = new HashSet<>();
        this.diplomaProject = "";
    }

    public Student(String firstName, String lastName, String password, String login, 
    			Date dateOfBirth, String phoneNumber, 
    			int iin, Gender category, String nationality, FamilyStatus familyStatus) {
        super(firstName, lastName, password, login, 
        		dateOfBirth, phoneNumber, iin, category,
                nationality, familyStatus);
    }

    public int getYearOfReceipt() {
        return yearOfReceipt;
    }

    public void setYearOfReceipt(int yearOfReceipt) {
        this.yearOfReceipt = yearOfReceipt;
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

    public StudentOrganisation getStudentOrganization() {
        return studentOrganization;
    }

    public void setStudentOrganization(StudentOrganisation studentOrganization) {
        this.studentOrganization = studentOrganization;
    }
    
    public String getDiplomaProject() {
        return diplomaProject;
    }
    public void setDiplomaProject(String diplomaProject) {
        this.diplomaProject = diplomaProject;
    }

    private Transcript generateTranscript() {
        Transcript transcript = new Transcript();
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            transcript.addMark(course, mark);
        }
        return transcript;
    }

    public void viewTranscript() {
        Transcript transcript = generateTranscript();
        System.out.println(transcript);
    }

    public Transcript getTranscript() {
        return generateTranscript();
    }

    public void viewMarks() {
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            String courseName = entry.getKey().getNameCourse();
            Mark mark = entry.getValue();
            System.out.println("Course: " + courseName + ", Mark: " + mark);
        }
    }

    public void rateTeacher(Teacher teacher, double rating) {
        teacher.receiveRating(rating);
    }

    public void viewCourses() {
        for (Course course : courseInfo.keySet()) {
            System.out.println(course.getNameCourse());
        }
    }

    public void viewSchedule() {
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            Course enrolledCourse = entry.getKey();
            List<Teacher> courseTeachers = (List<Teacher>) enrolledCourse.getInstructors();

            System.out.println("Course: " + enrolledCourse.getNameCourse());

            for (Teacher courseTeacher : courseTeachers) {
                System.out.println("Teacher: " + courseTeacher.getFirstName());
            }

            System.out.println();
        }
    }

    public void registerToCourse(Course course) {
        Data data = Data.getInstance();

        courseInfo.put(course, null);

        for (Teacher teacher : data.getAllTeacher()) {
            if (teacher.getCourses().contains(course)) {
                instructors.add(teacher);
            }
        }
    }

    public void viewInfoAboutTeachers(Course course) {
        List<Teacher> instructors = (List<Teacher>) course.getInstructors();
        for (Teacher instructor : instructors) {
            System.out.println(instructor.getFirstName());
        }
    }

    public void joinStudentOrganization(StudentOrganisation organization) {
        this.studentOrganization = organization;
        organization.addMember(this);
    }

    public void leaveStudentOrganization(StudentOrganisation organization) {
        if (studentOrganization != null) {
            studentOrganization.removeMember(this);
        }
    }

    public void becomeHeadOfOrganization(StudentOrganisation organization) {
        this.studentOrganization = organization;
        organization.setHead(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Student{" +
                "faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", organisation=" + organisation +
                ", courseInfo=" + courseInfo +
                ", teachers=" + teachers +
                ", studentOrganization=" + studentOrganization +
                ", diplomaProject='" + diplomaProject + '\'' +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
