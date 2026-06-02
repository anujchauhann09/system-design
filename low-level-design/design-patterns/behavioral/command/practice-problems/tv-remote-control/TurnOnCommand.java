class TurnOnCommand implements Command {
    private Tv tv;

    public TurnOnCommand(Tv tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}