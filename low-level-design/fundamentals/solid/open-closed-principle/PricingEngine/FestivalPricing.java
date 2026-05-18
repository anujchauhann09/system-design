class FestivalPricing implements PricingStrategy {
    double flatDiscount;

    FestivalPricing(double flatDiscount) {
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double applyPricing(double basePrice) {
        return basePrice - flatDiscount;
    }
}
