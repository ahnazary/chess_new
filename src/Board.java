public class Board {

    public static void initWhite(Piece[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Piece(' ', ' ', -1, -1);
            }
        }
    }

    public static void initBoard(Piece[][] board) {

        // white pawns
        board[6][0] = new Piece('w', 'p', 0, -1);
        board[6][1] = new Piece('w', 'p', 0, -1);
        board[6][2] = new Piece('w', 'p', 0, -1);
        board[6][3] = new Piece('w', 'p', 0, -1);
        board[6][4] = new Piece('w', 'p', 0, -1);
        board[6][5] = new Piece('w', 'p', 0, -1);
        board[6][6] = new Piece('w', 'p', 0, -1);
        board[6][7] = new Piece('w', 'p', 0, -1);

        // white non-pawns
        board[7][0] = new Piece('w', 'R', 0, -1);
        board[7][1] = new Piece('w', 'N', 0, -1);
        board[7][2] = new Piece('w', 'B', 0, -1);
        board[7][3] = new Piece('w', 'Q', 0, -1);
        board[7][4] = new Piece('w', 'K', 0, -1);
        board[7][5] = new Piece('w', 'B', 0, -1);
        board[7][6] = new Piece('w', 'N', 0, -1);
        board[7][7] = new Piece('w', 'R', 0, -1);

        // black pawns
        board[1][0] = new Piece('b', 'p', 0, -1);
        board[1][1] = new Piece('b', 'p', 0, -1);
        board[1][2] = new Piece('b', 'p', 0, -1);
        board[1][3] = new Piece('b', 'p', 0, -1);
        board[1][4] = new Piece('b', 'p', 0, -1);
        board[1][5] = new Piece('b', 'p', 0, -1);
        board[1][6] = new Piece('b', 'p', 0, -1);
        board[1][7] = new Piece('b', 'p', 0, -1);

        // black non-pawns
        board[0][0] = new Piece('b', 'R', 0, -1);
        board[0][1] = new Piece('b', 'N', 0, -1);
        board[0][2] = new Piece('b', 'B', 0, -1);
        board[0][3] = new Piece('b', 'Q', 0, -1);
        board[0][4] = new Piece('b', 'K', 0, -1);
        board[0][5] = new Piece('b', 'B', 0, -1);
        board[0][6] = new Piece('b', 'N', 0, -1);
        board[0][7] = new Piece('b', 'R', 0, -1);
    }

    public static void initBoard1(Piece[][] board) {
        // white pieces
        board[7][7] = new Piece('w', 'K', 0, -1);

        // black pieces
        board[0][6] = new Piece('b', 'K', 0, -1);
        board[5][0] = new Piece('b', 'Q', 0, -1);
        board[5][7] = new Piece('b', 'p', 0, -1);
        board[4][6] = new Piece('b', 'p', 0, -1);
        board[3][5] = new Piece('b', 'p', 0, -1);
        Piece.whiteKing[0] = 7;
        Piece.whiteKing[1] = 7;
        Piece.blackKing[0] = 0;
        Piece.blackKing[1] = 6;
    }

    public static void initBoard2(Piece[][] board) {

        board[1][5] = new Piece('w', 'K', 0, -1);
        board[2][6] = new Piece('w', 'Q', 0, -1);

        board[0][7] = new Piece('b', 'K', 0, -1);

        Piece.whiteKing[0] = 1;
        Piece.whiteKing[1] = 5;
        Piece.blackKing[0] = 0;
        Piece.blackKing[1] = 7;
    }

    public static void initBoard3(Piece[][] board) {

        board[7][4] = new Piece('w', 'K', 0, -1);
        board[7][0] = new Piece('w', 'R', 0, -1);
        board[7][7] = new Piece('w', 'R', 0, -1);

        board[0][4] = new Piece('b', 'K', 0, -1);
        board[0][0] = new Piece('b', 'R', 0, -1);
        board[0][7] = new Piece('b', 'R', 0, -1);

        board[4][4] = new Piece('w', 'R', 0, -1);

    }

    public static void initBoard4(Piece[][] board) {
        board[1][2] = new Piece('w', 'K', 0, -1);
        board[2][1] = new Piece('w', 'Q', 0, -1);

        board[0][0] = new Piece('b', 'K', 0, -1);

        Piece.whiteKing[0] = 1;
        Piece.whiteKing[1] = 2;
        Piece.blackKing[0] = 0;
        Piece.blackKing[1] = 0;
    }

    public static void initBoard5(Piece[][] board) {
        board[6][1] = new Piece('w', 'p', 0, -1);
        board[6][4] = new Piece('w', 'p', 0, -1);
        board[6][2] = new Piece('w', 'p', 0, -1);
        board[6][7] = new Piece('w', 'p', 0, -1);
        board[3][3] = new Piece('w', 'p', 0, -1);
        board[3][1] = new Piece('w', 'p', 0, -1);
        board[3][6] = new Piece('w', 'p', 0, -1);
        board[7][4] = new Piece('w', 'K', 0, -1);

        board[0][1] = new Piece('b', 'p', 0, -1);
        board[4][0] = new Piece('b', 'p', 0, -1);
        board[4][3] = new Piece('b', 'p', 0, -1);
        board[4][7] = new Piece('b', 'p', 0, -1);
        board[1][2] = new Piece('b', 'p', 0, -1);
        board[1][0] = new Piece('b', 'p', 0, -1);
        board[1][7] = new Piece('b', 'p', 0, -1);
        board[0][4] = new Piece('b', 'K', 0, -1);
    }

    public static void initBoard6(Piece[][] board) {

        board[7][4] = new Piece('w', 'K', 0, -1);
        board[1][0] = new Piece('w', 'R', 0, -1);

        board[4][4] = new Piece('w', 'R', 0, -1);

        board[4][4] = new Piece('w', 'p', 0, -1);
        board[5][1] = new Piece('w', 'B', 0, -1);
        board[3][3] = new Piece('w', 'N', 0, -1);
        board[2][3] = new Piece('w', 'p', 0, -1);

        board[0][4] = new Piece('b', 'K', 0, -1);
        board[0][2] = new Piece('b', 'Q', 0, -1);

    }

    public static void initBoard7(Piece[][] board) {

        board[7][4] = new Piece('w', 'K', 0, -1);

        board[0][4] = new Piece('b', 'K', 0, -1);
    }
    public static void initBoard8(Piece[][] board) {
        board[7][4] = new Piece('w', 'K', 0, -1);
        board[3][4] = new Piece('w', 'p', 0, -1);
        board[2][7] = new Piece('w', 'R', 0, -1);
        board[0][7] = new Piece('w', 'R', 0, -1);
        board[6][7] = new Piece('w', 'B', 0, -1);

        board[1][4] = new Piece('b', 'K', 0, -1);
        Piece.blackKing[0] = 1;
        Piece.blackKing[1] = 4;
    }
    public static void initBoard9(Piece[][] board) {
        board[7][4] = new Piece('w', 'K', 0, -1);
        board[1][4] = new Piece('w', 'p', 0, -1);
        board[1][7] = new Piece('w', 'R', 0, -1);
        board[3][3] = new Piece('w' ,'R', 0, -1);

        board[0][4] = new Piece('b', 'K', 0, -1);
    }
    public static void initBoard10(Piece[][] board) {
        board[7][4] = new Piece('w', 'K', 0, -1);
        board[0][7] = new Piece('w', 'R', 0, -1);

        board[3][4] = new Piece('w', 'p', 0, -1);
        board[5][1] = new Piece('w', 'B', 0, -1);
        board[3][3] = new Piece('w', 'N', 0, -1);
        board[2][3] = new Piece('w', 'p', 0, -1);
        board[0][2] = new Piece('w', 'Q', 0, -1);


        board[2][6] = new Piece('b', 'K', 0, -1);
        Piece.blackKing[0] = 2;
        Piece.blackKing[1] = 6;
    }
    public static void initBoard11(Piece[][] board) {
        board[7][4] = new Piece('w', 'K', 0, -1);
        board[7][5] = new Piece('w', 'R', 0, -1);
        board[2][7] = new Piece('w', 'B', 0, -1);
        board[2][5] = new Piece('w', 'N', 0, -1);
        board[1][5] = new Piece('w', 'Q', 0, -1);
        board[7][0] = new Piece('w', 'B', 0, -1);
        board[2][6] = new Piece('b', 'K', 0, -1);
        //board[7][0] = new Piece('b', 'R', 0, -1);
    }

    public static void initSquares(Piece[][] board) {
        setBlack(board, 0, 1);
        setBlack(board, 0, 3);
        setBlack(board, 0, 5);
        setBlack(board, 0, 7);

        setBlack(board, 1, 0);
        setBlack(board, 1, 2);
        setBlack(board, 1, 4);
        setBlack(board, 1, 6);

        setBlack(board, 2, 1);
        setBlack(board, 2, 3);
        setBlack(board, 2, 5);
        setBlack(board, 2, 7);

        setBlack(board, 3, 0);
        setBlack(board, 3, 2);
        setBlack(board, 3, 4);
        setBlack(board, 3, 6);

        setBlack(board, 4, 1);
        setBlack(board, 4, 3);
        setBlack(board, 4, 5);
        setBlack(board, 4, 7);

        setBlack(board, 5, 0);
        setBlack(board, 5, 2);
        setBlack(board, 5, 4);
        setBlack(board, 5, 6);

        setBlack(board, 6, 1);
        setBlack(board, 6, 3);
        setBlack(board, 6, 5);
        setBlack(board, 6, 7);

        setBlack(board, 7, 0);
        setBlack(board, 7, 2);
        setBlack(board, 7, 4);
        setBlack(board, 7, 6);
    }

    public static boolean isOccupied(Piece[][] board, int r, int c) {
        if (board[r][c].color == 'w' || board[r][c].color == 'b') {
            return true;
        }
        return false;
    }
    public static void setBlack(Piece[][] board, int r, int c) {
        if (isOccupied(board, r, c)) {
            return;
        } else {
            board[r][c] = new Piece('*', '*', -1, -1);
        }
    }
    public static boolean isClear(Piece[][] board, int r1, int c1, int r2, int c2) {
        int i = 0;

        if (r1 == r2) {
            if (c1 > c2) {
                for (int c = c1; c > c2; c--, i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (isOccupied(board, r1, c)) {
                        return false;
                    }
                }
            }

            if (c1 < c2) {
                for (int c = c1; c < c2; c++, i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (isOccupied(board, r1, c)) {
                        return false;
                    }
                }
            }
        }

        if (c1 == c2) {

            if (r1 > r2) {
                for (int r = r1; r > r2; r--, i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (isOccupied(board, r, c1)) {
                        return false;
                    }
                }
            }

            if (r1 < r2) {
                // moving piece downwards
                for (int r = r1; r < r2; r++, i++) {
                    if (i == 0) {
                        continue;
                    }
                    if (isOccupied(board, r, c1)) {
                        return false;
                    }
                }
            }
        }

        int dr = Math.abs(r1 - r2);		// change in rows
        int dc = Math.abs(c1 - c2);		// change in columns



        if (dr == dc) {
            // moving diagonally

            if (r1 > r2) {
                // move upwards
                if (c1 > c2) {
                    // upwards and to the left (NW)
                    for (int r = r1, c = c1; r > r2; r--, c--, i++) {
                        if (i == 0) {
                            continue;
                        }
                        if (isOccupied(board, r, c)) {
                            return false;
                        }
                    }
                }

                if (c1 < c2) {
                    // upwards and to the right (NE)
                    for (int r = r1, c = c1; r > r2; r--, c++, i++) {
                        if (i == 0) {
                            continue;
                        }
                        if (isOccupied(board, r, c)) {
                            return false;
                        }
                    }
                }
            }

            if (r1 < r2) {
                // move downwards
                if (c1 > c2) {
                    // downwards and to the left (SW)
                    for (int r = r1, c = c1; r < r2; r++, c--, i++) {
                        if (i == 0) {
                            continue;
                        }
                        if (isOccupied(board, r, c)) {
                            return false;
                        }
                    }
                }

                if (c1 < c2) {
                    // downwards and to the right (SE)
                    for (int r = r1, c = c1; r < r2; r++, c++, i++) {
                        if (i == 0) {
                            continue;
                        }
                        if (isOccupied(board, r, c)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void displayBoard(Piece[][] board) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(board[r][c].toString() + " ");
            }
            System.out.println(8 - r);
        }
        System.out.println(" a  b  c  d  e  f  g  h");
    }

    public static void printBoard(Piece[][] board) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(r + "," + c + ":" + board[r][c].toString() + " ");
            }
            System.out.println();
        }
    }

}
