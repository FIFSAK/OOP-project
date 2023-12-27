package users;

import java.util.Date;

import javax.xml.crypto.Data;

import additional.Request;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

/**
 * The Dean class represents a dean in the university.
 * Extends the Employee class.
 */
public class Dean extends Employee {
    
    /**
     * Constructs a new Dean with the specified parameters.
     *
     * @param firstName      The first name of the dean.
     * @param lastName       The last name of the dean.
     * @param password       The password of the dean.
     * @param login          The login ID of the dean.
     * @param dateOfBirth    The date of birth of the dean.
     * @param phoneNumber    The phone number of the dean.
     * @param iin            The Individual Identification Number of the dean.
     * @param category       The gender category of the dean.
     * @param nationality    The nationality of the dean.
     * @param familyStatus   The family status of the dean.
     */
    public Dean(String firstName, String lastName, String password, String login,
                Date dateOfBirth, String phoneNumber, int iin,
                Gender category, String nationality, FamilyStatus familyStatus) {
        super(firstName, lastName, password, login, dateOfBirth, phoneNumber, iin, category,
                nationality, familyStatus);
    }

    private Date data;

    /**
     * Gets the data associated with the dean.
     *
     * @return The data associated with the dean.
     */
    public Date getData() {
        return this.data;
    }

    /**
     * Sets the data associated with the dean.
     *
     * @param data The data to be set.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Signs a request, setting it as signed.
     *
     * @param request The request to be signed.
     */
    public void signRequest(Request request) {
        request.setSigned(true);
    }
}







