class UnderReviewState implements DocumentState {

    @Override
    public void submit(Document doc)            { System.out.println("Already under review."); }

    @Override
    public void review(Document doc)            { System.out.println("Already under review."); }

    @Override
    public void approve(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Approved.");
        doc.setState(new ApprovedState());
    }

    @Override
    public void reject(Document doc, String reason) {
        System.out.println("[" + doc.getTitle() + "] Rejected: " + reason + ". Sent back to draft.");
        doc.setState(new DraftState());
    }

    @Override
    public void publish(Document doc)           { System.out.println("Document must be approved before publishing."); }

    @Override
    public void archive(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Archived during review.");
        doc.setState(new ArchivedState());
    }
}
