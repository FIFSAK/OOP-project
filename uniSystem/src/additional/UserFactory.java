package additional;

import users.User;

import enums.UserType;
import users.Employee;
import users.Student;
import users.User;

import java.time.LocalDateTime;
import java.util.*;

import data.Data;

/**
 * The UserFactory class is responsible for creating user instances based on the provided login and password.
 * It checks for existing users with the same login and generates unique user IDs for students and employees.
 */
public class UserFactory {

    // Counts to generate unique user IDs for students and employees
    private static int studentCount = 1;
    private static int employeeCount = 1;

    /**
     * Creates a new user based on the provided login and password.
     * If a user with the same login already exists, returns the existing user.
     * If the login contains '_', creates a new Student instance.
     * If the login contains '.', creates a new Employee instance.
     * Otherwise, creates a default User instance.
     *
     * @param login    The login for the new user.
     * @param password The password for the new user.
     * @return The created user instance.
     */
    public User createUser(String login, String password) {
        Data data = Data.getInstance();

        // Check if a user with the same login already exists
        User existingUser = data.getUserByLogin(login);
        if (existingUser != null) {
            return existingUser;
        }

        User user = new User(login, password);

        // Check login for '_' and '.'
        if (login.contains("_")) {
            User student = new Student(user.getLogin(), user.getPassword());
            student.setUserType(UserType.STUDENT);
            student.setUserId(generateUserId(student));
            data.addUser(student);
            return student;
        } else if (login.contains(".")) {
            User employee = new Employee(user.getLogin(), user.getPassword());
            employee.setUserType(UserType.EMPLOYEE);
            employee.setUserId(generateUserId(employee));
            data.addUser(employee);
            return employee;
        }
        data.addUser(user);

        // If no specific conditions match, return the default user
        return user;
    }

    /**
     * Generates a unique user ID based on the current year and user type (Student or Employee).
     *
     * @param u The user for which to generate the ID.
     * @return The generated user ID.
     */
    private String generateUserId(User u) {
        if (u.getUserType() == UserType.STUDENT) {
            return LocalDateTime.now().getYear() + "S" + studentCount;
        } else if (u.getUserType() == UserType.EMPLOYEE) {
            return LocalDateTime.now().getYear() + "E" + employeeCount;
        }
        return LocalDateTime.now().getYear() + "U" + Data.getInstance().getAllUsers().size();
    }
}
