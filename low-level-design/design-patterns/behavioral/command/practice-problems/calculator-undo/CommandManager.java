import java.util.Deque;
import java.util.ArrayDeque;

class CommandManager {

    private Deque<Command> history = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        Command command = history.pop();
        command.undo();
    }
}
