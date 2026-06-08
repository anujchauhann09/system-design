abstract class DicomProcessor {

    public final void process() {

        receiveFile();

        validateDicom();

        extractMetadata();

        storeStudy();

        sendNotification();
    }

    protected abstract void validateDicom();

    protected abstract void extractMetadata();

    private void receiveFile() {
        System.out.println("Receiving DICOM file...");
    }

    private void storeStudy() {
        System.out.println("Storing study in PACS...");
    }

    private void sendNotification() {
        System.out.println("Sending notification to radiologist...");
    }
}
