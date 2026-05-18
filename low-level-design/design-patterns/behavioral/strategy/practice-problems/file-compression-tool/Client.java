class Client {

    public static void main(String args[]) {

        FileCompressorService zip = new FileCompressorService(new ZipCompressorStrategy());
        FileCompressorService huffman = new FileCompressorService(new HuffmanCompressorStrategy());

        zip.processCompression("Hello world!");
        huffman.processCompression("Hello world!");
    }
}