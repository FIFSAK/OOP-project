package additional;

import java.io.Serializable;

public class Request implements Serializable {
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
