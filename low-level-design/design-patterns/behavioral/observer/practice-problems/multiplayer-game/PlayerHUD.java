class PlayerHUD implements Observer {

    private String playerName;

    PlayerHUD(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void update(String eventType, String details) {
        System.out.println("[HUD - " + playerName + "] Event: " + eventType + " | " + details);
    }
}
