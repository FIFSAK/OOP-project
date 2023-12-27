package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
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


/**
 * The Student class represents a student user in the system.
 */

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
    private double GPA;
    private ResourceBundle messages;
    
    private void printMessage(String key, Object... args) {
        String message = messages.getString(key);
        System.out.println(args.length > 0 ? String.format(message, args) : message);
    }

    
    /**
     * Constructs a new Student with the given login and password.
     *
     * @param login    The login of the student.
     * @param password The password of the student.
     */

    public Student(String login, String password) {
        super(login, password);
        this.yearOfStudy = 1;
        this.courseInfo = new HashMap<>();
        this.instructors = new HashSet<>();
        this.diplomaProject = "";
        this.GPA = 0.0;
    }
    
    /**
     * Constructs a new Student with detailed information.
     *
     * @param firstName    The first name of the student.
     * @param lastName     The last name of the student.
     * @param password     The password of the student.
     * @param login        The login of the student.
     * @param dateOfBirth  The date of birth of the student.
     * @param phoneNumber  The phone number of the student.
     * @param iin           The individual identification number of the student.
     * @param category      The gender category of the student.
     * @param nationality   The nationality of the student.
     * @param familyStatus  The family status of the student.
     */

    public Student(String firstName, String lastName, String password, String login, 
    			Date dateOfBirth, String phoneNumber, 
    			int iin, Gender category, String nationality, FamilyStatus familyStatus) {
        super(firstName, lastName, password, login, 
        		dateOfBirth, phoneNumber, iin, category,
                nationality, familyStatus);
    }
    
    /**
     * Calculates the average GPA based on the student's course marks.
     */
    
    public void calculateAverageGPA() {
        double totalGPA = 0.0;
        int count = 0;

        for (Mark mark : courseInfo.values()) {
            if (mark != null) {
                totalGPA += mark.getGPA();
                count++;
            }
        }

        if (count > 0) {
            this.GPA = totalGPA / count;
        } else {
            this.GPA = 0.0; 
        }
    }
    
    /**
     * Gets the average GPA of the student.
     *
     * @return The average GPA.
     */
    
    public double getAvgGPA() {
    	return this.GPA;
    }
    
    /**
     * Gets the year of receipt of the student.
     *
     * @return The year of receipt.
     */

    public int getYearOfReceipt() {
        return yearOfReceipt;
    }
    
    /**
     * Sets the year of receipt for the student.
     *
     * @param yearOfReceipt The new year of receipt to set.
     */

    public void setYearOfReceipt(int yearOfReceipt) {
        this.yearOfReceipt = yearOfReceipt;
    }
    
    /**
     * Gets the faculty of the student.
     *
     * @return The faculty.
     */

    public Faculties getFaculty() {
        return faculty;
    }
    
    /**
     * Sets the faculty for the student.
     *
     * @param faculty The new faculty to set.
     */

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
    
    /**
     * Gets the year of study of the student.
     *
     * @return The year of study.
     */

    public int getYearOfStudy() {
        return yearOfStudy;
    }
    
    /**
     * Sets the year of study for the student.
     *
     * @param yearOfStudy The new year of study to set.
     */

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    /**
     * Gets the student organization of the student.
     *
     * @return The student organization.
     */

    public StudentOrganisation getOrganisation() {
        return organisation;
    }
    
    /**
     * Sets the student organization for the student.
     *
     * @param organisation The new student organization to set.
     */

    public void setOrganisation(StudentOrganisation organisation) {
        this.organisation = organisation;
    }
    
    /**
     * Gets the course information of the student.
     *
     * @return The course information.
     */

    public HashMap<Course, Mark> getCourseInfo() {
        return courseInfo;
    }
    
    /**
     * Sets the course information for the student.
     *
     * @param courseInfo The new course information to set.
     */

    public void setCourseInfo(HashMap<Course, Mark> courseInfo) {
        this.courseInfo = courseInfo;
    }
    
    /**
     * Gets the student organization of the student.
     *
     * @return The student organization.
     */

    public StudentOrganisation getStudentOrganization() {
        return studentOrganization;
    }
    
    /**
     * Sets the student organization for the student.
     *
     * @param studentOrganization The new student organization to set.
     */

    public void setStudentOrganization(StudentOrganisation studentOrganization) {
        this.studentOrganization = studentOrganization;
    }
    
    /**
     * Gets the diploma project of the student.
     *
     * @return The diploma project.
     */
    
    public String getDiplomaProject() {
        return diplomaProject;
    }
    
    /**
     * Sets the diploma project for the student.
     *
     * @param diplomaProject The new diploma project to set.
     */
    public void setDiplomaProject(String diplomaProject) {
        this.diplomaProject = diplomaProject;
    }
    
    /**
     * Generates a transcript for the student based on the course marks.
     *
     * @return The generated transcript.
     */

    private Transcript generateTranscript() {
        Transcript transcript = new Transcript();
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            transcript.addMark(course, mark);
        }
        return transcript;
    }
    /**
     * Displays the transcript of the student.
     */

    public void viewTranscript() {
        Transcript transcript = generateTranscript();
        System.out.println(transcript);
    }
    
    /**
     * Gets the transcript of the student.
     *
     * @return The transcript of the student.
     */

    public Transcript getTranscript() {
        return generateTranscript();
    }
    
    /**
     * Displays the marks for each course enrolled by the student.
     */

    public void viewMarks() {
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            String courseName = entry.getKey().getNameCourse();
            Mark mark = entry.getValue();
            System.out.println("Course: " + courseName + ", Mark: " + mark);
        }
    }

