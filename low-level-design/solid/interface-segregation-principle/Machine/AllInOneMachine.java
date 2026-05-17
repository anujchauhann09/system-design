class AllInOneMachine implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("AllInOneMachine: printing...");
    }

    @Override
    public void scan() {
        System.out.println("AllInOneMachine: scanning...");
    }

    @Override
    public void fax() {
        System.out.println("AllInOneMachine: faxing...");
    }
}
