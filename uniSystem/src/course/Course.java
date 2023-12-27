package course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import data.Data;
import enums.DayOfWeek;
import enums.Faculties;
import enums.LessonType;
import users.*;

/**
 * The Course class represents an academic course offered by a university.
 * It contains information such as course code, name, prerequisites, lessons,
 * faculty, description, credits amount, and instructors.
 */
public class Course implements Serializable{


    private String codeCourse;
    private String nameCourse;
    private List<Course> prerequisites;
    private List<Lesson> lessons;
    private Faculties faculty;
    private String description;
    private int creditsAmount;
    public List<Teacher> instructors;

    /**
     * Constructor for creating a basic Course instance with code, name, and faculty.
     *
     * @param codeCourse  The code of the course.
     * @param nameCourse  The name of the course.
     * @param faculty     The faculty to which the course belongs.
     */
    public Course(String codeCourse, String nameCourse, Faculties faculty) {
        this.codeCourse = codeCourse;
        this.nameCourse = nameCourse;
        this.faculty = faculty;
        this.instructors = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    /**
     * Constructor for creating a Course instance with additional details.
     *
     * @param codeCourse    The code of the course.
     * @param nameCourse    The name of the course.
     * @param faculty       The faculty to which the course belongs.
     * @param creditsAmount The amount of credits for the course.
     * @param prerequisites List of prerequisite courses.
     * @param instructors   List of instructors teaching the course.
     */
    public Course(String codeCourse, String nameCourse, Faculties faculty,
                  int creditsAmount, List<Course> prerequisites, List<Teacher> instructors) {
        this(codeCourse, nameCourse, faculty);
        this.creditsAmount = creditsAmount;
        this.prerequisites = new ArrayList<>(prerequisites);
//        this.instructors = new ArrayList<>(instructors);
    }

    /**
     * Gets the code of the course.
     *
     * @return The code of the course.
     */
    public String getCodeCourse() {
        return codeCourse;
    }

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    public String getNameCourse() {
        return nameCourse;
    }

    /**
     * Gets a copy of the list of prerequisite courses.
     *
     * @return List of prerequisite courses.
     */
    public List<Course> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

    /**
     * Sets the list of prerequisite courses.
     *
     * @param prerequisites List of prerequisite courses.
     */
    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = new ArrayList<>(prerequisites);
    }

    /**
     * Gets a copy of the list of lessons for the course.
     *
     * @return List of lessons for the course.
     */
    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    /**
     * Sets the list of lessons for the course.
     *
     * @param lessons List of lessons for the course.
     */
    public void setLessons(List<Lesson> lessons) {
        this.lessons = new ArrayList<>(lessons);
    }

    /**
     * Gets the faculty to which the course belongs.
     *
     * @return The faculty of the course.
     */
    public Faculties getFaculty() {
        return faculty;
    }

    /**
     * Gets the description of the course.
     *
     * @return The description of the course.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     *
     * @param description The description of the course.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the amount of credits for the course.
     *
     * @return The amount of credits for the course.
     */
    public int getCreditsAmount() {
        return creditsAmount;
    }

    /**
     * Sets the amount of credits for the course.
     *
     * @param creditsAmount The amount of credits for the course.
     */
    public void setCreditsAmount(int creditsAmount) {
        this.creditsAmount = creditsAmount;
    }

    /**
     * Gets a list of instructors teaching the course.
     *
     * @return List of instructors teaching the course.
     */
    public List<Teacher> getInstructors() {
        return Data.getInstance().getAllTeacher().stream()
                .filter(teacher -> teacher.getCourses().contains(this))
                .collect(Collectors.toList());
    }

    /**
     * Adds an instructor to the list of instructors teaching the course.
     *
     * @param instructor The instructor to be added.
     */
    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor);
    }

    /**
     * Calculates the total duration of all lessons in the course.
     *
     * @return The total duration of all lessons in minutes.
     */
    public int getTotalDuration() {
        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.getTotalDuration();
        }
        return totalDuration;
    }

    /**
     * Adds information for a new lesson to the course.
     */
    public void addLessonInfo() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter lesson information:");

            System.out.print("Lesson Type (lecture/seminar/laboratory): ");
            LessonType lessonType = LessonType.valueOf(reader.readLine().toUpperCase());

            System.out.print("Lesson Duration (in minutes): ");
            int duration = Integer.parseInt(reader.readLine());

            System.out.print("Lesson Frequency (times per week): ");
            int frequency = Integer.parseInt(reader.readLine());

            System.out.print("Days of the week (comma-separated): ");
            String[] daysOfWeek = reader.readLine().split(",");
            List<DayOfWeek> lessonDays = new ArrayList<>();
            for (String day : daysOfWeek) {
                lessonDays.add(DayOfWeek.valueOf(day.trim().toUpperCase()));
            }

            // Create a new Lesson and add it to lessons
            Lesson lesson = new Lesson(lessonType, duration, frequency, lessonDays);
            lessons.add(lesson);

            System.out.println("Lesson information added successfully!");
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();  // Error handling (may need improvement)
        }
    }

    // Other methods, if necessary
}