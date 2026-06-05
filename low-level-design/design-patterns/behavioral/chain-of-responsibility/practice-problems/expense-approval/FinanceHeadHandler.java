class FinanceHeadHandler extends Handler {

    private static final double LIMIT = 20_000;

    @Override
    public void handle(ExpenseRequest request) {
        if (request.getAmount() <= LIMIT) {
            System.out.println("Finance Head approved $" + request.getAmount()
                    + " expense for " + request.getRequester());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Expense for " + request.getRequester() + " rejected");
        }
    }
}
