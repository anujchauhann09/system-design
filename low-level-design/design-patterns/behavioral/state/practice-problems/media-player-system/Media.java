class Media {

    private MediaState state;

    public Media() {
        state = new StoppedState();
    }

    public void setState(MediaState state) {
        this.state = state;
    }

    public void play()  { state.play(this); }
    public void pause() { state.pause(this); }
    public void stop()  { state.stop(this); }
}
