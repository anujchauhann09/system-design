public class AzureQueue
        implements Queue {

    @Override
    public void enqueue(String message) {
        System.out.println("Azure Queue enqueued: " + message);
    }
}
