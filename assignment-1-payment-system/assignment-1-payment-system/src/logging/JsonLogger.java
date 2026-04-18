package logging;

public class JsonLogger extends AbstractLogger {

    @Override
    public void log(String message) {
        String json = "{ \"log\": \"" + formatMessage(message) + "\" }";
        System.out.println(json);
    }
}
