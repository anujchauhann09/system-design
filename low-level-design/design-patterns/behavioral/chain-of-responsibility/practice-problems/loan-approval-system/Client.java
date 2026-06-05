class Client {
    public static void main(String[] args) {
        Handler creditScore = new CreditScoreCheckHandler();
        Handler income      = new IncomeVerificationHandler();
        Handler fraud       = new FraudCheckHandler();
        Handler finalApprov = new FinalApprovalHandler();

        creditScore.setNext(income);
        income.setNext(fraud);
        fraud.setNext(finalApprov);

        Handler chain = creditScore;   // every application enters at the credit check

        System.out.println("--- strong application ---");
        chain.handle(new LoanApplication("Alice", 60_000, 760, 40_000, false));

        System.out.println("\n--- low credit score ---");
        chain.handle(new LoanApplication("Bob", 20_000, 640, 50_000, false));

        System.out.println("\n--- income too low for amount ---");
        chain.handle(new LoanApplication("Carol", 200_000, 720, 50_000, false));

        System.out.println("\n--- fraud flagged ---");
        chain.handle(new LoanApplication("Dave", 30_000, 780, 90_000, true));
    }
}
