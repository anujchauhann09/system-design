import java.util.ArrayList;
import java.util.List;

class BookShelf {

    List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public BookIterator createIterator() {
        return new ShelfIterator();
    }

    private class ShelfIterator implements BookIterator {

        int position = 0;

        public boolean hasNext() {
            return position < books.size();
        }

        public Book next() {
            return books.get(position++);
        }
    }
}
