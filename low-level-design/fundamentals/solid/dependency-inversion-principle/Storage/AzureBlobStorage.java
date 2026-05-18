class AzureBlobStorage implements CloudStorage {

    @Override
    public void uploadFile(String fileName) {
        System.out.println("Azure Blob: uploading " + fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        System.out.println("Azure Blob: deleting " + fileName);
    }
}
