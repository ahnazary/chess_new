public class Conditions {

    public static int[] attacker = {-1, -1};

    public static boolean isCheck(Piece[][] board, char p, int counter) {
        int kr;
        int kc;
        char oppC;
        if (p == 'w') {
            kr = Piece.whiteKing[0];
            kc = Piece.whiteKing[1];
            oppC = 'b';
        } else {
            kr = Piece.blackKing[0];
            kc = Piece.blackKing[1];
            oppC = 'w';
        }

        boolean kingAttacked = false;

        // now kr and kc hold king's row and column, see if any pieces of color oppC attack (kr, kc)
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c].color == oppC) {
                    // opponent's piece
                    if (board[r][c].name == 'K') {
                        continue;
                    }
                    if (Move.movePiece(board, oppC, r, c, kr, kc, counter)) {
                        // can move to (kr, kc)
                        kingAttacked = true;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }

        if (kingAttacked) {
            return true;
        } else {
            // no pieces can target king, not check but may not have any moves left
            return false;
        }
    }
    public static boolean isCheckmate(Piece[][] board, char p, int kr, int kc, int counter) {
        //see if p's own pieces can take out attacker

        if (isFree(board, p, kr, kc, counter)){
            // King still has a square to go to, not checkmate
            return false;
        }
        else if (canCapture(board, p, attacker)){
            // can capture attacking piece with own piece, not checkmate
            return false;
        }
        else if (board[attacker[0]][attacker[1]].name == 'N') {
            // attacker is Knight (cannot be blocked)
            return true;
        }
        else if (canBlock(board, p, kr, kc, attacker)){
            // can move piece between king and attacker to block attack, not checkmate
            return false;
        }
        else {
            return true;//it is checkMate
        }
    }
    public static boolean canBlock(Piece[][] board, char p, int kr, int kc, int[] attacker) {
        int ar = attacker[0];
        int ac = attacker[1];

        if (ar == kr) {
            //attacker is in same row (left or right) of king

            if (ac < kc) {
                // rook/queen is to left of king

                for (int c = kc; c > ac; c--) {

                    int[] target = {ar, c};

                    if (canCapture(board, p, target)) {
                        // own piece can move to target
                        return true;
                    }
                }

                return false;
            } else {
                // rook/queen is to right of king

                for (int c = kc; c < ac; c++) {

                    int[] target = {ar, c};

                    if (canCapture(board, p, target)) {
                        // own piece can move to target
                        return true;
                    }
                }
            }
        }
        else if (ac == kc) {
            // attacker is in same column (up or down) of king

            if (ar < kr) {
                // rook/queen is above king

                for (int r = kr; r > ar; r--) {

                    int[] target = {r, ac};

                    if (canCapture(board, p, target)) {
                        // own piece can move to target
                        return true;
                    }
                }

                return false;
            } else { // rook/queen is below king
                for (int r = kr; r < ar; r++) {

                    int[] target = {r, ac};

                    if (canCapture(board, p, target)) {
                        // own piece can move to target
                        return true;
                    }
                }

                return false;
            }
        }
        else {
            // attacker is diagonal from King, not same row or column
            if (ar < kr) {
                // attacker is N of King
                if (ac < kc) {
                    // attacker is NW of King

                    for (int r = kr, c = kc; r > ar; r--, c--) {
                        int[] target = {r, c};

                        if (canCapture(board, p, target)) {
                            // own piece can move to target
                            return true;
                        }
                    }
                } else {
                    // attacker is NE of King

                    for (int r = kr, c = kc; r < ar; r--, c++) {
                        int[] target = {r, c};

                        if (canCapture(board, p, target)) {
                            // own piece can move to target
                            return true;
                        }
                    }
                }
            } else {
                // attacker is S of King
                if (ac < kc) {
                    // attacker is SW of King

                    for (int r = kr, c = kc; r < ar; r++, c--) {
                        int[] target = {r, c};

                        if (canCapture(board, p, target)) {
                            // own piece can move to target
                            return true;
                        }
                    }
                } else {
                    // attacker is SE of King

                    for (int r = kr, c = kc; r > ar; r++, c++) {
                        int[] target = {r, c};

                        if (canCapture(board, p, target)) {
                            // own piece can move to target
                            return true;
                        }
                    }
                }
            }
        }


        return false;
    }

    public static boolean canCapture(Piece[][] board, char p, int [] attacker){
        int r = attacker[0];
        int c = attacker[1];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Board.isOccupied(board, i, j) && (board[i][j].color == p)){//check board if empty, add same color as the attacked King
                    //let's see if we can take out the attacker with one of our piece
                    if (Move.movePiece(board, p, i, j, r, c, -200)) {
                        // can move to attacker's square
                        return true;
                    }
                }//end of main if
            }//end of 2nd loop
        }//end of 1st loop
        return false;
    }

    public static boolean isUnderAttack(Piece[][] board, char p, int r, int c, int counter) {
        char oppColor = 0;

        if (p == 'w') {
            oppColor = 'b';
        } else if (p == 'b') {
            oppColor = 'w';
        } else {
            System.exit(0);
        }

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].color == oppColor){
                    if (board[i][j].name == 'p'){
                        if(Move.movePawn(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                    else if (board[i][j].name == 'N'){
                        if(Move.moveKnight(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                    else if (board[i][j].name == 'B'){
                        if(Move.moveBishop(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                    else if (board[i][j].name == 'R'){
                        if(Move.moveRook(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                    else if (board[i][j].name == 'Q'){
                        if(Move.moveQueen(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                    else if (board[i][j].name == 'K'){
                        if(Move.moveKing(board, oppColor, i, j, r, c, counter)>0){
                            attacker [0] = i;
                            attacker [1] = j;
                            return true;
                        }
                    }
                }
            }//end of 2nd for
        }//end of 1st for

        return false;
    }

    public static boolean isFree(Piece[][] board, char p, int kr, int kc, int counter){
        boolean option1 = false, option2 = false, option3 = false, option4 = false,
                option5 = false, option6 = false, option7 = false, option8 = false;

        Piece king = board[kr][kc];
        board[kr][kc] = new Piece(' ', ' ', 0, -1);//take the king out
        //below king
        if (coordinateValid(kr+1, kc)){
            if (!(Conditions.isUnderAttack(board, p, kr+1, kc, counter))
                    && (occupiedByOwnPiece(board, p, kr+1, kc))){//if not under attack and not occupied by own piece
                option1=true;
            }
        }
        //above king
        if (coordinateValid(kr-1, kc)){//if coordinate is valid
            if (!(Conditions.isUnderAttack(board, p, kr-1, kc, counter))
                    && (occupiedByOwnPiece(board, p, kr-1, kc))){//if not under attack and not occupied by own piece
                option2=true;
            }
        }
        //below right of king
        if (coordinateValid(kr+1, kc+1)){
            if (!(Conditions.isUnderAttack(board, p, kr+1, kc+1, counter))
                    && (occupiedByOwnPiece(board, p, kr+1, kc+1))){//if not under attack and not occupied by own piece
                option3=true;
            }
        }
        //above right of king
        if (coordinateValid(kr-1, kc+1)){
            if (!(Conditions.isUnderAttack(board, p, kr-1, kc+1, counter))
                    && (occupiedByOwnPiece(board, p, kr-1, kc+1))){//if not under attack and not occupied by own piece
                option4=true;
            }
        }
        //below left of king
        if (coordinateValid(kr+1, kc-1)){
            if (!(Conditions.isUnderAttack(board, p, kr+1, kc-1, counter))
                    && (occupiedByOwnPiece(board, p, kr+1, kc-1))){//if not under attack and not occupied by own piece
                option5=true;
            }
        }
        if (coordinateValid(kr-1, kc-1)){
            if (!(Conditions.isUnderAttack(board, p, kr-1, kc-1, counter))
                    && (occupiedByOwnPiece(board, p, kr-1, kc-1))){//if not under attack and not occupied by own piece
                option6=true;
            }
        }
        if (coordinateValid(kr, kc+1)){
            if (!(Conditions.isUnderAttack(board, p, kr, kc+1, counter))
                    && (occupiedByOwnPiece(board, p, kr, kc+1))){//if not under attack and not occupied by own piece
                option7=true;
            }
        }
        if (coordinateValid(kr, kc-1)){
            if (!(Conditions.isUnderAttack(board, p, kr, kc-1, counter))
                    && (occupiedByOwnPiece(board, p, kr, kc-1))){//if not under attack and not occupied by own piece
                option8=true;
            }
        }
        if (option1 || option2 || option3 || option4 || option5 || option6 || option7 || option8){
            board[kr][kc] = king; // put king back
            return true;
        }
        board[kr][kc] = king; // put king back
        return false;
    }
    public static boolean coordinateValid(int kr, int kc){
        if (kr < 0 || kr > 7) {
            return false;
        }
        if (kc < 0 || kc > 7) {
            return false;
        }
        return true;
    }

    public static boolean occupiedByOwnPiece(Piece[][] board, char p, int kr, int kc){
        if (Board.isOccupied(board, kr, kc)) {// destination is occupied
            if (board[kr][kc].color == p) {// occupied by own color
                return false;
            }
        }
        return true;
    }
    public static boolean isStalemate(Piece[][] board, char p, int i) {

        boolean haveMove = false;

        for (int r1 = 0; r1 < 8; r1++) {
            for (int c1 = 0; c1 < 8; c1++) {
                if (board[r1][c1].color == p) {
                    for (int r2 = 0; r2 < 8; r2++) {
                        for (int c2 = 0; c2 < 8; c2++) {
                            if (Move.movePiece(board, p, r1, c1, r2, c2, i)) {
                                haveMove = true;
                            } else {
                                continue;
                            }
                        }
                    }

                } else {
                    continue;
                }
            }
        }

        if (haveMove == true) {
            return false;
        } else {
            return true;
        }
    }
}
