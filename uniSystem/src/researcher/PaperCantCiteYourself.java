package researcher;

/**
 * Exception thrown when a research paper attempts to cite itself.
 * This exception is used to enforce the rule that a paper cannot be a citation in its own reference list,
 * ensuring academic integrity and proper citation practices.
 */
public class PaperCantCiteYourself extends Exception {

    /**
     * Constructs a PaperCantCiteYourself exception with no detail message.
     * This constructor is used when the simple act of a paper attempting to cite itself is self-explanatory
     * and no additional information is needed.
     */
    public PaperCantCiteYourself() {
        super();
    }

    /**
     * Constructs a PaperCantCiteYourself exception with the specified detail message.
     * 
     * @param message The detail message which provides more information on why the exception was thrown.
     *                The detail message is saved for later retrieval by the Throwable.getMessage() method.
     */
    public PaperCantCiteYourself(String message) {
        super(message);
    }
}
