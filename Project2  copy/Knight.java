public class Knight {
    int row;
    int col;
    boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                (Math.pow((row - endRow), 2) + Math.pow((col - endCol), 2)) == 5) {
            return true;
        }
        return false;
    }
}