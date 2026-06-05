class CreditScoreCheckHandler extends Handler {

    private static final int MIN_SCORE = 700;

    @Override
    public void handle(LoanApplication application) {
        if (application.getCreditScore() < MIN_SCORE) {
            System.out.println("Loan for " + application.getApplicant()
                    + " rejected: credit score " + application.getCreditScore() + " below " + MIN_SCORE);
            return;   // short-circuit the chain
        }
        System.out.println("[OK] credit score " + application.getCreditScore());
        forward(application);
    }
}
