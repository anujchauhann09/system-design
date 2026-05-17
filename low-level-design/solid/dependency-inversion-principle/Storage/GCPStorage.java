class GCPStorage implements CloudStorage {

    @Override
    public void uploadFile(String fileName) {
        System.out.println("GCP Storage: uploading " + fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        System.out.println("GCP Storage: deleting " + fileName);
    }
}
