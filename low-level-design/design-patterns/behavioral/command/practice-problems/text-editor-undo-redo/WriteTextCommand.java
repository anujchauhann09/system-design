class WriteTextCommand implements Command {
    private TextEditor editor;
    private String text;

    public WriteTextCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    public void execute() {
        editor.insert(text);
    }

    public void undo() {
        editor.deleteLast(text.length());
    }
}
