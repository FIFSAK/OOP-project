package users;

import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;

import additional.UserFactory;
import data.Data;
import enums.FamilyStatus;
import enums.Gender;
import researcher.ResearchPaper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin extends User implements Serializable{
    
    public Admin() {}

    public Admin(String login, String password) {
        super(login, password);
    }

    public void addUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter new user information:");

            System.out.println(messages.getString("enterLogin"));
			String login = reader.readLine();

			System.out.println(messages.getString("enterPassword"));
			String password = reader.readLine();

            // Use UserFactory to create a new user

	        UserFactory userFactory = new UserFactory();

	        // Use UserFactory to create a new user
	        User newUser = userFactory.createUser(login, password);

	        // Output information about the added user
	        System.out.println("User added successfully:");
	        System.out.println("Login: " + newUser.getLogin());
	        System.out.println("User Type: " + newUser.getUserType());
	        System.out.println("User ID: " + newUser.getUserId());
	        
	        data.addUser(newUser);
	        System.out.println(messages.getString("addUserCongrat"));
	    } catch (IOException e) {
			e.printStackTrace();
		}
    }
	    
    public void removeUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(messages.getString("removeUserPrompt"));
            String loginToRemove = reader.readLine();

            // Call a method to remove the user with the specified login
            User remUser = data.getUserByLogin(loginToRemove);
            boolean removed = data.getAllUsers().remove(remUser);

            if (removed) {
                System.out.println(messages.getString("userRemovedSuccessfully"));
            } else {
                System.out.println(messages.getString("userNotFound"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
