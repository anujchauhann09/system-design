class SubmittedState implements DocumentState {

    @Override
    public void submit(Document doc)            { System.out.println("Already submitted."); }

    @Override
    public void review(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Under review.");
        doc.setState(new UnderReviewState());
    }

    @Override
    public void approve(Document doc)           { System.out.println("Document must be reviewed first."); }

    @Override
    public void reject(Document doc, String r) {
        System.out.println("[" + doc.getTitle() + "] Rejected: " + r + ". Sent back to draft.");
        doc.setState(new DraftState());
    }

    @Override
    public void publish(Document doc)           { System.out.println("Document must be approved before publishing."); }

    @Override
    public void archive(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Archived.");
        doc.setState(new ArchivedState());
    }
}
