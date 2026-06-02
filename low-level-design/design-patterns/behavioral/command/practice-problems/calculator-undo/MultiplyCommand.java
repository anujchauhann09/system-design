class MultiplyCommand implements Command {
    private Calculator calculator;
    private int operand;
    private int previousValue;

    public MultiplyCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        previousValue = calculator.getValue();
        calculator.multiply(operand);
    }

    public void undo() {
        calculator.subtract(calculator.getValue() - previousValue);
    }
}
