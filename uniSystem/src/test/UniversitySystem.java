package test;

import java.io.*;
import java.util.*;

import additional.*;
import data.Data;
import users.*;

public class UniversitySystem {

    private ResourceBundle messages;
    private Locale locale;
    private UserFactory userFactory;
    Data data = Data.getInstance();

    public UniversitySystem() {
        super();
        this.userFactory = new UserFactory();
    }

    public void logIn() {
        changeLanguage();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
//            System.out.println(messages.getString("enterLogin"));
            String login = reader.readLine();

//            System.out.println(messages.getString("enterPassword"));
            String password = reader.readLine();

            // Use the UserFactory to create or retrieve the user
            User user = userFactory.createUser(login, password);

            // Now you have the user object, and you can perform additional login logic
            // For example, check user type, display user info, etc.

//            System.out.println(messages.getString("loginSuccess"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(data.getAllUsers());
        
        
    }
       
        public void logOut() {
        	
        }
        
        public void changeLanguage() {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("Please choose a language:");
                System.out.println("1. English");
                System.out.println("2. Russian");
                System.out.println("3. Spanish");
                System.out.println("4. Kazakh");

                int languageChoice = Integer.parseInt(reader.readLine());

                switch (languageChoice) {
                    case 1:
                        locale = new Locale.Builder().setLanguage("en").build();
                        break;
                    case 2:
                        locale = new Locale.Builder().setLanguage("ru").build();
                        break;
                    case 3:
                        locale = new Locale.Builder().setLanguage("es").build();
                        break;
                    case 4:
                        locale = new Locale.Builder().setLanguage("kz").build();
                        break;
                    default:
                        System.out.println("Invalid choice. Using default locale (English).");
                        locale = new Locale.Builder().setLanguage("en").build();
                        break;
                }

                // Load messages based on the selected locale
                this.messages = ResourceBundle.getBundle("messages", locale);

                System.out.println(messages.getString("welcomeMessage"));
                System.out.println(messages.getString("loginPrompt"));

                // Your login logic here
                System.out.println(messages.getString("invalidChoice"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        	
        }
    

    public static void main(String[] args) {
        UniversitySystem universitySystem = new UniversitySystem();
        universitySystem.logIn();
    }
}
