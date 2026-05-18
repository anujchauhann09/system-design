class PremiumFare implements FareStrategy {
    @Override
    public double calculateFare(double distanceKm) {
        return distanceKm * 20;
    }
}
