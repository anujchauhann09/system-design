import java.util.ArrayList;
import java.util.List;

class FileSystemNode {

    String name;
    boolean isDirectory;
    List<FileSystemNode> children = new ArrayList<>();

    FileSystemNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
    }

    public FileSystemNode add(FileSystemNode child) {
        children.add(child);
        return this;
    }
}
