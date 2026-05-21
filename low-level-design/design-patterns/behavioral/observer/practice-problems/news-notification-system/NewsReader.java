class NewsReader implements Observer {

    private String readerName;

    NewsReader(String readerName) {
        this.readerName = readerName;
    }

    @Override
    public void update(String category, String headline) {
        System.out.println(readerName + " received [" + category + "]: " + headline);
    }
}