//    public void rateTeacher(Teacher teacher, double rating) {
//        teacher.receiveRating(rating);
//    }
    
    /**
     * Displays the names of the courses enrolled by the student.
     */

    public void viewCourses() {
        for (Course course : courseInfo.keySet()) {
            System.out.println(course.getNameCourse());
        }
    }

    public void viewSchedule() {
        for (HashMap.Entry<Course, Mark> entry : courseInfo.entrySet()) {
            Course enrolledCourse = entry.getKey();
            List<Teacher> courseTeachers = (List<Teacher>) enrolledCourse.getInstructors();

            printMessage("courseName", enrolledCourse.getNameCourse());

            for (Teacher courseTeacher : courseTeachers) {
                printMessage("teacherName", courseTeacher.getFirstName());
            }

            System.out.println();
        }
    }
    
    /**
     * Registers the student to a new course and assigns instructors for that course.
     *
     * @param course The course to register for.
     */

    public void registerToCourse(Course course) {
        Data data = Data.getInstance();

        courseInfo.put(course, null);

        for (Teacher teacher : data.getAllTeacher()) {
            if (teacher.getCourses().contains(course)) {
                instructors.add(teacher);
            }
        }
    }
    /**
     * Displays information about the teachers associated with a specific course.
     *
     * @param course The course to get information about.
     */
    public void viewInfoAboutTeachers(Course course) {
        List<Teacher> instructors = (List<Teacher>) course.getInstructors();
        for (Teacher instructor : instructors) {
            System.out.println(instructor.getFirstName());
        }
    }
    
    /**
     * Joins a student organization and adds the student as a member.
     *
     * @param organization The student organization to join.
     */

    public void joinStudentOrganization(StudentOrganisation organization) {
        this.studentOrganization = organization;
        organization.addMember(this);
    }
    
    /**
     * Leaves the current student organization if the student is a member.
     *
     * @param organization The student organization to leave.
     */

    public void leaveStudentOrganization(StudentOrganisation organization) {
        if (studentOrganization != null) {
            studentOrganization.removeMember(this);
        }
    }
    
    /**
     * Becomes the head of a student organization.
     *
     * @param organization The student organization to lead.
     */

    public void becomeHeadOfOrganization(StudentOrganisation organization) {
        this.studentOrganization = organization;
        organization.setHead(this);
    }
    
    /**
     * Overrides the default toString() method to provide a string representation
     * of the student, including details about the faculty, year of study,
     * organization, course information, teachers, student organization, and
     * diploma project.
     *
     * @return A string representation of the student.
     */

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
    
    /**
     * Overrides the default writeObject() method to customize the serialization
     * process for the Student class.
     *
     * @param out The ObjectOutputStream used for serialization.
     * @throws IOException If an I/O error occurs during serialization.
     */

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    
    /**
     * Overrides the default readObject() method to customize the deserialization
     * process for the Student class.
     *
     * @param in The ObjectInputStream used for deserialization.
     * @throws IOException            If an I/O error occurs during deserialization.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
    
    /**
     * Adds a mark for the specified course.
     *
     * @param course The course for which to add the mark.
     * @param mark   The mark to add.
     */
    public void addMarkForCourse(Course course, Mark mark) {
        // Check if the student is enrolled in the specified course
        if (courseInfo.containsKey(course)) {
            // Associate the mark with the course
            courseInfo.put(course, mark);
            // Calculate and update the average GPA for the student
            calculateAverageGPA();
            printMessage("markAddedSuccessfully");

        } else {
            printMessage("studentNotEnrolledInCourseError");
        }
    }
}
