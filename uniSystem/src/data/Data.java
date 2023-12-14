package data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import course.*;
import researcher.ResearcherDecorator;
import users.*;

public class Data {
    // Singleton instance
    private static Data instance;

    // Database storage
    private Map<String, User> userDatabase;
    private Map<String, Course> courseDatabase;
    private Vector<ResearcherDecorator> researcherDatabase = new Vector<ResearcherDecorator>();
    // Private constructor to prevent instantiation
    private Data() {
        userDatabase = new HashMap<>();
        courseDatabase = new HashMap<>();
    }

    // Public method to get the singleton instance
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    // Public method to get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }

    // Public method to get all courses
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseDatabase.values());
    }

    // Public method to get user by ID
    public User getUserById(String userId) {
        return userDatabase.get(userId);
    }

    // Public method to get course by ID
    public Course getCourseById(String courseId) {
        return courseDatabase.get(courseId);
    }

    // Public method to add user to the database
    public void addUser(User user) {
        userDatabase.put(user.getUserId(), user);
    }

	public Vector<ResearcherDecorator> getResearcherDatabase() {
		return researcherDatabase;
	}

	public void addResearcherDatabase(ResearcherDecorator researcherDatabase) {
		this.researcherDatabase.add(researcherDatabase);
	}}

    // Public method to add course to the database
//    public void addCourse(Course course) {
//        courseDatabase.put(course.getCourseId(), course);
//    }