class Client {
    public static void main(String[] args) {

        LibraryCatalog a = LibraryCatalog.getInstance();
        LibraryCatalog b = LibraryCatalog.getInstance();

        a.addBook("Clean Code");
        a.addBook("The Pragmatic Programmer");
        b.addBook("Design Patterns");
        b.addBook("Refactoring");

        System.out.println("Search 'design' -> " + b.searchBook("design"));
        System.out.println("Search 'co'     -> " + a.searchBook("co"));

        a.removeBook("Refactoring");
        b.removeBook("Nonexistent Book");

        System.out.println("Same instance? " + (a == b)); // true
    }
}
