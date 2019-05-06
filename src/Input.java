import java.util.*;
public class Input {

    public static ArrayList<String> entryCode = new ArrayList<String>();

    public static final int reverse [] = {7,6,5,4,3,2,1,0};

    public static char promo = 'Q';
    public static void readEntry(char p){
        int counter = 0;
        Scanner in = new Scanner(System.in);
        String entry = in.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(entry);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(counter == 0){

                if(token.equals("draw") || token.equals("resign")){
                    entryCode.add(token);
                }
                else{
                    fileRank(token, p);
                }
            }
            if(counter == 1){
                fileRank(token, p);
            }
            if(counter == 2){
                if(token.equals("draw?")){
                    entryCode.add(token);
                }
                else if(token.equals("N") || token.equals("B") || token.equals("R") || token.equals("Q")){
                    entryCode.add(token);
                }
                else{
                    if(p == 'w'){
                        System.out.print("Illegal move, try again\nWhite's move: ");
                    }
                    else{
                        System.out.print("Illegal move, try again\nBlack's move: ");
                    }
                    entryCode.clear();
                }
            }
            if(counter == 3){
                if(token.equals("draw?")){
                    entryCode.add(token);
                }
                else{

                }
            }
            if(counter > 3){//max 4 tokens allowed so it is an error
                entryCode.clear();
            }

            counter++;
        }//end of while
        if(entryCode.size()==1 && !(entryCode.get(0).equals("draw") || entryCode.get(0).equals("resign"))){//only one file rank entered, that is invalid, prompt the user again
            if (counter == 1){
                fileRank("false",p);
            }
            entryCode.clear();//can't have only one FileRank
        }
    }

    public static void fileRank(String token, char p){
        StringBuilder sB = new StringBuilder();
        StringBuilder sBreversed = new StringBuilder();

        for(int i=0; i<token.toString().length(); i++){
            int ascii = String.valueOf(token.toString().charAt(i)).codePointAt(0);
            if(ascii>96 && ascii<105 && i == 0){//letters
                sB.append(Integer.toString(ascii-97));
            }
            else if(ascii>48 && ascii<57 && i == 1){//numbers

                sB.append(Integer.toString(reverse[ascii-49]));
                sBreversed.append(sB.charAt(1));
                sBreversed.append(sB.charAt(0));
                entryCode.add(sBreversed.toString());
            }
            else {
                if(p == 'w'){
                    System.out.print("Illegal move, try again\nWhite's move: ");
                }
                else{
                    System.out.print("Illegal move, try again\nBlack's move: ");
                }
                break;
            }
        }
    }

    public static int callMove(Piece[][] board, char p, int i) {
        int ret=-1;

        while(entryCode.isEmpty()){
            Input.readEntry(p);
        }
        if(entryCode.get(0).equals("resign")){//resign
            if(p=='w'){
                System.out.println("Black wins");
                System.exit(0);
            }
            else{
                System.out.println("White wins");
                System.exit(0);
            }
        }
        else if(entryCode.get(0).equals("draw")){//draw offered
            System.out.println("Draw");
            System.exit(0);
        }
        else if(entryCode.size()==3){

            if(entryCode.get(2).charAt(0)=='N'){//check promotion
                promo = 'N';
                ret = moveIt(board, p, i);
                promo = 'Q';
            }
            else if(entryCode.get(2).charAt(0)=='Q'){
                promo = 'Q';
                ret = moveIt(board, p, i);
                promo = 'Q';
            }
            else if(entryCode.get(2).charAt(0)=='R'){
                promo = 'R';
                ret = moveIt(board, p, i);
                promo = 'Q';
            }
            else if(entryCode.get(2).charAt(0)=='B'){
                promo = 'B';
                ret = moveIt(board, p, i);
                promo = 'Q';
            }
            else if(entryCode.get(2).equals("draw?")){
                ret = moveIt(board, p, i);
            }
            else{

            }
        }
        else{
            ret = moveIt(board, p, i);
        }
        return ret;
    }

    public static int moveIt(Piece[][] board, char p, int i){
        //check if entryCode is empty
        int ret;
        int r1 = Character.getNumericValue(entryCode.get(0).charAt(0));
        int c1 = Character.getNumericValue(entryCode.get(0).charAt(1));
        int r2 = Character.getNumericValue(entryCode.get(1).charAt(0));
        int c2 = Character.getNumericValue(entryCode.get(1).charAt(1));
        ret = Move.move(board, p, r1, c1, r2, c2, i);
        entryCode.clear();
        return ret;
    }
}
