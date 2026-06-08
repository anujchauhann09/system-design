class UltrasoundProcessor extends DicomProcessor {

    protected void validateDicom() {
        System.out.println("Validating Ultrasound DICOM tags (modality = US)...");
    }

    protected void extractMetadata() {
        System.out.println("Extracting Ultrasound metadata (transducer frequency, frame rate)...");
    }
}
