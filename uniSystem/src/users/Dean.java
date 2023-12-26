package users;

import java.util.Date;

import javax.xml.crypto.Data;

import additional.Request;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

public class Dean extends Employee {
   
	public Dean(String firstName, String lastName, String password, String login,
			Date dateOfBirth, String phoneNumber, int iin,
			Gender category, String nationality, FamilyStatus familyStatus) {
		super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
				nationality, familyStatus);
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

