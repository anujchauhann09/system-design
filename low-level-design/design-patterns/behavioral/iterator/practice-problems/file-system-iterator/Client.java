class Client {

    public static void main(String args[]) {

        // root
        // ├── a.txt
        // ├── docs
        // │   ├── resume.pdf
        // │   └── notes
        // │       └── lld.md
        // └── b.txt
        FileSystemNode root = new FileSystemNode("root", true);
        FileSystemNode docs = new FileSystemNode("docs", true);
        FileSystemNode notes = new FileSystemNode("notes", true);

        notes.add(new FileSystemNode("lld.md", false));
        docs.add(new FileSystemNode("resume.pdf", false)).add(notes);
        root.add(new FileSystemNode("a.txt", false)).add(docs).add(new FileSystemNode("b.txt", false));

        FileSystem fileSystem = new FileSystem(root);

        Iterator iterator = fileSystem.createFileIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
