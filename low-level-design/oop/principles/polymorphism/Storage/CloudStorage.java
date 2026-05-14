class CloudStorage implements StorageService {
    @Override
    public void saveFile(String fileName, String content) {
        System.out.println("Saving to cloud storage: " + fileName);
    }

    @Override
    public String readFile(String fileName) {
        System.out.println("Reading from cloud storage: " + fileName);
        return null;
    }
}
