public class Piece {
    public char color;
    public char name;
    public int numMoves;
    public int lastMoved;
    public static int blackKing [] = {0,4}; // bK starts at 0 4
    public static int whiteKing [] = {7,4}; // wK starts at 7 4
    public String toString() {
        return color + "" + name;
    }
    public Piece(char color, char name, int numMoves, int lastMoved) {
        this.color = color;
        this.name = name;
        this.numMoves = numMoves;
        this.lastMoved = lastMoved;
    }
}