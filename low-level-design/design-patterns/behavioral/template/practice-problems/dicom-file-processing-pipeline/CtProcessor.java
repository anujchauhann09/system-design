class CtProcessor extends DicomProcessor {

    protected void validateDicom() {
        System.out.println("Validating CT DICOM tags (modality = CT)...");
    }

    protected void extractMetadata() {
        System.out.println("Extracting CT metadata (slice thickness, kVp)...");
    }
}
