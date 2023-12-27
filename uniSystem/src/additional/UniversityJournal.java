package additional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import users.*;
import java.util.List;

import data.Data;
import researcher.ResearchPaper;

public class UniversityJournal implements Serializable{
    Data data = Data.getInstance();
    private List<User> observers;
    private List<ResearchPaper> researchPapers ;

    public UniversityJournal() {
        this.observers = data.getAllUsers();
        this.researchPapers = data.getResearchPaper();
    }

    public void addObserver(Observer observer) {
        observers.add((User) observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void publishNewPaper(ResearchPaper paper) {
        this.researchPapers.add(0, paper); // Add the new paper to the beginning of the list
        notifyObservers();
    }

    public List<ResearchPaper> getResearchPapers() {
        return Collections.unmodifiableList(researchPapers);
    }
}