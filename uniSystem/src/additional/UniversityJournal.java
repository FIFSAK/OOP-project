package additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class UniversityJournal implements Observer {

    private List<Observer> observers;
    private String latestPaper;

    public UniversityJournal() {
        this.observers = new ArrayList<>();
        // Subscribe all users by default
        // Add your logic to get all users and subscribe them
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getLatestPaper() {
        return latestPaper;
    }

    public void setLatestPaper(String latestPaper) {
        this.latestPaper = latestPaper;
    }

    // Operations

    public void publishNewPaper(String paper) {
        this.latestPaper = paper;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, latestPaper);
        }
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
