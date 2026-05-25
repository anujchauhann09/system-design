class PlayingState implements MediaState {

    @Override
    public void play(Media media) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(Media media) {
        System.out.println("Pausing...");
        media.setState(new PausedState());
    }

    @Override
    public void stop(Media media) {
        System.out.println("Stopping...");
        media.setState(new StoppedState());
    }
}
