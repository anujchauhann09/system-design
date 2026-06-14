public class AwsFactory
        implements CloudFactory {

    @Override
    public Storage createStorage() {
        return new AwsStorage();
    }

    @Override
    public Queue createQueue() {
        return new AwsQueue();
    }

    @Override
    public Notification createNotification() {
        return new AwsNotification();
    }
}
