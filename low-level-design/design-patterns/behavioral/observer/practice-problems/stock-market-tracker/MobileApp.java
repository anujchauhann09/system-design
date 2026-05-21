class MobileApp implements Observer {

    private String appName;

    MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[" + appName + "] Alert: " + stockSymbol + " is now ₹" + price);
    }
}
