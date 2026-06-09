// one Logger instance is shared across the whole application
public class Logger {

    private Logger() {
    }

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    // global access point — triggers Holder loading on first call
    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    // synchronized so concurrent threads don't interleave their output
    public synchronized void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
