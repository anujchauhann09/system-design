interface DocumentState {
    void submit(Document doc);
    void review(Document doc);
    void approve(Document doc);
    void reject(Document doc, String reason);
    void publish(Document doc);
    void archive(Document doc);
}
