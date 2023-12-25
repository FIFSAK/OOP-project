package researcher;

/**
 * Exception thrown when the H-Index calculated for a researcher is below a predefined acceptable threshold.
 * This exception is used to indicate situations where a researcher's academic impact, as measured by the H-Index, 
 * is not meeting certain standards.
 */
public class LowHIndex extends Exception {

    /**
     * Constructs a LowHIndex exception with no detail message.
     * This constructor creates a LowHIndex exception without specifying the reason for the low H-Index.
     */
    public LowHIndex() {
        super();
    }

    /**
     * Constructs a LowHIndex exception with the specified detail message.
     * 
     * @param message The detail message which provides more information on why the exception was thrown.
     *                The detail message is saved for later retrieval by the Throwable.getMessage() method.
     */
    public LowHIndex(String message) {
        super(message);
    }
}
