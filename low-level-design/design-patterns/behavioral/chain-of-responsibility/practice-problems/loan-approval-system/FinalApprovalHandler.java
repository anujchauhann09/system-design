class FinalApprovalHandler extends Handler {

    @Override
    public void handle(LoanApplication application) {
        System.out.println("Loan for " + application.getApplicant()
                + " approved: $" + application.getAmount());
        forward(application);   // end of chain, but stays extensible
    }
}
