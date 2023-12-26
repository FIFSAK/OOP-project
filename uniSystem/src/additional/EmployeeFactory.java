package additional;
import users.*;

public class EmployeeFactory {
	
	public Employee getEmployee(Employee emp) {
		if(emp.getWorkDepartment().toLowerCase().equals("teacher")) {
			return (Teacher) emp;
		}
		else if(emp.getWorkDepartment().toLowerCase().equals("dean")) {
			return (Dean) emp;
		}
		else if(emp.getWorkDepartment().toLowerCase().equals("manager")) {
			return (Manager) emp;
		}
		return emp;
	}
}
