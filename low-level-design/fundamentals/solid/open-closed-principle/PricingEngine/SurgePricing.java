class SurgePricing implements PricingStrategy {
    double surgeMultiplier;

    SurgePricing(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double applyPricing(double basePrice) {
        return basePrice * surgeMultiplier;
    }
}
