package users;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import additional.*;
import data.Data;
import enums.*;
import researcher.*;

/**
 * The `User` class represents a user in the system with attributes such as first name, last name, login credentials,
 * personal information, and roles. Users can edit their data, view news, and subscribe to the university journal to
 * receive updates on new research papers.
 *
 * This class implements the `Comparable` and `Observer` interfaces to support comparisons and observe updates from
 * the university journal.
 *
 */

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
    
    /**
     * Default constructor for the `User` class.
     */
    
    public User() {}
    
    /**
     * Parameterized constructor for creating a user with login credentials.
     *
     * @param login    The user's login.
     * @param password The user's password.
     */
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    /**
     * Parameterized constructor for creating a user with detailed information.
     *
     * @param firstName     The user's first name.
     * @param lastName      The user's last name.
     * @param login         The user's login.
     * @param password      The user's password.
     * @param dateOfBirth   The user's date of birth.
     * @param phoneNumber   The user's phone number.
     * @param iin           The user's IIN (Individual Identification Number).
     * @param gender        The user's gender.
     * @param nationality   The user's nationality.
     * @param familyStatus  The user's family status.
     */
    
    public User(String firstName, String lastName, String login, String password, Date dateOfBirth,
            String phoneNumber, int iin, Gender gender, String nationality, FamilyStatus familyStatus) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.login = login;
    this.password = password;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.iin = iin;
    this.gender = gender;
    this.nationality = nationality;
    this.familyStatus = familyStatus;
    }   
    
    /**
     * Allows the user to edit their personal information such as first name, last name, password, etc.
     * The user is prompted to choose which information to edit through the console.
     */
    

    public void editData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Select an option to edit:");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Password");
            System.out.println("4. Date of Birth");
            System.out.println("5. Phone Number");
            System.out.println("6. Family Status");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter new first name:");
                    String newFirstName = reader.readLine();
                    setFirstName(newFirstName);
                    break;
                case 2:
                    System.out.println("Enter new last name:");
                    String newLastName = reader.readLine();
                    setLastName(newLastName);
                    break;
                case 3:
                    System.out.println("Enter new password:");
                    String newPassword = reader.readLine();
                    setPassword(newPassword);
                    break;
                case 5:
                    // Handle Date of Birth input
                    // You may want to use SimpleDateFormat to parse the input
                    break;
                case 6:
                    System.out.println("Enter new phone number:");
                    String newPhoneNumber = reader.readLine();
                    setPhoneNumber(newPhoneNumber);
                    break;
                case 10:
                    System.out.println("Enter new family status (SINGLE/MARRIED/OTHER):");
                    String newFamilyStatusStr = reader.readLine().toUpperCase();
                    FamilyStatus newFamilyStatus = FamilyStatus.valueOf(newFamilyStatusStr);
                    setFamilyStatus(newFamilyStatus);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("User data updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }}

    // Getters and Setters

    /**
     * Getter method for retrieving the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for updating the user's first name.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for retrieving the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for updating the user's last name.
     *
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for retrieving the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for updating the user's password.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for retrieving the user's login.
     *
     * @return The user's login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter method for updating the user's login.
     *
     * @param login The new login to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter method for retrieving the user's ID.
     *
     * @return The user's ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for updating the user's ID.
     *
     * @param userId The new user ID to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for retrieving the user's type (e.g., student, faculty).
     *
     * @return The user's type.
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Setter method for updating the user's type.
     *
     * @param userType The new user type to set.
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Getter method for retrieving the user's date of birth.
     *
     * @return The user's date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter method for updating the user's date of birth.
     *
     * @param dateOfBirth The new date of birth to set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter method for retrieving the user's phone number.
     *
     * @return The user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter method for updating the user's phone number.
     *
     * @param phoneNumber The new phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method for retrieving the user's IIN (Individual Identification Number).
     *
     * @return The user's IIN.
     */
    public int getIin() {
        return iin;
    }

    /**
     * Setter method for updating the user's IIN.
     *
     * @param iin The new IIN to set.
     */
    public void setIin(int iin) {
        this.iin = iin;
    }

    /**
     * Getter method for retrieving the user's gender.
     *
     * @return The user's gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Setter method for updating the user's gender.
     *
     * @param gender The new gender to set.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Getter method for retrieving the user's nationality.
     *
     * @return The user's nationality.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Setter method for updating the user's nationality.
     *
     * @param nationality The new nationality to set.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Getter method for retrieving the user's family status.
     *
     * @return The user's family status.
     */
    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    /**
     * Setter method for updating the user's family status.
     *
     * @param familyStatus The new family status to set.
     */
    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }
    
    public void viewNews() {
        Vector<News> newsList = data.getAllNews(); // Assuming data is an instance of Data

        if (newsList.isEmpty()) {
            System.out.println("No news available.");
        } else {
            System.out.println("Latest News:");
            for (int i = 0; i < newsList.size(); i++) {
                News news = newsList.get(i);
                System.out.println((i + 1) + ". Title: " + news.getTitle());
                System.out.println("   Content: " + news.getContent());

                // Option to view comments
                System.out.println("   Do you want to view comments? (Y/N)");
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String choice = reader.readLine();

                    if (choice.equalsIgnoreCase("Y")) {
                        viewComments(news);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("---------------");
            }
        }
    }
    private void viewComments(News news) {
        List<Comment> comments = news.getComments();
        if (comments.isEmpty()) {
            System.out.println("No comments available.");
        } else {
            System.out.println("Comments:");
            for (Comment comment : comments) {
                System.out.println("   User: " + comment.getAuthor());
                System.out.println("   Comment: " + comment.getContent());
                System.out.println("   ---------------");
            }
        }
    }
    
    public void viewUniversityJournal() {
        List<ResearchPaper> researchPapers = data.getResearchPaper(); // Assuming data is an instance of Data

        if (researchPapers.isEmpty()) {
            System.out.println("University journal is empty.");
        } else {
            System.out.println("University Journal:");
            for (ResearchPaper paper : researchPapers) {
                System.out.println("Title: " + paper.name);
                System.out.println("Authors: " + paper.getAuthorsOfPaper(paper));
                System.out.println("Pages: " + paper.pages);
                System.out.println("Journal: " + paper.journal);
                System.out.println("Text: " + paper.text);
                System.out.println("Citations: " + paper.getCitation(Format.PLAIN_TEXT)); 
            }
        }
    }
    
    /**
     * Returns a string representation of the `User` object.
     *
     * @return A string containing relevant user information.
     */


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User : ")
                .append("firstName='").append(firstName).append('\'')
                .append(", lastName='").append(lastName).append('\'')
                .append(", login='").append(login).append('\'')
                .append(", userId='").append(userId).append('\'')
                .append(", userType=").append(userType)
                .append(", dateOfBirth=").append(dateOfBirth)
                .append(", phoneNumber='").append(phoneNumber).append('\'')
                .append(", iin=").append(iin)
                .append(", gender=").append(gender)
                .append(", nationality='").append(nationality).append('\'')
                .append(", familyStatus=").append(familyStatus);
        return stringBuilder.toString();
    }
    
    /**
     * Subscribe the user to a university journal, enabling them to receive updates about new research papers.
     *
     * @param journal The university journal to subscribe to.
     */
    
    public void subscribeToJournal(UniversityJournal journal) {
        journal.addObserver(this);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public int compareTo(User otherUser) {
        return userId.compareTo(otherUser.userId);
    }
    /**
     * Update method called when the user receives a notification about new papers in the subscribed journal.
     */
    public void update() {
        System.out.println("Observer " + this.firstName + " " + this.lastName + " received an update. New papers are available!");
    }

 }
