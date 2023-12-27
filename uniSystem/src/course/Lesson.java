package course;

import users.*;
import enums.*;

import java.util.ArrayList;
import java.util.List;

import additional.*;
import course.*;

/**
 * The Lesson class represents a single session of an academic course.
 * It contains information such as lesson type, duration, frequency, schedule,
 * and total duration per week.
 */
public class Lesson {
    private LessonType lessonType;
    private int duration; // Duration of one lesson (in minutes)
    private int frequency; // Frequency of lessons per week
    private List<DayOfWeek> schedule; // Schedule of lessons
    private int totalDuration; // Total duration per week (in minutes)

    /**
     * Constructor for creating a Lesson instance.
     *
     * @param lessonType The type of the lesson (lecture/seminar/laboratory).
     * @param duration   The duration of one lesson in minutes.
     * @param frequency  The frequency of lessons per week.
     * @param schedule   The schedule of lessons on specific days of the week.
     */
    public Lesson(LessonType lessonType, int duration, int frequency, List<DayOfWeek> schedule) {
        this.lessonType = lessonType;
        this.duration = duration;
        this.frequency = frequency;
        this.schedule = new ArrayList<>(schedule);
        calculateTotalDuration();
    }

    /**
     * Gets the type of the lesson.
     *
     * @return The type of the lesson.
     */
    public LessonType getLessonType() {
        return lessonType;
    }

    /**
     * Gets the duration of one lesson.
     *
     * @return The duration of one lesson in minutes.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the frequency of lessons per week.
     *
     * @return The frequency of lessons per week.
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Gets a copy of the list representing the schedule of lessons.
     *
     * @return The schedule of lessons on specific days of the week.
     */
    public List<DayOfWeek> getSchedule() {
        return new ArrayList<>(schedule);
    }

    /**
     * Gets the total duration of lessons per week.
     *
     * @return The total duration of lessons per week in minutes.
     */
    public int getTotalDuration() {
        return totalDuration;
    }

    /**
     * Calculates the total duration of lessons per week based on duration and frequency.
     */
    private void calculateTotalDuration() {
        totalDuration = duration * frequency;
    }
}