class PasteTextCommand implements Command {
    private TextEditor editor;
    private String clipboard;
    private int pasteStart;

    public PasteTextCommand(TextEditor editor, String clipboard) {
        this.editor = editor;
        this.clipboard = clipboard;
    }

    public void execute() {
        pasteStart = editor.length();
        editor.insertAt(pasteStart, clipboard);
    }

    public void undo() {
        editor.deleteLast(clipboard.length());
    }
}
