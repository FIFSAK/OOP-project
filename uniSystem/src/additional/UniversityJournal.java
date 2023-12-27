package additional;

import java.util.ArrayList;
import java.util.Collections;

import users.*;
import java.util.List;

import data.Data;
import researcher.ResearchPaper;

/**
 * The UniversityJournal class represents a journal that publishes research papers
 * within a university. It allows users to subscribe as observers to receive updates
 * when new research papers are published.
 */
public class UniversityJournal {
    
    // Singleton instance of the Data class to access user and research paper data
    private Data data = Data.getInstance();
    
    // List of observers (subscribed users) who will be notified of new research papers
    private List<User> observers;
    
    // List of research papers published in the university journal
    private List<ResearchPaper> researchPapers;

    /**
     * Constructs a UniversityJournal object with initial data from the Data instance.
     */
    public UniversityJournal() {
        this.observers = data.getAllUsers();
        this.researchPapers = data.getResearchPaper();
    }

    /**
     * Adds a new observer (user) to the list of subscribers.
     * 
     * @param observer The observer to be added.
     */
    public void addObserver(Observer observer) {
        observers.add((User) observer);
    }

    /**
     * Removes an observer (user) from the list of subscribers.
     * 
     * @param observer The observer to be removed.
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all subscribed observers when a new research paper is published.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Publishes a new research paper in the university journal.
     * 
     * @param paper The ResearchPaper object representing the new paper.
     */
    public void publishNewPaper(ResearchPaper paper) {
        this.researchPapers.add(0, paper); // Add the new paper to the beginning of the list
        notifyObservers();
    }

    /**
     * Retrieves an unmodifiable list of all research papers published in the university journal.
     * 
     * @return Unmodifiable list of ResearchPaper objects.
     */
    public List<ResearchPaper> getResearchPapers() {
        return Collections.unmodifiableList(researchPapers);
    }
}
