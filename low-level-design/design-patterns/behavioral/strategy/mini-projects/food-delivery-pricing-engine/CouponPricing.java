class CouponPricing implements PricingStrategy {
    double discountPercent;

    CouponPricing(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice - (basePrice * discountPercent / 100);
    }
}
