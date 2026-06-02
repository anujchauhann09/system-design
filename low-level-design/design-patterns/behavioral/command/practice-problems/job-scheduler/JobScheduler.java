import java.util.Queue;
import java.util.LinkedList;

class JobScheduler {

    private Queue<Command> jobQueue = new LinkedList<>();

    public void schedule(Command command) {
        jobQueue.offer(command);
    }

    public void run() {
        System.out.println("Running " + jobQueue.size() + " scheduled jobs...");
        while (!jobQueue.isEmpty()) {
            Command job = jobQueue.poll();
            job.execute();
        }
        System.out.println("All jobs done");
    }
}
