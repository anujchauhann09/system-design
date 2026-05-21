class InventoryService implements EventListener {

    @Override
    public void onEvent(String topic, String message) {
        System.out.println("[InventoryService] Updating inventory for event: " + message);
    }
}
