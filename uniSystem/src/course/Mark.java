package course;

import users.*;
import enums.*;
import researcher.*;
import additional.*;
import course.*;

public class Mark {
    
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


    
    public double calculateGPA() {
        return 0.0;
    }
}
