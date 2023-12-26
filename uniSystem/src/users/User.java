package users;

import java.io.*;
import java.util.Date;
import additional.*;
import data.Data;
import enums.*;
import researcher.*;

public class User implements Comparable<User>, Observer, Serializable{
	
	Data data = Data.getInstance();

    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private String userId;
    private UserType userType;
    private UniversityJournal subscribedJournals = new UniversityJournal();
    private Date dateOfBirth;
    private String phoneNumber;
    private int iin;
    private Gender gender;
    private String nationality;
    private FamilyStatus familyStatus;
    private UserFactory userFactory;
	private Observer observer;
    private Comment comment;
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String firstName, String lastName, String password, String login,
            Date dateOfBirth, String phoneNumber,
            int iin, Gender gender, String nationality, FamilyStatus familyStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.login = login;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.iin = iin;
        this.gender = gender;
        this.nationality = nationality;
        this.familyStatus = familyStatus;
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIin() {
        return iin;
    }

    public void setIin(int iin) {
        this.iin = iin;
    }

    public Gender getGender() {
        return gender;
    }

    public void setCategory(Gender category) {
        this.gender = category;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }
    
    public void viewNews() {
    	for(News newss: data.getAllNews()) {
    		System.out.println(newss);
    	}
    }
    
    public void viewUniversityJournal() {
    	
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", userId='" + userId + '\'' +
                ", userType=" + userType +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userId.equals(user.userId);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    // compareTo method
    @Override
    public int compareTo(User otherUser) {
        return userId.compareTo(otherUser.userId);
    }

	@Override
	 public void update(String latestPaper) {
        // Implement actions to be performed when the user is notified of a new paper
        System.out.println("User " + login + " received an update: " + latestPaper);
    }

}
