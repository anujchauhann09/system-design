class FestivalPricing implements PricingStrategy {
    double flatDiscount;

    FestivalPricing(double flatDiscount) {
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice - flatDiscount;
    }
}
