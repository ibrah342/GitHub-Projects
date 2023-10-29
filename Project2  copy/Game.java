public class Game {
    public static void main(String[] args) {
        Board myBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);
        System.out.println(myBoard);

    }
}
