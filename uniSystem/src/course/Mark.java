package course;

import users.*;
import enums.*;
import researcher.*;

import java.io.Serializable;

import additional.*;
import course.*;

public class Mark implements Serializable{
    
    private double secondAttestation;
    private double firstAttestation;
    private double finalExam;
    private double GPA;
    private Grade grade;
    private Course course;
    
    public double getSecondAttestation() {
        return this.secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getFirstAttestation() {
        return this.firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public double getFinalExam() {
        return this.finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * Calculates the Grade Point Average (GPA) based on the provided scores.
     *
     * @return The calculated Grade Point Average (GPA).
     */
    public double calculateGPA() {
        // Assuming equal weight for each component (adjust weights as needed)
        double secondAttestationWeight = 0.3;
        double firstAttestationWeight = 0.3;
        double finalExamWeight = 0.4;

        // Assuming a linear scale for mapping scores to GPA (adjust scale as needed)
        double secondAttestationGPA = mapScoreToGPA(secondAttestation);
        double firstAttestationGPA = mapScoreToGPA(firstAttestation);
        double finalExamGPA = mapScoreToGPA(finalExam);

        // Calculate weighted GPA
        GPA = (secondAttestationWeight * secondAttestationGPA +
               firstAttestationWeight * firstAttestationGPA +
               finalExamWeight * finalExamGPA);

        return GPA;
    }

    /**
     * Maps a numerical score to a GPA value.
     * Adjust this method based on your grading scale.
     *
     * @param score The numerical score.
     * @return The corresponding GPA value.
     */
    private double mapScoreToGPA(double score) {
        // Example linear mapping (adjust as per your grading scale)
        if (score >= 90) {
            return 4.0;
        } else if (score >= 80) {
            return 3.0;
        } else if (score >= 70) {
            return 2.0;
        } else if (score >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
