package test;

import additional.UserFactory;
import enums.*;
import users.*;

public class Main {
	public static void main(String[] args) {
        // Create a UserFactory
        UserFactory userFactory = new UserFactory();

        // Test case 1: Creating a Student
        User student = new User("a_akturina.@kbtu.kz", "123456778");
        System.out.println("User Type: " + student.getUserType());
        System.out.println("User Login: " + student.getLogin());
        System.out.println("User ID: " + student.getUserId());

        // Test case 2: Creating an Employee
//        userFactory.setUserType(UserType.EMPLOYEE);
        User employee = new User("a.akturina.@kbtu.kz", "123456778");
        System.out.println("User Type: " + employee.getUserType());
        System.out.println("User Login: " + employee.getLogin());
        System.out.println("User ID: " + employee.getUserId());
    }

}
