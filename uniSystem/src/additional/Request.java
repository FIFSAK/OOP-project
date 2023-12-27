package additional;

import java.io.Serializable;

/**
 * The Request class represents a generic request with a unique identifier and a signed status.
 */
public class Request implements Serializable {
	 /** The unique identifier for the request. */
	private String requestId;


   


    /** A flag indicating whether the request has been signed or not. */
    private boolean signed;

    /**
     * Constructs a Request object with the specified unique identifier.
     *
     * @param requestId The unique identifier for the request.
     */
    public Request(String requestId) {
        this.requestId = requestId;
        this.signed = false; // Initialize to false by default
    }

    /**
     * Gets the unique identifier for the request.
     *
     * @return The unique identifier for the request.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Checks if the request has been signed.
     *
     * @return True if the request has been signed; otherwise, false.
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Sets the signed status of the request.
     *
     * @param signed True to indicate that the request has been signed; false otherwise.
     */
    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}
