class ChessGame {
    DifficultyStrategy difficultyStrategy;

    ChessGame(DifficultyStrategy difficultyStrategy) {
        this.difficultyStrategy = difficultyStrategy;
    }

    void play(String boardState) {
        String move = difficultyStrategy.makeMove(boardState);
        System.out.println(move);
    }
}
