public class AwsStorage
        implements Storage {

    @Override
    public void store(String object) {
        System.out.println("S3 stored: " + object);
    }
}
