class TurnOffCommand implements Command {
    private Tv tv;

    public TurnOffCommand(Tv tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}