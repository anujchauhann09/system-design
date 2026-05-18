class IncomeTax implements TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.30;
    }
}
