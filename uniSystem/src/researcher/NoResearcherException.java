package researcher;

/**
 * Exception thrown when an expected researcher entity is not found in a specific context.
 * This exception is typically used in scenarios where operations require a valid researcher,
 * but none is present or the specified researcher does not exist.
 */
public class NoResearcherException extends Exception {

    /**
     * Constructs a NoResearcherException with no detail message.
     * This default constructor is useful when the absence of a researcher is a sufficient
     * explanation and no additional detail is needed.
     */
    public NoResearcherException() {
        super();
    }

    /**
     * Constructs a NoResearcherException with the specified detail message.
     * 
     * @param message The detail message which provides more information on the specific situation
     *                where no researcher was found. The detail message is saved for later retrieval
     *                by the Throwable.getMessage() method.
     */
    public NoResearcherException(String message) {
        super(message);
    }
}
