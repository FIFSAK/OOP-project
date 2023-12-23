package users;

import java.util.Date;

import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

public class Employee extends User {
	
	private String workDepartment;
    private int salary;
    private Date hireDate;
    
    public Employee(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}

	public Employee(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
    
    private String getWorkDepartment() {
        return this.workDepartment;
    }
  
    private void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    private  int getSalary() {
        return this.salary;
    }

    private void  setSalary(int salary) {
        this.salary = salary;
    }
 
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setData(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    
}