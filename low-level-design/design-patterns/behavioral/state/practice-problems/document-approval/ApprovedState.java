class ApprovedState implements DocumentState {

    @Override
    public void submit(Document doc)            { System.out.println("Already approved."); }

    @Override
    public void review(Document doc)            { System.out.println("Already approved."); }

    @Override
    public void approve(Document doc)           { System.out.println("Already approved."); }

    @Override
    public void reject(Document doc, String reason) {
        System.out.println("[" + doc.getTitle() + "] Approval revoked: " + reason + ". Sent back to draft.");
        doc.setState(new DraftState());
    }

    @Override
    public void publish(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Published successfully.");
        doc.setState(new PublishedState());
    }

    @Override
    public void archive(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Archived.");
        doc.setState(new ArchivedState());
    }
}
