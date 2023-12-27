package users;

import java.io.*;
import java.util.Date;
import java.util.List;

import additional.Message;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;


/**
 * The Employee class represents an employee in the university.
 * Extends the User class and implements the Payable interface.
 */
public class Employee extends User implements Payable {

    private String workDepartment;
    private int salary;
    private Date dateOfEmployment;

    /**
     * Constructs a new Employee with the specified parameters.
     *
     * @param firstName      The first name of the employee.
     * @param lastName       The last name of the employee.
     * @param password       The password of the employee.
     * @param login          The login ID of the employee.
     * @param dateOfBirth    The date of birth of the employee.
     * @param phoneNumber    The phone number of the employee.
     * @param iin            The Individual Identification Number of the employee.
     * @param category       The gender category of the employee.
     * @param nationality    The nationality of the employee.
     * @param familyStatus   The family status of the employee.
     */
    public Employee(String firstName, String lastName, String password, String login,
                    Date dateOfBirth, String phoneNumber, int iin,
                    Gender category, String nationality, FamilyStatus familyStatus) {
        super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
                nationality, familyStatus);
    }

    /**
     * Constructs a new Employee with the specified login and password.
     *
     * @param login     The login ID of the employee.
     * @param password  The password of the employee.
     */
    public Employee(String login, String password) {
        super(login, password);
    }

    /**
     * Gets the date of employment of the employee.
     *
     * @return The date of employment.
     */
    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    /**
     * Sets the date of employment for the employee.
     *
     * @param dateOfEmployment The date of employment to be set.
     */
    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return The salary.
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Sets the salary for the employee.
     *
     * @param salary The salary to be set.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the work department of the employee.
     *
     * @return The work department.
     */
    public String getWorkDepartment() {
        return this.workDepartment;
    }

    /**
     * Sets the work department for the employee.
     *
     * @param workDepartment The work department to be set.
     */
    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }
    
    // Additional methods and functionality can be added here
}