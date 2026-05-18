class MediumDifficulty implements DifficultyStrategy {
    @Override
    public String makeMove(String boardState) {
        return "Medium AI: analyzing 2 moves ahead and picking best option.";
    }
}
