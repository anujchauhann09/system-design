import java.util.LinkedList;
import java.util.Queue;

// Lazy-initialized thread-safe Singleton (Bill Pugh / holder idiom).
// One shared printer — all print jobs go through a single queue.
public class PrinterManager {

    private final Queue<String> jobQueue = new LinkedList<>();
    private int jobsPrinted = 0;

    // private constructor stops anyone from doing `new PrinterManager()`
    private PrinterManager() {
    }

    // holder is loaded only when getInstance() is first called (lazy)
    private static class Holder {
        private static final PrinterManager INSTANCE = new PrinterManager();
    }

    // global access point — triggers Holder loading on first call
    public static PrinterManager getInstance() {
        return Holder.INSTANCE;
    }

    // queue a document for printing
    public synchronized void submit(String document) {
        jobQueue.offer(document);
        System.out.println("Queued: " + document + " (pending: " + jobQueue.size() + ")");
    }

    // print the next document in the queue
    public synchronized void printNext() {
        String document = jobQueue.poll();
        if (document == null) {
            System.out.println("Nothing to print.");
            return;
        }
        jobsPrinted++;
        System.out.println("Printing: " + document + " (total printed: " + jobsPrinted + ")");
    }
}
