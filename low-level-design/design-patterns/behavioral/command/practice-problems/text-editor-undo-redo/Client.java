public class Client {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        CommandManager manager = new CommandManager();

        manager.execute(new WriteTextCommand(editor, "Hello"));
        manager.execute(new WriteTextCommand(editor, " World"));
        manager.execute(new PasteTextCommand(editor, "!!!"));
        System.out.println("After writes/paste : \"" + editor.getContent() + "\"");

        manager.execute(new DeleteTextCommand(editor, 3));
        System.out.println("After delete       : \"" + editor.getContent() + "\"");

        manager.undo();
        System.out.println("After undo delete  : \"" + editor.getContent() + "\"");

        manager.undo();
        System.out.println("After undo paste   : \"" + editor.getContent() + "\"");

        manager.redo();
        System.out.println("After redo paste   : \"" + editor.getContent() + "\"");

        manager.redo();
        System.out.println("After redo delete  : \"" + editor.getContent() + "\"");

        manager.execute(new WriteTextCommand(editor, "?"));
        System.out.println("After new write    : \"" + editor.getContent() + "\"");

        manager.redo();   // redo history was cleared by the new write
    }
}
