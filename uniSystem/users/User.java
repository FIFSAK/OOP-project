package users;

import java.util.Date;
import enums.*;

public class User implements Comparable<User> {

    private String firstName;
    private String lastName;
    private String password;
    private String login;
    private String userId;
    private UserType userType;
    private ResearchPaper subscribedJournals;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private int iin;
    private Gender category;
    private String nationality;
    private FamilyStatus familyStatus;
    private UserFactory userFactory;
    private Observer observer;
    private Comment comment;
    
    public User (String)

    public User(String firstName, String lastName, String password, String login, String userId, UserType userType,
                ResearchPaper subscribedJournals, String name, Date dateOfBirth, String phoneNumber, int iin,
                Gender category, String nationality, FamilyStatus familyStatus, UserFactory userFactory,
                Observer observer, Comment comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.login = login;
        this.userId = userId;
        this.userType = userType;
        this.subscribedJournals = subscribedJournals;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.iin = iin;
        this.category = category;
        this.nationality = nationality;
        this.familyStatus = familyStatus;
        this.userFactory = userFactory;
        this.observer = observer;
        this.comment = comment;
    }
    
    public User(UserFactory userFactory) {
        this.login = userFactory.generateUserId();
        if (login.contains(".")) {
            this.userType = UserType.EMPLOYEE;
        } else if (login.contains("_")) {
            this.userType = UserType.STUDENT;
        } else {
            // Default UserType or handle as needed
            this.userType = UserType.DEFAULT;
        }
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

    public ResearchPaper getSubscribedJournals() {
        return subscribedJournals;
    }

    public void setSubscribedJournals(ResearchPaper subscribedJournals) {
        this.subscribedJournals = subscribedJournals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Gender getCategory() {
        return category;
    }

    public void setCategory(Gender category) {
        this.category = category;
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

    public UserFactory getUserFactory() {
        return userFactory;
    }

    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", userId='" + userId + '\'' +
                ", userType=" + userType +
                // Include other fields as needed
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
        // Implement comparison logic based on your requirements
        return userId.compareTo(otherUser.userId);
    }
}