class NoTax implements TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return 0;
    }
}
