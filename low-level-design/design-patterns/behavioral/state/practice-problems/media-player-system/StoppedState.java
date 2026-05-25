class StoppedState implements MediaState {

    @Override
    public void play(Media media) {
        System.out.println("Starting...");
        media.setState(new PlayingState());
    }

    @Override
    public void pause(Media media) {
        System.out.println("Cannot pause. Media is stopped.");
    }

    @Override
    public void stop(Media media) {
        System.out.println("Already stopped.");
    }
}
