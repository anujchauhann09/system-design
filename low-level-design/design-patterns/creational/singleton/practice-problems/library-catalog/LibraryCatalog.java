import java.util.ArrayList;
import java.util.List;

// only ONE catalog of books exists for the whole library
public class LibraryCatalog {

    private final List<String> books = new ArrayList<>();

    private LibraryCatalog() {
    }

    private static class Holder {
        private static final LibraryCatalog INSTANCE = new LibraryCatalog();
    }

    public static LibraryCatalog getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void addBook(String title) {
        books.add(title);
        System.out.println("Added: " + title + " (total: " + books.size() + ")");
    }

    public synchronized void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Removed: " + title + " (total: " + books.size() + ")");
        } else {
            System.out.println("Not found, cannot remove: " + title);
        }
    }

    // case-insensitive substring search; returns matching titles
    public synchronized List<String> searchBook(String keyword) {
        List<String> matches = new ArrayList<>();
        String needle = keyword.toLowerCase();
        for (String title : books) {
            if (title.toLowerCase().contains(needle)) {
                matches.add(title);
            }
        }
        return matches;
    }
}
