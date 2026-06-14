public class AzureStorage
        implements Storage {

    @Override
    public void store(String object) {
        System.out.println("Azure Blob stored: " + object);
    }
}
