package additional;

import java.util.ArrayList;
import users.*;
import java.util.List;

public class UniversityJournal {
    private List<Observer> observers;
    private String latestPaper;

    public UniversityJournal() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestPaper);
        }
    }

    public void publishNewPaper(String paper) {
        this.latestPaper = paper;
        notifyObservers();
    }
}
