package users;

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
import researcher.ResearcherDecorator;


public class Student extends User {

    private Faculties faculty;
    private int yearOfStudy;
    private int yearOfReceipt;
    private StudentOrganisation organisation;
    private HashMap<Course, Mark> courseInfo;
    private Teacher teacher;
    private Course course;
    private StudentOrganisation studentOrganization;

    public Student(String login, String password) {
        super(login, password);
        this.faculty = Faculties.BS;
        this.yearOfStudy = 1;
        this.courseInfo = new HashMap<>();
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


    private Transcript generateTranscript() {
        Transcript transcript = new Transcript();
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            transcript.addCourseMark(course.getNameCourse(), mark);
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
 // TODO final result need
//    public void viewSchedule() {   
//         for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
//             Course enrolledCourse = entry.getKey();
//             Teacher courseTeacher = enrolledCourse.getInstructors().get(0);
//
//
//             for (String scheduleEntry : enrolledCourse.getSchedule()) {
//                 System.out.println(scheduleEntry);
//             }
//
//             System.out.println();
//        }
//    }
    
    
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
    	
    public void becomeHeadOfOrganization(StudentOrganisation organization) {
    	this.studentOrganization=organization;
        organization.setHead(this);
    }
    
//    public static List<Student> getCourses(Course course) {
//        return Data.getInstance().getAllUsers().
//                filter(s -> s.courseInfo.containsKey(course))
//                .collect(Collectors.toList());
//    }
    public String toString() {
    	return super.toString()+
    			"Student{" +
                "faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", organisation=" + organisation +
                ", courseInfo=" + courseInfo +
                ", teacher=" + teacher +
                ", course=" + course +
                ", studentOrganization=" + studentOrganization +
                '}';    
    }
    
}
