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
//        Data.getInstance().addUser(student);

		// Test case 2: Creating an Employee
//        userFactory.setUserType(UserType.EMPLOYEE);
		User employee = new User("a.akturina.@kbtu.kz", "123456778");
//        Data.getInstance().addUser(employee);
//        System.out.println("User Type: " + employee.getUserType());
//        System.out.println("User Login: " + employee.getLogin());
//        System.out.println("User ID: " + employee.getUserId());
		ResearcherDecorator studentResearcher = new ResearcherDecorator(student);
		Data.getInstance().addResearcherDatabase(studentResearcher);
		ResearcherDecorator employeeResearcher = new ResearcherDecorator(employee);
		Data.getInstance().addResearcherDatabase(employeeResearcher);
		ResearchPaper rp = new ResearchPaper("AI", 10, "Anuar's jounal");
		System.out.println(Data.getInstance().getResearchPaper());
//		ResearchPaper rp1 = new ResearchPaper("A2", 10, "Anuar's jounal");
//		ResearchPaper rp2 = new ResearchPaper("A3", 10, "Anuar's jounal");
//		ResearchPaper rp3 = new ResearchPaper("A4", 10, "Anuar's jounal");
//		ResearchPaper rp4 = new ResearchPaper("A5", 10, "Anuar's jounal");
//		ResearchPaper rp10 = new ResearchPaper("BB", 10, "Anuar's jounal");
//		studentResearcher.newPaper(rp);
//		studentResearcher.newPaper(rp1);
//		studentResearcher.newPaper(rp2);
//		studentResearcher.newPaper(rp3);
//		studentResearcher.newPaper(rp4);
//		rp10.cite(rp);
//		rp10.cite(rp4);
//		rp10.cite(rp3);
//		rp10.cite(rp2);
//		rp10.cite(rp1);
//		System.out.println(studentResearcher.printPapers("by citations"));
//		System.out.println(rp10);
//		System.out.println(rp3);
//		studentResearcher.calculateHIndex();
//		System.out.println(studentResearcher.hindex);
//		employeeResearcher.newPaper("AI", 10, "Anuar's jounal");


	}

}
