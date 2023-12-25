package users;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import additional.*;
import course.Course;
import course.Mark;
import course.Transcript;
import data.Data;
import enums.Faculties;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;
import researcher.ResearcherDecorator;


public class Student extends User {

    private Faculties faculty;
    private int yearOfStudy;
    private int yearOfReceipt;
    private StudentOrganisation organisation;
    private HashMap<Course, Mark> courseInfo;
    private List<Teacher> teacher;
//    private List<Course> course;
    private StudentOrganisation studentOrganization;

    public Student(String login, String password) {
        super(login, password);
        this.faculty = Faculties.BS;
        this.yearOfStudy = 1;
        this.courseInfo = new HashMap<>();
    }
     
    public Student(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
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


//
//    public Teacher getTeacher() {
//        return teacher;
//    }

//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public StudentOrganisation getStudentOrganization() {
        return studentOrganization;
    }

    public void setStudentOrganization(StudentOrganisation studentOrganization) {
        this.studentOrganization = studentOrganization;
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
   //TODO receive teacher
    public void rateTeacher(Teacher teacher,double rating){
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
            List<Teacher> courseTeachers = enrolledCourse.getInstructors();

            System.out.println("Course: " + enrolledCourse.getNameCourse());

            for (Teacher courseTeacher : courseTeachers) {
                System.out.println("Teacher: " + courseTeacher.getName());
            }

//            System.out.println("Schedule:");
//            for (String scheduleEntry : enrolledCourse.getSchedule()) {  // should be method getSchedule in Course
//                System.out.println(scheduleEntry);
//            }

            System.out.println();
        }
    }

    

    
    
    public Course registerToCourse(Course course) {
    	courseInfo.put(course,null);
    	return course;
    }
    public void viewInfoAboutTeachers(Course course) {
        List<Teacher> instructors = (List<Teacher>) course.getInstructors();
        for (Teacher instructor : instructors) {
            System.out.println(instructor.getName());
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
    	this.studentOrganization=organization;
        organization.setHead(this);
    }
    

    public String toString() {
    	return super.toString()+
    			"Student{" +
                "faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", organisation=" + organisation +
                ", courseInfo=" + courseInfo +
                ", teacher=" + teacher +
//                ", course=" + course +
                ", studentOrganization=" + studentOrganization +
                '}';    
    }
    
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}