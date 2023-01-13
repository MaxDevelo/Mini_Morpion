package Model;

 public interface GameObserver {
    void updateBoard(int row, int column);
    void resetGame();
}
