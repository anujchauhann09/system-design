class Client {
    public static void main(String[] args) {
        TaxService income = new TaxService(new IncomeTax());
        TaxService gst = new TaxService(new GSTax());
        TaxService exempt = new TaxService(new NoTax());

        System.out.println("Income tax: " + income.getTax(100000));  // 30000.0
        System.out.println("GST: " + gst.getTax(100000));            // 18000.0
        System.out.println("No tax: " + exempt.getTax(100000));      // 0.0
    }
}
