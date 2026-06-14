public class GcpStorage
        implements Storage {

    @Override
    public void store(String object) {
        System.out.println("GCS stored: " + object);
    }
}
