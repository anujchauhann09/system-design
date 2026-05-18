class TaxService {
    TaxStrategy taxStrategy;

    TaxService(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    double getTax(double amount) {
        return taxStrategy.calculateTax(amount);
    }
}
