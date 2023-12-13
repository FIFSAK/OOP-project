package course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import enums.DayOfWeek;
import enums.Faculties;
import enums.LessonType;
import users.*;


public class Course {
    private String codeCourse;
    private String nameCourse;
    private List<Course> prerequisites; // Список курсов-пререквизитов
    private List<Lesson> lessons;
    private Faculties faculty;
    private String description;
    private int creditsAmount;
    private List<Teacher> instructors;

    // Конструктор, геттеры и сеттеры

    public Course(String codeCourse, String nameCourse, Faculties faculty) {
        this.codeCourse = codeCourse;
        this.nameCourse = nameCourse;
        this.faculty = faculty;
        this.instructors = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }
    
    public Course(String codeCourse, String nameCourse, Faculties faculty, 
    		int creditsAmount, List<Course> prerequisites, List<Teacher> instructors) {
        this(codeCourse, nameCourse, faculty);
        this.creditsAmount = creditsAmount;
        this.prerequisites = new ArrayList<>(prerequisites);
        this.instructors = new ArrayList<>(instructors);
    }

    public String getCodeCourse() {
        return codeCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public List<Course> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = new ArrayList<>(prerequisites);
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = new ArrayList<>(lessons);
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditsAmount() {
        return creditsAmount;
    }

    public void setCreditsAmount(int creditsAmount) {
        this.creditsAmount = creditsAmount;
    }

    public List<Teacher> getInstructors() {
        return new ArrayList<>(instructors);
    }

    public void setInstructors(List<Teacher> instructors) {
        this.instructors = new ArrayList<>(instructors);
    }

    // Операции

    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor);
    }
    
    public int getTotalDuration() {
        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.getTotalDuration();
        }
        return totalDuration;
    }
    
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

            // Создание нового Lesson и добавление его в lessons
            Lesson lesson = new Lesson(lessonType, duration, frequency, lessonDays);
            lessons.add(lesson);

            System.out.println("Lesson information added successfully!");
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();  // Обработка ошибок (возможно, нужно её улучшить)
        }
    }

    // Другие методы, если необходимо
}
