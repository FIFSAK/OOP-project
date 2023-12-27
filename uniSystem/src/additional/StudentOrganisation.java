package additional;

import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;

import data.Data;
import users.Student;

public class StudentOrganisation implements Serializable{
    
    /**
    * @generated
    */
    private Student head;
    public String name;
    public static Vector<Student> getMembersOfOrganizationByName(StudentOrganisation std) {
        return Data.getInstance().getAllStudent().stream()
            .filter(s -> s.getStudentOrganization().contains(std))
            .collect(Collectors.toCollection(Vector::new));
    }
    
        
    
    public StudentOrganisation(String name) {
		super();
		this.name = name;
	}
    
    public String toString() {
    	return "NAME" + name;
    }
	/**
    * @generated
    */
    
    

    /**
    * @generated
    */
    public Student getHead() {
        return this.head;
    }
    
    /**
    * @generated
    */
    public void setHead(Student head) {
        this.head = head;
    }
    
    
    /**
    * @generated
    */
    
    
    /**
    * @generated
    */
   
    
    /**
    * @generated
    */
    

	
}

