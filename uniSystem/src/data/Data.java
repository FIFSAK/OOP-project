/**
 * The Data class represents a singleton database for storing information about users, students, teachers, courses,
 * researchers, research papers, and research projects. It provides methods to access and manipulate data related to
 * the application.
 * 
 * This class implements the Serializable interface to support object serialization for saving and loading data to and
 * from a file.
 */
package data;

import java.io.*;
import java.util.*;

import additional.*;
import course.*;
import researcher.*;
import users.*;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Data instance;

    private Vector<User> userDatabase;
    private Vector<Student> studentDatabase;
    private Vector<Teacher> teacherDatabase;
    private Vector<Course> courseDatabase;
    private Vector<ResearcherDecorator> researcherDatabase;
    private Vector<ResearchPaper> researchPapersDatabase;
    private Vector<ResearchProject> researchProjectDatabase;
    private Vector<News> newsDatabase; 

    /**
     * Private constructor to initialize empty databases.
     */
    private Data() {
        userDatabase = new Vector<>();
        studentDatabase = new Vector<>();
        teacherDatabase = new Vector<>();
        courseDatabase = new Vector<>();
        researcherDatabase = new Vector<>();
        researchPapersDatabase = new Vector<>();
        researchProjectDatabase = new Vector<>();
        newsDatabase = new Vector<>();
    }

    /**
     * Provides a synchronized instance of the Data class using the Singleton pattern.
     * 
     * @return The singleton instance of the Data class.
     */
    public static synchronized Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    
    /**
     * Retrieves the database of news.
     * 
     * @return Vector containing all news.
     */
    public Vector<News> getAllNews() {
        return newsDatabase;
    }
    
    /**
     * Adds news to the news database.
     * 
     * @param news The News object to be added.
     */
    public void addNews(News news) {
        this.newsDatabase.add(news);
    }

    /**
     * Retrieves all users stored in the database.
     * 
     * @return Vector containing all users.
     */
    public Vector<User> getAllUsers() {
        return userDatabase;
    }
    
    /**
     * Adds a user to the user database.
     * 
     * @param user The User object to be added.
     */
    public void addUser(User user) {
        this.userDatabase.add(user);
    }

    /**
     * Retrieves all students stored in the database.
     * 
     * @return Vector containing all students.
     */
    public Vector<Student> getAllStudent() {
        return studentDatabase;
    }
    
    /**
     * Adds a student to the student database.
     * 
     * @param student The Student object to be added.
     */
    public void addStudent(Student student) {
        this.studentDatabase.add(student);
    }

    /**
     * Retrieves all teachers stored in the database.
     * 
     * @return Vector containing all teachers.
     */
    public Vector<Teacher> getAllTeacher() {
        return teacherDatabase;
    }
    
    /**
     * Adds a teacher to the teacher database.
     * 
     * @param teacher The Teacher object to be added.
     */
    public void addTeacher(Teacher teacher) {
        this.teacherDatabase.add(teacher);
    }

    /**
     * Retrieves the database of researchers.
     * 
     * @return Vector containing all researchers.
     */
    public Vector<ResearcherDecorator> getResearcherDatabase() {
        return researcherDatabase;
    }

    /**
     * Adds a researcher to the database.
     * 
     * @param researcherDatabase The ResearcherDecorator object to be added.
     */
    public void addResearcherDatabase(ResearcherDecorator researcherDatabase) {
        this.researcherDatabase.add(researcherDatabase);
    }

    /**
     * Retrieves the database of research papers.
     * 
     * @return Vector containing all research papers.
     */
    public Vector<ResearchPaper> getResearchPaper() {
        return researchPapersDatabase;
    }

    /**
     * Adds a research paper to the database.
     * 
     * @param researchPaper The ResearchPaper object to be added.
     */
    public void addResearchPaper(ResearchPaper researchPaper) {
        this.researchPapersDatabase.add(researchPaper);
    }

    /**
     * Retrieves the database of research projects.
     * 
     * @return Vector containing all research projects.
     */
    public Vector<ResearchProject> getResearchProject() {
        return researchProjectDatabase;
    }

    /**
     * Adds a research project to the database.
     * 
     * @param researchProject The ResearchProject object to be added.
     */
    public void addResearchProject(ResearchProject researchProject) {
        this.researchProjectDatabase.add(researchProject);
    }
    
    public User getUserByLogin(String login) {
        for (User user : userDatabase) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null; // User not found
    }

    /**
     * Saves the current instance of Data to a file using object serialization.
     * 
     * @param filePath The path of the file to save the data.
     */
    public void saveToFile(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a Data instance from a file using object deserialization.
     * 
     * @param filePath The path of the file to load the data from.
     * @return The loaded instance of Data, or null if an error occurs.
     */
    public static Data loadFromFile(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            instance = (Data) in.readObject();
            return instance;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
