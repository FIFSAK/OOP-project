package users;

public class Employee extends UserUser {
    
    private String workDepartment;
    private int salary;
    private Data data;
    private EmployeeFactory employeeFactory;
    
    private String getWorkDepartment() {
        return this.workDepartment;
    }
  
    private String setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    private  getSalary() {
        return this.salary;
    }

    private int  setSalary(int salary) {
        this.salary = salary;
    }
 
    public Data getData() {
        return this.data;
    }

    public Data setData(Data data) {
        this.data = data;
    }

    public EmployeeFactory getEmployeeFactory() {
        return this.employeeFactory;
    }

    public EmployeeFactory setEmployeeFactory(EmployeeFactory employeeFactory) {
        this.employeeFactory = employeeFactory;
    }
    
    
    
}