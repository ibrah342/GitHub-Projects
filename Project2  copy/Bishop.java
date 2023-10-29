public class Bishop {
    int row;
    int col;
    boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifyDiagonal(row, col, endRow, endCol) &&
                board.verifySourceAndDestination(row, col, endRow, endCol, isBlack)) {
            return true;
        }
        return false;
    }
}
