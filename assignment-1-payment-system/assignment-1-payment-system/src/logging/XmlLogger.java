package logging;

public class XmlLogger extends AbstractLogger {

    @Override
    public void log(String message) {
        String xml = "<log>" + formatMessage(message) + "</log>";
        System.out.println(xml);
    }
}