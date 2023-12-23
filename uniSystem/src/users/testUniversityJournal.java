package users;

import additional.*;
import users.*;

public class testUniversityJournal{
	UserFactory userFactory = new UserFactory();
    UniversityJournal universityJournal = new UniversityJournal();

    User studentUser = userFactory.createUser("a_akturina.@kbtu.kz", "123456778");
    User employeeUser = userFactory.createUser("a.akturina.@kbtu.kz", "123456778");

    universityJournal.addObserver((Observer)studentUser);
    universityJournal.addObserver(employeeUser);

    // Publish a new paper in the UniversityJournal
    universityJournal.publishNewPaper("New Research Paper on Observer Pattern");

    // Print the details of the users after the update
    System.out.println("Student User Details: " + studentUser);
    System.out.println("Employee User Details: " + employeeUser);

}
