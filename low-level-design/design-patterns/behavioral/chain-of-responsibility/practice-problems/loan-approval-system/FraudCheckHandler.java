class FraudCheckHandler extends Handler {

    @Override
    public void handle(LoanApplication application) {
        if (application.isFlaggedForFraud()) {
            System.out.println("Loan for " + application.getApplicant()
                    + " rejected: flagged by fraud check");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] fraud check passed");
        forward(application);
    }
}
