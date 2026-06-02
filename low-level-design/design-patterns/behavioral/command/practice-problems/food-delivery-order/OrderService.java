class OrderService {

    public void process(Command command) {
        command.execute();
    }
}
