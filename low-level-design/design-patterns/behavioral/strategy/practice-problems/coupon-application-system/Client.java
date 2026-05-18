class Client {
    public static void main(String[] args) {
        CartService flat = new CartService(new FlatDiscountCoupon(50));
        CartService percent = new CartService(new PercentageDiscountCoupon(20));
        CartService bogo = new CartService(new BuyOneGetOneCoupon());
        CartService none = new CartService(new NoCoupon());

        System.out.println("Flat discount: " + flat.getFinalPrice(500));      // 450.0
        System.out.println("20% off: " + percent.getFinalPrice(500));         // 400.0
        System.out.println("BOGO: " + bogo.getFinalPrice(500));               // 250.0
        System.out.println("No coupon: " + none.getFinalPrice(500));          // 500.0
    }
}
