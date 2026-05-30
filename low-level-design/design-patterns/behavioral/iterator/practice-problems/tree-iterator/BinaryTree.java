import java.util.Deque;
import java.util.ArrayDeque;

class BinaryTree {

    Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    public Iterator createInorderIterator() {
        return new InorderIterator(root);
    }

    private class InorderIterator implements Iterator {

        Deque<Node> stack = new ArrayDeque<>();

        InorderIterator(Node root) {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            Node node = stack.pop();
            pushLeft(node.right);
            return node.value;
        }
    }
}
