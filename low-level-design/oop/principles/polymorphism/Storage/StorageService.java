interface StorageService {
    void saveFile(String fileName, String content);
    String readFile(String fileName);
}
