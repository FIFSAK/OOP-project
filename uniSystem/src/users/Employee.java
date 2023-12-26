package users;

import java.util.Date;
import java.util.List;

import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;


public class Employee extends User implements Payable {

	private String workDepartment;
    private int salary;
    private Date dateOfEmployment;

    
    public Employee(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
	}

	public Employee(String login, String password) {
		super(login, password);
	}
    
    public Date getDateOfEmployment(){
		return dateOfEmployment;
    }
    
    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
    
    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    
    public String getWorkDepartment() {
        return this.workDepartment;
    }
  
    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    
    
}