class Document {
    private DocumentState state;
    private String title;

    Document(String title) {
        this.title = title;
        this.state = new DraftState();
        System.out.println("Document '" + title + "' created as draft.");
    }

    void setState(DocumentState state)  { this.state = state; }
    String getTitle()                   { return title; }

    void submit()                       { state.submit(this); }
    void review()                       { state.review(this); }
    void approve()                      { state.approve(this); }
    void reject(String reason)          { state.reject(this, reason); }
    void publish()                      { state.publish(this); }
    void archive()                      { state.archive(this); }
}
