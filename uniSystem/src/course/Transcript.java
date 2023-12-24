package course;

import java.util.HashMap;
import java.util.Map;

public class Transcript {
    private Map<Course, Mark> courseMarks;

    public Transcript() {
        courseMarks = new HashMap<>();
    }

    public void addMark(Course course, Mark mark) {
        courseMarks.put(course, mark);
    }

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
