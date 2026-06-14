public class GcpQueue
        implements Queue {

    @Override
    public void enqueue(String message) {
        System.out.println("Pub/Sub enqueued: " + message);
    }
}
