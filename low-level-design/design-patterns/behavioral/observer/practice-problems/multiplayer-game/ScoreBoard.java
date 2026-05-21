class ScoreBoard implements Observer {

    @Override
    public void update(String eventType, String details) {
        if (eventType.equals("KILL") || eventType.equals("DEATH")) {
            System.out.println("[ScoreBoard] Updating scores — " + details);
        }
    }
}
