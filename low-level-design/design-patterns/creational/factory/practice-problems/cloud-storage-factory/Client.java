class Client {
    public static void main(String[] args) {
        CloudStorageFactory factory = new CloudStorageFactory();

        // register providers once (e.g. at startup / wiring time)
        factory.register("s3",    S3Storage::new);
        factory.register("gcs",   GcsStorage::new);
        factory.register("azure", AzureBlobStorage::new);

        CloudStorage storage = factory.create("s3");
        storage.upload("photo.png");      // uploading photo.png to AWS S3
        storage.download("photo.png");    // downloading photo.png from AWS S3

        factory.create("gcs").upload("report.pdf");     // ... to Google Cloud Storage
        factory.create("azure").upload("backup.zip");   // ... to Azure Blob Storage

        // adding a 4th provider (e.g. DropboxStorage) needs only ONE new line here
        // plus the new class — CloudStorageFactory is never edited
    }
}
