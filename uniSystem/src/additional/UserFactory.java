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
        User user = new User(login, password);

        // Check login for _ and .
        if (login.contains("_")) {
            User student = new Student(user.getLogin(), user.getPassword());
            student.setUserType(UserType.STUDENT);
            student.setUserId(generateUserId(student));
            return student;
        } else if (login.contains(".")){
            User employee = new Employee(user.getLogin(), user.getPassword());
            employee.setUserType(UserType.EMPLOYEE);
            employee.setUserId(generateUserId(employee));
            return employee;
        }
		return user;
    }

    private String generateUserId(User u) {
        if(u.getUserType() == UserType.STUDENT) {
        	Student u1 = (Student)u;
        	return u1.getYearOfReceipt()+"S"+studentCount; // TODO STUDENT METHOD AYAZHAN
        }
        else if(u.getUserType() == UserType.EMPLOYEE) {
        	Employee u1 = (Employee)u;
        	return u1.getDateOfEmployment()+"E"+employeeCount; // TODO EMPLOYEE METHOD AZIZA
        }
        return LocalDateTime.now().getYear() + "U" + Data.getInstance().getAllUsers().size();
    }
}
