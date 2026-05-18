class FileCompressorService {

    FileCompressorStrategy fileCompressorStrategy;

    FileCompressorService(FileCompressorStrategy fileCompressorStrategy) {
        this.fileCompressorStrategy = fileCompressorStrategy;
    }

    public void processCompression(String data) {
        fileCompressorStrategy.compress(data);
    }
}