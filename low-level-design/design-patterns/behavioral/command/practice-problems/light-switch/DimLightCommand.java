class DimLightCommand implements Command {
    private Light light;
    private int level;

    public DimLightCommand(Light light, int level) {
        this.light = light;
        this.level = level;
    }

    public void execute() {
        light.dim(level);
    }
}
