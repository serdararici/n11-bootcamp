package logging;

public class ConsoleLogger extends AbstractLogger {

    @Override
    public void log(String message) {
        System.out.println(formatMessage(message));
    }
}