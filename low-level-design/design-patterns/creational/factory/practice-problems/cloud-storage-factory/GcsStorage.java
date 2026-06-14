class GcsStorage implements CloudStorage {
    public void upload(String file)   { System.out.println("Uploading " + file + " to Google Cloud Storage"); }
    public void download(String file) { System.out.println("Downloading " + file + " from Google Cloud Storage"); }
}
