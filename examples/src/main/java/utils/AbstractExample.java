package utils;

import org.junit.runner.RunWith;

@RunWith(ExampleRunner.class)
public abstract class AbstractExample {
    public boolean printToConsole = true;

    public AbstractExample() {
        // Nothing to do.
    }

    public void log(String message, Object object) {
        String objectStr = (object == null) ? "Null Object" : object.toString();
        if (printToConsole) {
            System.out.println(((message == null) ? "" : message + ": ") + objectStr);
        }
    }

    public void logError(String message, Object object) {
        String objectStr = (object == null) ? "Null Object" : object.toString();
        if (printToConsole) {
            System.err.println(("[ERROR] " + ((message == null) ? "" : message + ": ")) + objectStr);
        }
    }

}
