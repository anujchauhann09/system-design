class Client {
    public static void main(String[] args) {
        StockMarket tcs = new StockMarket("TCS");

        Observer zerodha  = new MobileApp("Zerodha");
        Observer groww    = new MobileApp("Groww");
        Observer alphaBot = new TradingBot("AlphaBot");

        tcs.addObserver(zerodha);
        tcs.addObserver(groww);
        tcs.addObserver(alphaBot);

        tcs.updatePrice(3500.00);

        System.out.println();

        tcs.removeObserver(groww);
        tcs.updatePrice(3650.00);
    }
}
