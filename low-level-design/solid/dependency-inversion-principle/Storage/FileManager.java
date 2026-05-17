class FileManager {
    CloudStorage storage;

    FileManager(CloudStorage storage) {
        this.storage = storage;
    }

    void upload(String fileName) {
        storage.uploadFile(fileName);
    }

    void delete(String fileName) {
        storage.deleteFile(fileName);
    }
}
