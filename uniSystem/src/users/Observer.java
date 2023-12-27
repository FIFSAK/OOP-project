package users;

/**
 * The Observer interface defines the contract for objects that should be notified
 * when there are changes in the subject they are observing.
 */
public interface Observer {

    /**
     * This method is called by the subject to notify the observer about a change.
     */
    void update();
}