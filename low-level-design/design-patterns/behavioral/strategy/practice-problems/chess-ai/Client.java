class Client {
    public static void main(String[] args) {
        ChessGame easy = new ChessGame(new EasyDifficulty());
        ChessGame medium = new ChessGame(new MediumDifficulty());
        ChessGame hard = new ChessGame(new HardDifficulty());

        easy.play("current board state");
        medium.play("current board state");
        hard.play("current board state");
    }
}
