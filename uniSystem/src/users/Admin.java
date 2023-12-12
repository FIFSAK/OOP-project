package users;

import java.util.Date;

import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

public class Admin extends User{
	 public Admin(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
		// TODO Auto-generated constructor stub
	}

	     public void addUser() {
		 
	    }
	    
	    public void removeUser() {
	    	
	    }
	    
	    public void updateUser() {
	    	
	    }

}
