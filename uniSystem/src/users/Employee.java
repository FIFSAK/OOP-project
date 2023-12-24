package users;

import java.util.Date;
import java.util.List;

import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

public class Employee extends User implements Payable {
    
    public Employee(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
	}

	public Employee(String login, String password) {
		super(login, password);
	}

	private String workDepartment;
    private int salary;
//    private Date data;
    Date dateOfEmployment;
    
    public Date getDateOfEmplyment(){
		return dateOfEmployment;
    }
    
    public void setDateOfEmplyment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
    
    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    private String getWorkDepartment() {
        return this.workDepartment;
    }
  
    private void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

 
//    public Date getData() {
//        return this.data;
//    }
//
//    public void setData(Date data) {
//        this.data = data;
//    }
    
    public static void processEmployees(List<Employee> employees) {
        employees.stream()
                 .filter(e -> e.getSalary() > 50000)
                 .forEach(System.out::println);
    }
    
    
}