class MriProcessor extends DicomProcessor {

    protected void validateDicom() {
        System.out.println("Validating MRI DICOM tags (modality = MR)...");
    }

    protected void extractMetadata() {
        System.out.println("Extracting MRI metadata (echo time, repetition time)...");
    }
}
