class Calculator {

    private int value = 0;

    public void add(int n) {
        value += n;
        System.out.println("Added " + n + " -> " + value);
    }

    public void subtract(int n) {
        value -= n;
        System.out.println("Subtracted " + n + " -> " + value);
    }

    public void multiply(int n) {
        value *= n;
        System.out.println("Multiplied by " + n + " -> " + value);
    }

    public int getValue() {
        return value;
    }
}
