class SupervisorHandler extends Handler {

    private static final double LIMIT = 1_000;

    @Override
    public void handle(ExpenseRequest request) {
        if (request.getAmount() <= LIMIT) {
            System.out.println("Supervisor approved $" + request.getAmount()
                    + " expense for " + request.getRequester());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Expense for " + request.getRequester() + " rejected");
        }
    }
}
