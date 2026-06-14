class S3Storage implements CloudStorage {
    public void upload(String file)   { System.out.println("Uploading " + file + " to AWS S3"); }
    public void download(String file) { System.out.println("Downloading " + file + " from AWS S3"); }
}
