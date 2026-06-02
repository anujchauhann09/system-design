import java.util.Deque;
import java.util.ArrayDeque;

class CommandManager {

    private Deque<Command> undoStack = new ArrayDeque<>();
    private Deque<Command> redoStack = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();   // a new action invalidates the redo history
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        Command command = undoStack.pop();
        command.undo();
        redoStack.push(command);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
    }
}
