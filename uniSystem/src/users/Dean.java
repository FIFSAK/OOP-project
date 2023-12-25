package users;

import java.util.Date;

import javax.xml.crypto.Data;

import additional.Request;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

public class Dean extends Employee {
   
    public Dean(String firstName, String lastName, String password, String login, String userId,
			ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus, Date dateOfEmployment) {
		super(firstName, lastName, password, login, userId, subscribedJournals, name, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus, dateOfEmployment);
		// TODO Auto-generated constructor stub
	}

	private Date data;
  
    public Date getData() {
        return this.data;
    }
 
    public void setData(Date data) {
        this.data = data;
    }
    
    public void signRequest(Request request) {
        
    	request.setSigned(true);
    }
    
}

