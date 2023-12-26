package users;

import java.io.*;
import java.util.Date;
import java.util.List;

import additional.Message;
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
    
    public void applicationToTechSupport() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Prompt the user to enter the application content
            System.out.println("Enter your application to tech support:");
            String applicationContent = reader.readLine();

            // Create a message with the application content
            Message application = new Message(applicationContent);

            // Send the application message
            sendMessage(application);

            // Additional processing if needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void sendMessage(Message application) {
		Order techOrder = new ()
		
	}
    
}