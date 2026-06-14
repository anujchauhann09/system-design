import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

class CloudStorageFactory {
    // name -> "how to build one". registry instead of a switch statement
    private final Map<String, Supplier<CloudStorage>> registry = new HashMap<>();

    // adding a provider = one register() call. Factory code itself never changes
    public void register(String type, Supplier<CloudStorage> creator) {
        registry.put(type.toLowerCase(), creator);
    }

    public CloudStorage create(String type) {
        Supplier<CloudStorage> creator = registry.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown storage provider: " + type);
        }
        
        return creator.get();
    }
}
