class TradingBot implements Observer {

    private String botName;

    TradingBot(String botName) {
        this.botName = botName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[" + botName + "] Analyzing " + stockSymbol + " at ₹" + price + " — executing trade logic.");
    }
}
