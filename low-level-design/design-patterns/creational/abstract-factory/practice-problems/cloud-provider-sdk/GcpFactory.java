public class GcpFactory
        implements CloudFactory {

    @Override
    public Storage createStorage() {
        return new GcpStorage();
    }

    @Override
    public Queue createQueue() {
        return new GcpQueue();
    }

    @Override
    public Notification createNotification() {
        return new GcpNotification();
    }
}
