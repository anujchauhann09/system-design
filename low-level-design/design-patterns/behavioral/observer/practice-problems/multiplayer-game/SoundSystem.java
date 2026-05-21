class SoundSystem implements Observer {

    @Override
    public void update(String eventType, String details) {
        switch (eventType) {
            case "KILL"      -> System.out.println("[Sound] Playing kill sound.");
            case "DEATH"     -> System.out.println("[Sound] Playing death sound.");
            case "LEVEL_UP"  -> System.out.println("[Sound] Playing level up sound.");
            default          -> System.out.println("[Sound] Playing generic event sound.");
        }
    }
}
