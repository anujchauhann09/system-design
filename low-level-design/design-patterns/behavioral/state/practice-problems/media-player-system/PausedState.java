class PausedState implements MediaState {

    @Override
    public void play(Media media) {
        System.out.println("Resuming...");
        media.setState(new PlayingState());
    }

    @Override
    public void pause(Media media) {
        System.out.println("Already paused.");
    }

    @Override
    public void stop(Media media) {
        System.out.println("Stopping from paused...");
        media.setState(new StoppedState());
    }
}
