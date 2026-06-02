public class Client {

    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand =
                new SwitchOnCommand(light);
        Command offCommand =
                new SwitchOffCommand(light);
        Command dimCommand =
                new DimLightCommand(light, 40);

        Switch lightSwitch =
                new Switch();

        lightSwitch.setCommand(onCommand);
        lightSwitch.press();

        lightSwitch.setCommand(dimCommand);
        lightSwitch.press();

        lightSwitch.setCommand(offCommand);
        lightSwitch.press();
    }
}
