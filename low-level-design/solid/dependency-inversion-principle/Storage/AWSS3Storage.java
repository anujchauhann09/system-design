class AWSS3Storage implements CloudStorage {

    @Override
    public void uploadFile(String fileName) {
        System.out.println("AWS S3: uploading " + fileName);
    }

    @Override
    public void deleteFile(String fileName) {
        System.out.println("AWS S3: deleting " + fileName);
    }
}
