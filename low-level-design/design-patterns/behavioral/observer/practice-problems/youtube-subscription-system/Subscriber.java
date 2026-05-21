class Subscriber implements Observer {

    private String subscriberName;

    Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println(subscriberName + " notified: " + channelName + " — " + videoTitle);
    }
}
