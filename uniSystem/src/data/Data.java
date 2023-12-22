package data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import course.*;
import researcher.*;
import users.*;

public class Data {
    // Singleton instance
    private static Data instance;

    private Vector<User> userDatabase = new Vector<User>();
    private Vector<Student> studentDatabase = new Vector<Student>();
    private Vector<Teacher> teacherDatabase = new Vector<Teacher>();
    private Vector <Course> courseDatabase = new Vector<Course>();
    private Vector<ResearcherDecorator> researcherDatabase = new Vector<ResearcherDecorator>();
    private Vector<ResearchPaper> researchPapersDatabase = new Vector<ResearchPaper>();
    private Vector<ResearchProject> researchProjectDatabase = new Vector<ResearchProject>();

    
    private Data() {
        userDatabase = new Vector<>();
        studentDatabase = new Vector<>();
        teacherDatabase = new Vector<>();
        
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public Vector<User> getAllUsers() {
        return userDatabase;
    }

    public Vector<Student> getAllStudent() {
        return studentDatabase;
    }
    
    public Vector<Teacher> getAllTeacher() {
        return teacherDatabase;
    }


	public Vector<ResearcherDecorator> getResearcherDatabase() {
		return researcherDatabase;
	}

	public void addResearcherDatabase(ResearcherDecorator researcherDatabase) {
		this.researcherDatabase.add(researcherDatabase);
	}
	
	public Vector<ResearchPaper> getResearchPaper() {
		return researchPapersDatabase;
	}

	public void addResearchPaper(ResearchPaper researchPaper) {
		this.researchPapersDatabase.add(researchPaper);
	}
	
	
	public Vector<ResearchProject> getResearchProject() {
		return researchProjectDatabase;
	}

	public void addResearchProject(ResearchProject researchProject) {
		this.researchProjectDatabase.add(researchProject);
	}
}
