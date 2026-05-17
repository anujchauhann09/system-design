class ReadOnlyFile implements Downloadable {

    @Override
    public void download() {
        System.out.println("ReadOnlyFile: downloading...");
    }
}
