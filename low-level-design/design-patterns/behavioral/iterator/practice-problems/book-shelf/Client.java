class Client {

    public static void main(String args[]) {

        BookShelf shelf = new BookShelf();
        shelf.addBook("Clean Code", "Robert C. Martin");
        shelf.addBook("Effective Java", "Joshua Bloch");
        shelf.addBook("The Pragmatic Programmer", "Andrew Hunt");

        BookIterator iterator = shelf.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.title + " by " + book.author);
        }
    }
}
