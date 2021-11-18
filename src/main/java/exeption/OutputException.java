package exeption;

public class OutputException extends Exception {
    public OutputException(Throwable cause) {
        super(cause);
    }

    public OutputException(String message) {
        super(message);
    }

    public OutputException() {
    }
}
