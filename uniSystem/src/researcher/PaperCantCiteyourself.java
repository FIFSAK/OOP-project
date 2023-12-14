package researcher;

public class PaperCantCiteyourself extends Exception {
	public PaperCantCiteyourself() {
        super();
    }

    // Конструктор, принимающий сообщение об ошибке
    public PaperCantCiteyourself(String message) {
        super(message);
    }
}
