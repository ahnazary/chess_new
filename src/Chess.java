public class Chess {

    public static void main(String[] args) {

        Piece[][] board = new Piece[8][8];
        Board.initWhite(board);
        Board.initBoard(board);
        Board.initSquares(board);

        Piece[][] boardCopy = new Piece[8][8];

        int okMove;

        for (int i = 0; ; i++) {
            Board.displayBoard(board);
            System.out.println();

            copy(board, boardCopy);

            if (i % 2 == 0) {
                if (Conditions.isCheck(board, 'w', i)) {

                    if (Conditions.isCheckmate(board, 'w', Piece.whiteKing[0], Piece.whiteKing[1], i)) {

                        System.out.println("Checkmate");
                        System.out.println("Black wins");
                        System.exit(0);
                    } else {
                        System.out.println("Check");
                    }
                } else {

                    if (Conditions.isStalemate(board, 'w', i)) {
                        System.out.println("Stalemate");
                        System.exit(0);
                    }
                }

                System.out.print("White's move: ");
                Input.readEntry('w');
                okMove = Input.callMove(board, 'w', i);

                while (okMove < 0 || Conditions.isCheck(board, 'w', i)) {

                    if (okMove > 0) {

                        System.out.println("invalid move");
                        copy(boardCopy, board);
                    }


                    System.out.print("White's move: ");
                    Input.readEntry('w');
                    okMove = Input.callMove(board, 'w', i);
                }

            } else {

                if (Conditions.isCheck(board, 'b', i)) {
                    if (Conditions.isCheckmate(board, 'b', Piece.blackKing[0], Piece.blackKing[1], i)) {
                        System.out.println("Checkmate");
                        System.out.println("White wins");
                        System.exit(0);
                    } else {
                        System.out.println("Check");
                    }
                } else {
                    if (Conditions.isStalemate(board, 'b', i)) {
                        System.out.println("Stalemate");
                        System.exit(0);
                    }
                }

                System.out.print("Black's move: ");
                Input.readEntry('b');
                okMove = Input.callMove(board, 'b', i);

                while (okMove < 0 || Conditions.isCheck(board, 'b', i)) {

                    if (okMove > 0) {
                        System.out.println("king in check");
                        copy(boardCopy, board);
                    }

                    System.out.print("Black's move: ");
                    Input.readEntry('b');
                    okMove = Input.callMove(board, 'b', i);
                }
            }
            System.out.println();
        }
    }


    public static void copy(Piece[][] board, Piece[][] board2) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board2[i][j] = board[i][j];
            }
        }
    }

}
