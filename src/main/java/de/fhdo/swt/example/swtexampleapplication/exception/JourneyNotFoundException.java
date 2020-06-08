package de.fhdo.swt.example.swtexampleapplication.exception;

public class JourneyNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7765290896601941101L;

    public JourneyNotFoundException() {
        super();
    }

    public JourneyNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public JourneyNotFoundException(final String message) {
        super(message);
    }

    public JourneyNotFoundException(final Throwable cause) {
        super(cause);
    }
}
