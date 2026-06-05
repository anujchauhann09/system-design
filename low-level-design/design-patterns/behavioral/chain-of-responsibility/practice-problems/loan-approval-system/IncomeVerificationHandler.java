class IncomeVerificationHandler extends Handler {

    // loan must not exceed 3x the applicant's annual income
    private static final double MAX_INCOME_MULTIPLE = 3;

    @Override
    public void handle(LoanApplication application) {
        double maxLoan = application.getAnnualIncome() * MAX_INCOME_MULTIPLE;
        if (application.getAmount() > maxLoan) {
            System.out.println("Loan for " + application.getApplicant()
                    + " rejected: amount $" + application.getAmount()
                    + " exceeds 3x income ($" + maxLoan + ")");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] income supports the requested amount");
        forward(application);
    }
}
