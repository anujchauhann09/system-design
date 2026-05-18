class PricingService {

    PricingStrategy pricingStrategy;

    PricingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double getPrice(double basePrice) {
        return pricingStrategy.calculatePrice(basePrice);
    }
}