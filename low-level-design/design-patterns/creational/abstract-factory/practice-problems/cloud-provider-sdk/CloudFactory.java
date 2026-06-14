public interface CloudFactory {

    Storage createStorage();

    Queue createQueue();

    Notification createNotification();
}
