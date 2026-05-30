import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

class FileSystem {

    FileSystemNode root;

    FileSystem(FileSystemNode root) {
        this.root = root;
    }

    public Iterator createFileIterator() {
        return new FileIterator(root);
    }

    private class FileIterator implements Iterator {

        Deque<FileSystemNode> stack = new ArrayDeque<>();

        FileIterator(FileSystemNode root) {
            stack.push(root);
        }

        public boolean hasNext() {
            // expand directories until a file sits on top of the stack
            while (!stack.isEmpty() && stack.peek().isDirectory) {
                FileSystemNode dir = stack.pop();
                List<FileSystemNode> children = dir.children;
                // push in reverse so the first child is popped first
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
            return !stack.isEmpty();
        }

        public String next() {
            return stack.pop().name;
        }
    }
}
