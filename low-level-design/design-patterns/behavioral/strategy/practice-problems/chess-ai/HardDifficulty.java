class HardDifficulty implements DifficultyStrategy {
    @Override
    public String makeMove(String boardState) {
        return "Hard AI: running deep minimax search and picking optimal move.";
    }
}
