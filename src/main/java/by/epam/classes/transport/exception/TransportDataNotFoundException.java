package by.epam.classes.transport.exception;

public class TransportDataNotFoundException extends TransportDataException {




    public TransportDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportDataNotFoundException(String message) {
        super(message);
    }

    public TransportDataNotFoundException(Throwable cause) {
        super(cause);
    }

    public TransportDataNotFoundException() {
        super();
    }
}
