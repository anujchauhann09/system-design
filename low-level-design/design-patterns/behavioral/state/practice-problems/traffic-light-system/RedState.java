class RedState implements SignalState {

    public void next(Signal signal) {
        System.out.println("Red Signal");
        signal.setState(new GreenState());
    }
}
