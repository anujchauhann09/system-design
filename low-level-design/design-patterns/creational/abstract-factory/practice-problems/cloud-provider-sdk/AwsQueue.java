public class AwsQueue
        implements Queue {

    @Override
    public void enqueue(String message) {
        System.out.println("SQS enqueued: " + message);
    }
}
