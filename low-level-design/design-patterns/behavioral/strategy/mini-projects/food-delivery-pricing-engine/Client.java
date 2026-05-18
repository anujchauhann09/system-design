class Client {

    public static void main(String[] args) {
        PricingService normal = new PricingService(new NormalPricing());
        PricingService surge = new PricingService(new SurgePricing(1.5));
        PricingService festival = new PricingService(new FestivalPricing(30));
        PricingService premium = new PricingService(new PremiumPricing(20));
        PricingService coupon = new PricingService(new CouponPricing(10));

        System.out.println("Normal: " + normal.getPrice(100));      // 100.0
        System.out.println("Surge: " + surge.getPrice(100));        // 150.0
        System.out.println("Festival: " + festival.getPrice(100));  // 70.0
        System.out.println("Premium: " + premium.getPrice(100));    // 120.0
        System.out.println("Coupon: " + coupon.getPrice(100));      // 90.0
    }
}
