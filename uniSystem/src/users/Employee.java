package users;

import java.io.*;
import java.util.Date;
import java.util.List;

import additional.Message;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;


public class Employee extends User implements Payable, Serializable{

	private String workDepartment;
    private int salary;
    private Date dateOfEmployment;

    
    public Employee(String firstName, String lastName, String password, String login,
			Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
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

    
    
//    public void applicationToTechSupport() {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            // Prompt the user to enter the application content
//            System.out.println("Enter your application to tech support:");
//            String applicationContent = reader.readLine();
//
//            // Create a message with the application content
//            Message application = new Message(applicationContent);
//
//            // Send the application message
//            sendMessage(application);
//
//            // Additional processing if needed
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



    
}