class LoanApplication {

    private final String applicant;
    private final double amount;
    private final int creditScore;
    private final double annualIncome;
    private final boolean flaggedForFraud;

    public LoanApplication(String applicant, double amount, int creditScore,
                           double annualIncome, boolean flaggedForFraud) {
        this.applicant = applicant;
        this.amount = amount;
        this.creditScore = creditScore;
        this.annualIncome = annualIncome;
        this.flaggedForFraud = flaggedForFraud;
    }

    public String getApplicant() {
        return applicant;
    }

    public double getAmount() {
        return amount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public boolean isFlaggedForFraud() {
        return flaggedForFraud;
    }
}
