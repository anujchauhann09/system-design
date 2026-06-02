class AddCommand implements Command {
    private Calculator calculator;
    private int operand;

    public AddCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.add(operand);
    }

    public void undo() {
        calculator.subtract(operand);
    }
}
