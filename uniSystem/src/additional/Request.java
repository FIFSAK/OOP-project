package additional;

public class Request {
	private String requestId;
    private boolean signed;

    public Request(String requestId) {
        this.requestId = requestId;
        this.signed = false; // Initialize to false by default
    }

    public String getRequestId() {
        return requestId;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}
