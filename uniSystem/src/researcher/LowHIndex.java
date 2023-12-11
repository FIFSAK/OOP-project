package researcher;

public class LowHIndex extends Exception {
	 public LowHIndex() {
	        super();
	    }

	    // Конструктор, принимающий сообщение об ошибке
	    public LowHIndex(String message) {
	        super(message);
	    }
}
