package logging;

// Base class for all logging strategies
public abstract class AbstractLogger {

    public abstract void log(String message);

    // Common helper method for formatting timestamp
    protected String formatMessage(String message) {
        return "[LOG] " + message;
    }
}