package researcher;

import java.util.Vector;

import additional.UserFactory;
import data.Data;
import users.User;

public class test {

	public static void main(String[] args) throws Exception {
		 // Create a UserFactory
        UserFactory userFactory = new UserFactory();

        // Test case 1: Creating a Student
        User student = new User("a_akturina.@kbtu.kz", "123456778");
//        System.out.println("User Type: " + student.getUserType());
//        System.out.println("User Login: " + student.getLogin());
//        System.out.println("User ID: " + student.getUserId());
        Data.getInstance().addUser(student);

        // Test case 2: Creating an Employee
//        userFactory.setUserType(UserType.EMPLOYEE);
        User employee = new User("a.akturina.@kbtu.kz", "123456778");
        Data.getInstance().addUser(employee);
//        System.out.println("User Type: " + employee.getUserType());
//        System.out.println("User Login: " + employee.getLogin());
//        System.out.println("User ID: " + employee.getUserId());
        ResearcherDecorator studentResearcher = new ResearcherDecorator(student);
        Data.getInstance().addResearcherDatabase(studentResearcher);
        ResearcherDecorator employeeResearcher = new ResearcherDecorator(employee);
        Data.getInstance().addResearcherDatabase(employeeResearcher);
        Vector<ResearchPaper> v = new Vector<ResearchPaper>();
        ResearchPaper rp = new ResearchPaper("AI", v, 10, "Anuar's jounal");
        studentResearcher.newPaper("AI", v, 10, "Anuar's jounal");
        employeeResearcher.newPaper("AI", v, 10, "Anuar's jounal");
        System.out.println(rp);
        rp.cite(rp);
        System.out.println(rp.getAuthorsOfPaper(rp));

	}

}
