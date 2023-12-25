package users;

import additional.*;
import enums.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testUserFactory {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();

        User studentUser = userFactory.createUser("a_akturina.@kbtu.kz", "123456778");
        System.out.println("Created user: " + studentUser);

        User employeeUser = userFactory.createUser("a.akturina.@kbtu.kz", "123456778");
        System.out.println("Created user: " + employeeUser);
        
        System.out.println(studentUser);
        System.out.println(employeeUser);
    }}

