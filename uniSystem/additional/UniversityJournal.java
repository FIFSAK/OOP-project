package additional;

public class UniversityJournal implements Observable {
    
    /**
    * @generated
    */
    private List<Observer> observers;
    
    /**
    * @generated
    */
    private String latestPaper;
    
    
    

    /**
    * @generated
    */
    private List<Observer> getObservers() {
        return this.observers;
    }
    
    /**
    * @generated
    */
    private List<Observer> setObservers(List<Observer> observers) {
        this.observers = observers;
    }
    
    
    /**
    * @generated
    */
    private String getLatestPaper() {
        return this.latestPaper;
    }
    
    /**
    * @generated
    */
    private String setLatestPaper(String latestPaper) {
        this.latestPaper = latestPaper;
    }
    
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void publishNewPaper() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void addObserver() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void removeObserver() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void notifyObservers() {
        //TODO
        return null;
    }
    
    
}

