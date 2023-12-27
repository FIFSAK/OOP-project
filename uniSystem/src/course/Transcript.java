package course;

import java.util.HashMap;
import java.util.Map;

/**
 * The Transcript class represents a student's academic transcript, including course marks.
 * It provides methods to add course marks and calculate the total GPA.
 */
public class Transcript {
    private Map<Course, Mark> courseMarks;

    /**
     * Constructs an empty Transcript object with no course marks.
     */
    public Transcript() {
        courseMarks = new HashMap<>();
    }

    /**
     * Adds a course mark to the transcript.
     *
     * @param course The course for which the mark is being added.
     * @param mark   The mark associated with the course.
     */
    public void addMark(Course course, Mark mark) {
        courseMarks.put(course, mark);
    }

    /**
     * Calculates the total GPA based on the marks of individual courses and their associated credits.
     *
     * @return The calculated total GPA.
     */
    public double totalGPA() {
        double totalWeightedGPA = 0.0;
        double totalCredits = 0.0;

        for (Map.Entry<Course, Mark> entry : courseMarks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();

            double courseGPA = mark.getGPA();
            int courseCredits = course.getCreditsAmount();

            totalWeightedGPA += courseGPA * courseCredits;
            totalCredits += courseCredits;
        }

        if (totalCredits == 0.0) {
            return 0.0;
        }

        return totalWeightedGPA / totalCredits;
    }
}
