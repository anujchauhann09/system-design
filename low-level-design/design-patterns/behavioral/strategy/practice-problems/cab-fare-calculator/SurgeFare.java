class SurgeFare implements FareStrategy {
    double surgeMultiplier;

    SurgeFare(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateFare(double distanceKm) {
        return distanceKm * 10 * surgeMultiplier;
    }
}
