import java.util.HashMap;
import java.util.Map;

class RateLimitingHandler extends Handler {

    private static final int MAX_REQUESTS = 2;   // per client, per window

    // stateful: how many requests each client has made in this window
    private final Map<String, Integer> counts = new HashMap<>();

    @Override
    public void handle(Request request) {
        String client = request.getClientId();
        int used = counts.getOrDefault(client, 0) + 1;
        counts.put(client, used);

        if (used > MAX_REQUESTS) {
            System.out.println("[429] " + client + " - rate limit exceeded (" + MAX_REQUESTS + "/window)");
            return;   // short-circuit the chain
        }
        System.out.println("[RateLimit] " + client + " " + used + "/" + MAX_REQUESTS);
        forward(request);
    }
}
