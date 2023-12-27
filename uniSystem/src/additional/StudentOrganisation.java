package additional;

import java.io.Serializable;
import java.util.Vector;

import users.Student;

public class StudentOrganisation implements Serializable{
    
    /**
    * @generated
    */
    private Student head;
    
    /**
    * @generated
    */
    private Vector<Student> members;
    
    
    /**
    * @generated
    */
    private Student student;
    
    

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
    public Vector<Student> getMembers() {
        return this.members;
    }
    
    /**
    * @generated
    */
    public void setMembers(Vector<Student> members) {
        this.members = members;
    }
    
    
    
    /**
    * @generated
    */
    public Student getStudent() {
        return this.student;
    }
    
    /**
    * @generated
    */
    public void setStudent(Student student) {
        this.student = student;
    }

	public void addMember(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void removeMember(Student student2) {
		// TODO Auto-generated method stub
		
	}

	
    
    
    

    //                          Operations                                  
    
    
}

