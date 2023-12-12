package additional;

import users.User;

import enums.UserType;
import users.Employee;
import users.Student;
import users.User;

public class UserFactory {
    private User user;
    private static int studentCount = 1;
    private static int employeeCount = 1;

    public User createUser(String login, String password) {
        // Determine user type based on the login
        UserType userType = determineUserType(login);

        // Create the appropriate user
        switch (userType) {
            case STUDENT:
                user = new Student(login, password);
                break;
            case EMPLOYEE:
                user = new Employee(login, password);
                break;
            default:
                // Handle default case or throw an exception
                break;
        }

        // Set user type and generate user ID
        user.setUserType(userType);
        user.generateUserId(userType);

        return user;
    }

    private UserType determineUserType(String login) {
        if (login.contains(".")) {
            return UserType.EMPLOYEE;
        } else if (login.contains("_")) {
            return UserType.STUDENT;
        } else {
            // Default UserType or handle as needed
            return UserType.DEFAULT;
        }
    }
}
