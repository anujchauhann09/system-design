class PremiumPricing implements PricingStrategy {
    double premiumPercent;

    PremiumPricing(double premiumPercent) {
        this.premiumPercent = premiumPercent;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice + (basePrice * premiumPercent / 100);
    }
}
