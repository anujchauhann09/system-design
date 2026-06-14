public class Application {

    private Storage storage;
    private Queue queue;
    private Notification notification;

    public Application(CloudFactory factory) {

        this.storage =
                factory.createStorage();

        this.queue =
                factory.createQueue();

        this.notification =
                factory.createNotification();
    }

    public void run() {
        storage.store("user-avatar.png");
        queue.enqueue("process-image-job");
        notification.notify("upload complete");
    }

    public static void main(String[] args) {

        // pick a cloud provider once. Swap this single line to switch
        // the entire SDK family (Storage + Queue + Notification) — no other
        // code changes. Never mix S3 storage with Azure queues
        CloudFactory factory =
                new AwsFactory();

        Application app =
                new Application(factory);

        app.run();
    }
}
