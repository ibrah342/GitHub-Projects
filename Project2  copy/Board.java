public class Board {

    // Instance variables
    private Piece[][] board;


    // Constructs an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
    }

    // Accessor Methods

    // Returns the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }


    // Updates a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    // Game functionality methods

    /**
     *
     * @param startRow: the start Row
     * @param startCol: the start col
     * @param endRow: the end row
     * @param endCol: the end col
     * @return  this functions moves a 'Piece' object from one cell on the board to another
     * if the movement is legal(.isMoveLegal). Returns a boolean to signify the success or failure of the function.
     */
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol].isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = board[startRow][startCol];
            board[endRow][endCol].setPosition(endRow, endCol);
            board[startRow][startCol] = null;

            return true;

        } else {
            return false;
        }
    }



    /**
     * The isGameOver function checks if either of the players kings have been captured.
     * I start by creating a nested loop that checks every cell to see if there is a white & black king on the board.
     * Then I made conditionals to see if there is both kings on the board at once aor if one has been captured.
     * The function is going to return true or false depending on if a piece has been captured
     */
    public boolean isGameOver() {
        boolean whiteKing = false;
        boolean blackKing = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; i < 8; j++) {
                if (this.board[i][j].character == '♔') {
                    whiteKing = true;
                }
                if (this.board[i][j].character == '♚') {
                    blackKing = true;
                }

            }
        }
        if (whiteKing == true && blackKing == true) {
            return false;
        } else {
            return true;
        }
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for (int i = 0; i < 8; i++) {
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for (int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for (int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }


    /**
     * - The clear function goes into every cell of the array and changes it into null
     */
    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = null;
            }
        }
    }

    // Movement helper functions

    /**
     * @param startRow : the starting row of the piece
     * @param startCol : the starting colum of the piece
     * @param endRow   : the ending row of where you want a  piece to win
     * @param endCol   : the ending column of where you want a piece to win
     * @param isBlack  : the color of the piece, true if the piece is black, false if the piece is white
     * @return : Returns true only if startCol, startRow & endCol, endRow are in the bounds of the board, if the 'start'
     * contains a piece object and is not set to null, if the players color ande the isBlack are the same, and the 'end'
     * contains either no piece(set to null) or is a piece of the opposite color.
     */
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        return startRow >= 0 && startCol >= 0 && endRow >= 0 && endCol >= 0
                && startRow < 8 && startCol < 8 && endRow < 8 && endCol < 8
                && board[startRow][startCol] != null && board[startRow][startCol].getIsBlack() == isBlack
                &&(board[endRow][endCol] == null || (board[endRow][endCol].getIsBlack() != isBlack));
    }

    /**
     *
     * @param startRow : the start row
     * @param startCol : the start col
     * @param endRow : the start row
     * @param endCol : the end col
     * @return : this function returns true if a given 'start' and 'end' position are adjacent to each other
     */
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow - startRow) <= 1) {
            if (Math.abs(endCol - startCol) <= 1) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param startRow : the start row
     * @param startCol : the start col
     * @param endRow : the end row
     * @param endCol : the end col
     * @return : This function returns true if a given 'start' and 'end' move are a valid horizontal
     *      * moves(takes place on one row) and if the spaces between the start and the end are empty and set to null.
     */

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {

        if (startRow != endRow) {
            return false;
        }
        //checks going to the right
        if (startCol < endCol) {
            for (int i = startCol + 1; i < endCol; i++) {
                if (board[endRow][i] != null) {
                    return false;
                }
            }
            //checks going to the left
        } else if(startCol > endCol) {
            for (int i = endCol + 1; i < startCol; i++) {
                if (board[endRow][i] != null) {
                    return false;
                }

            }
        }
        return true;
    }

    /**
     *
     * @param startRow : the start row
     * @param startCol : the start column
     * @param endRow :  the end row
     * @param endCol : the end column
     * @return : This function returns true if a given 'start' and 'end' move are a valid vertical
     * moves(takes place on one column) and if the spaces between the start and the end are empty and set to null.
     */
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol != endCol) {
            return false;
        }
        //checks going up
        if (startRow < endRow) {
            for (int i = startRow + 1; i < endRow; i++) {
                if (board[i][endCol] != null) {
                    return false;
                }
            }
            //checks going down
        } else if(startRow > endRow) {
            for (int i = endRow + 1; i < startRow; i++) {
                if (board[i][endCol] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param startRow : the start row
     * @param startCol : the start column
     * @param endRow : the end row
     * @param endCol : the end column
     * @return : the function is essentially verifying if the move is diagonal, it returns true if the path from the
     * start row & start column to the end row & end column is diagonal and there is no pieces in between the start
     * to the end meaning that all the spaces are null
     */

        public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol){

        int rowMove;
        int colMove;
        if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
        int steps = Math.abs(startRow - endRow);
        if (steps == 0) {
            return true;
        }
        if (endRow > startRow) {
            rowMove = 1;
        } else {
            rowMove = -1;
        }
        if (endCol > startCol) {
            colMove = 1;
        } else {
            colMove = -1;
        }
        for (int i = 1; i < steps; i++) {
            if (board[startRow + i * rowMove][startCol + i * colMove] != null) {
                return false;
            }
        }
        return true;
    }
        return false;
}



}
