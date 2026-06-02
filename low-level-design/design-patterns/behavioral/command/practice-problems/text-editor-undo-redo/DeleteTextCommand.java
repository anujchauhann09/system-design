class DeleteTextCommand implements Command {
    private TextEditor editor;
    private int length;
    private String deletedText;

    public DeleteTextCommand(TextEditor editor, int length) {
        this.editor = editor;
        this.length = length;
    }

    public void execute() {
        deletedText = editor.deleteLast(length);
    }

    public void undo() {
        editor.insert(deletedText);
    }
}
