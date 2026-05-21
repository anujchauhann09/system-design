class PaymentService implements EventListener {

    @Override
    public void onEvent(String topic, String message) {
        System.out.println("[PaymentService] Processing payment event: " + message);
    }
}
