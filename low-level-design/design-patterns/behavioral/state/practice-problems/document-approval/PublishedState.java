class PublishedState implements DocumentState {

    @Override
    public void submit(Document doc)            { System.out.println("Document already published."); }

    @Override
    public void review(Document doc)            { System.out.println("Document already published."); }

    @Override
    public void approve(Document doc)           { System.out.println("Document already published."); }

    @Override
    public void reject(Document doc, String r)  { System.out.println("Cannot reject a published document."); }

    @Override
    public void publish(Document doc)           { System.out.println("Already published."); }

    @Override
    public void archive(Document doc) {
        System.out.println("[" + doc.getTitle() + "] Published document archived.");
        doc.setState(new ArchivedState());
    }
}
