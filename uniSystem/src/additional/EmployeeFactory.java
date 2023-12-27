package additional;
import users.*;
/**
 * The EmployeeFactory class is responsible for creating specialized instances
 * of the Employee class based on the work department. It helps to encapsulate
 * the creation logic and provide a consistent way to obtain specialized
 * instances of Employee subclasses.
 */

public class EmployeeFactory {
    
    /**
     * Returns a specialized instance of the Employee based on the work department.
     * If the work department is "teacher," it returns a Teacher instance. If the
     * work department is "dean," it returns a Dean instance. If the work department
     * is "manager," it returns a Manager instance. Otherwise, it returns the
     * original Employee instance.
     *
     * @param emp The original Employee instance.
     * @return Specialized instance of Employee based on work department.
     */
    public Employee getEmployee(Employee emp) {
        // Convert the work department to lowercase for case-insensitive comparison
        String workDepartment = emp.getWorkDepartment().toLowerCase();

        // Check the work department and return the corresponding specialized instance
        if (workDepartment.equals("teacher")) {
            return (Teacher) emp;
        } else if (workDepartment.equals("dean")) {
            return (Dean) emp;
        } else if (workDepartment.equals("manager")) {
            return (Manager) emp;
        }

        // Return the original Employee instance if the work department is not recognized
        return emp;
    }
}