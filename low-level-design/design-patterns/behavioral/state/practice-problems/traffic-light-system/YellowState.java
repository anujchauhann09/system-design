class YellowState implements SignalState {

    public void next(Signal signal) {
        System.out.println("Yellow Signal");
        signal.setState(new RedState());
    }
}