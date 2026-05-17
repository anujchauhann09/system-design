class PricingEngine {
    PricingStrategy strategy;

    PricingEngine(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    double calculatePrice(double basePrice) {
        return strategy.applyPricing(basePrice);
    }
}
