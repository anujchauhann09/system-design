class AzureBlobStorage implements CloudStorage {
    public void upload(String file)   { System.out.println("Uploading " + file + " to Azure Blob Storage"); }
    public void download(String file) { System.out.println("Downloading " + file + " from Azure Blob Storage"); }
}
