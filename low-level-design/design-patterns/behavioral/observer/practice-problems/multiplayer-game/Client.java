class Client {
    public static void main(String[] args) {
        GameEventSystem eventSystem = new GameEventSystem();

        Observer aliceHUD  = new PlayerHUD("Alice");
        Observer bobHUD    = new PlayerHUD("Bob");
        Observer scoreBoard = new ScoreBoard();
        Observer sound      = new SoundSystem();

        eventSystem.addObserver(aliceHUD);
        eventSystem.addObserver(bobHUD);
        eventSystem.addObserver(scoreBoard);
        eventSystem.addObserver(sound);

        eventSystem.triggerEvent("KILL", "Alice killed Bob");

        System.out.println();

        eventSystem.triggerEvent("LEVEL_UP", "Alice reached Level 10");

        System.out.println();

        eventSystem.removeObserver(bobHUD);
        eventSystem.triggerEvent("DEATH", "Alice was eliminated");
    }
}
