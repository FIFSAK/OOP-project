package additional;

import users.User;

import enums.UserType;
import users.Employee;
import users.Student;
import users.User;
import java.util.*;

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
        	u = (Student)u;
        	return u.getYearOfReceipt()+"S"+studentCount; // TODO STUDENT METHOD AYAZHAN
        }
        else if(u.getUserType() == UserType.EMPLOYEE) {
        	u = (Employee)u;
        	return u.getDateOfEmployement()+"E"+employeeCount; // TODO EMPLOYEE METHOD AZIZA
        }
    }
}
