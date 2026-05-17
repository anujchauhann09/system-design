class CloudFile implements Uploadable, Downloadable, Sharable {

    @Override
    public void upload() {
        System.out.println("CloudFile: uploading...");
    }

    @Override
    public void download() {
        System.out.println("CloudFile: downloading...");
    }

    @Override
    public void share() {
        System.out.println("CloudFile: sharing...");
    }
}
