class Client {

    public static void main(String args[]) {

        //         4
        //        / \
        //       2   6
        //      / \ / \
        //     1  3 5  7
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BinaryTree tree = new BinaryTree(root);

        Iterator iterator = tree.createInorderIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
