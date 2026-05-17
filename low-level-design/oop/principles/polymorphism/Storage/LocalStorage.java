class LocalStorage implements StorageService {
    @Override
    public void saveFile(String fileName, String content) {
        System.out.println("Saving to local storage: " + fileName);
    }

    @Override
    public String readFile(String fileName) {
        System.out.println("Reading from local storage: " + fileName);
        return null;
    }
}
