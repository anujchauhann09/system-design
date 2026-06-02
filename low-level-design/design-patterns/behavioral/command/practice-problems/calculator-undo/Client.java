public class Client {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        CommandManager manager = new CommandManager();

        manager.execute(new AddCommand(calculator, 10));
        manager.execute(new SubtractCommand(calculator, 3));
        manager.execute(new MultiplyCommand(calculator, 4));

        System.out.println("--- undo ---");
        manager.undo();   // undo multiply
        manager.undo();   // undo subtract
        manager.undo();   // undo add
        manager.undo();   // nothing left
    }
}
