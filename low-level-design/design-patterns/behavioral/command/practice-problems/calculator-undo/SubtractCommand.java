class SubtractCommand implements Command {
    private Calculator calculator;
    private int operand;

    public SubtractCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.subtract(operand);
    }

    public void undo() {
        calculator.add(operand);
    }
}
