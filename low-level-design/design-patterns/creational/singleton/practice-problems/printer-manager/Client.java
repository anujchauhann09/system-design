class Client {
    public static void main(String[] args) {

        // both references point to the same shared printer
        PrinterManager a = PrinterManager.getInstance();
        PrinterManager b = PrinterManager.getInstance();

        // jobs submitted through different references land in ONE queue
        a.submit("invoice.pdf");
        b.submit("report.docx");
        a.submit("photo.png");

        // any reference drains the same queue
        b.printNext();
        a.printNext();
        b.printNext();
        a.printNext(); // queue empty

        System.out.println("Same instance? " + (a == b)); // true
    }
}
