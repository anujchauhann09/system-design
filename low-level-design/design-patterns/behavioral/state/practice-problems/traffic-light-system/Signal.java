class Signal {

    private SignalState state;

    public Signal() {
        state = new GreenState();
    }

    public void setState(SignalState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}