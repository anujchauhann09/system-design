class Client {
    public static void main(String[] args) {

        System.out.println("--- Happy Path ---");
        Document doc1 = new Document("Q4 Report");
        doc1.submit();
        doc1.review();
        doc1.approve();
        doc1.publish();
        doc1.archive();

        System.out.println("\n--- Rejected during review, resubmitted ---");
        Document doc2 = new Document("Product Spec");
        doc2.submit();
        doc2.review();
        doc2.reject("Missing technical details");
        doc2.submit();
        doc2.review();
        doc2.approve();
        doc2.publish();

        System.out.println("\n--- Cannot publish without approval ---");
        Document doc3 = new Document("Blog Post");
        doc3.submit();
        doc3.publish();
    }
}
