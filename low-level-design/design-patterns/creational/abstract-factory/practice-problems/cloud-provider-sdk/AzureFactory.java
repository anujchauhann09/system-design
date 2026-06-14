public class AzureFactory
        implements CloudFactory {

    @Override
    public Storage createStorage() {
        return new AzureStorage();
    }

    @Override
    public Queue createQueue() {
        return new AzureQueue();
    }

    @Override
    public Notification createNotification() {
        return new AzureNotification();
    }
}
