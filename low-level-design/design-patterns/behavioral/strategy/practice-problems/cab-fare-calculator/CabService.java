class CabService {
    FareStrategy fareStrategy;

    CabService(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    double getFare(double distanceKm) {
        return fareStrategy.calculateFare(distanceKm);
    }
}
