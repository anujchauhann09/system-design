public class Client {

    public static void main(String[] args) {

        Tv tv = new Tv();

        Command onCommand =
                new TurnOnCommand(tv);
        Command offCommand =
                new TurnOffCommand(tv);

        RemoteControl remote =
                new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}