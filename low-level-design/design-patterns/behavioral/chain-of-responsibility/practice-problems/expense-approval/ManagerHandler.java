class ManagerHandler extends Handler {

    private static final double LIMIT = 5_000;

    @Override
    public void handle(ExpenseRequest request) {
        if (request.getAmount() <= LIMIT) {
            System.out.println("Manager approved $" + request.getAmount()
                    + " expense for " + request.getRequester());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Expense for " + request.getRequester() + " rejected");
        }
    }
}
