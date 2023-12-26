package additional;

import users.User;

import enums.UserType;
import users.Employee;
import users.Student;
import users.User;

import java.time.LocalDateTime;
import java.util.*;

import data.Data;

public class UserFactory {
    private static int studentCount = 1;
    private static int employeeCount = 1;

    public User createUser(String login, String password) {
        Data data = Data.getInstance();

        // Check if a user with the same login already exists
        User existingUser = data.getUserByLogin(login);
        if (existingUser != null) {
            return existingUser;
        }

        User user = new User(login, password);

        // Check login for _ and .
        if (login.contains("_")) {
            User student = new Student(user.getLogin(), user.getPassword());
            student.setUserType(UserType.STUDENT);
            student.setUserId(generateUserId(student));
            data.addUser(student);
            return student;
        } else if (login.contains(".")){
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

    private String generateUserId(User u) {
        if (u.getUserType() == UserType.STUDENT) {
            return LocalDateTime.now().getYear() + "S" + studentCount;
        } else if (u.getUserType() == UserType.EMPLOYEE) {
            return LocalDateTime.now().getYear() + "E" + employeeCount;
        }
        return LocalDateTime.now().getYear() + "U" + Data.getInstance().getAllUsers().size();
    }
}