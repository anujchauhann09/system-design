class GreenState implements SignalState {

    public void next(Signal signal) {
        System.out.println("Green Signal");
        signal.setState(new YellowState());
    }
}