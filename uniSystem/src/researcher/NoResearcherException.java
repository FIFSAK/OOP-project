package researcher;

public class NoResearcherException extends Exception {
	 public NoResearcherException() {
	        super();
	    }

	    // Конструктор, принимающий сообщение об ошибке
	    public NoResearcherException(String message) {
	        super(message);
	    }

//	    // Конструктор, принимающий сообщение об ошибке и причину (другое исключение)
//	    public CustomException(String message, Throwable cause) {
//	        super(message, cause);
//	    }
//
//	    // Конструктор, принимающий причину (другое исключение)
//	    public CustomException(Throwable cause) {
//	        super(cause);
//	    }
}
