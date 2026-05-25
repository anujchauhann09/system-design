class DraftState implements DocumentState {

    @Override
    public void submit(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Submitted for review.");
        doc.setState(new SubmittedState());
    }

    @Override
    public void review(Document doc)            { System.out.println("Submit the document first."); }

    @Override
    public void approve(Document doc)           { System.out.println("Document not submitted yet."); }

    @Override
    public void reject(Document doc, String r)  { System.out.println("Document not submitted yet."); }

    @Override
    public void publish(Document doc)           { System.out.println("Document must be approved before publishing."); }

    @Override
    public void archive(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Draft archived.");
        doc.setState(new ArchivedState());
    }
}
