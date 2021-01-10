package Teachers;

public class NotFoundException extends Exception {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
