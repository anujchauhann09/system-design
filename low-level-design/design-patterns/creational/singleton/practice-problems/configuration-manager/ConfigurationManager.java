import java.util.HashMap;
import java.util.Map;

// holds application configuration in one shared place
public class ConfigurationManager {

    private final Map<String, String> settings = new HashMap<>();

    // private constructor — load defaults once
    private ConfigurationManager() {
        settings.put("app.name", "MyApp");
        settings.put("app.env", "dev");
        settings.put("db.url", "localhost:5432");
    }

    // holder is loaded only when getInstance() is first called (lazy)
    private static class Holder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    // global access point — triggers Holder loading on first call
    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized String get(String key) {
        return settings.get(key);
    }

    public synchronized void set(String key, String value) {
        settings.put(key, value);
    }
}
