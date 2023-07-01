import java.util.Random;

public class WordGame {

    // Create private 2D array that hold letters
    private char[][] words;

    //A private 2D array of booleans to indicate if each cell has been revealed.
    private boolean[][] revealed;

   /*A method fillBoard which randomly puts pairs of letters into the 2D
array of characters.*/

    public void printInstructions() {
        System.out.println("Welcome to the Word Game!");
        System.out.println("The objective of the game is to find matching pairs of letters.");
        System.out.println("You will select two positions on the board to reveal the letters.");
        System.out.println("If the letters match, they will remain revealed (You will gain 10 points). Otherwise, they will be hidden again (You will lose 5 points).");
        System.out.println("Keep revealing pairs until all letters are matched.");
        System.out.println("Have fun and enjoy the game!");
    }


    public void fillBoard() {

        char letters = 'A';
        int board = words.length;
        Random abc = new Random();
        int x = abc.nextInt(board); // .nextInt() = generating new random integer!
        int y = abc.nextInt(board);
        int fill = 0;

        for (int i =0; i <board*board; i++){

            do {
                x = abc.nextInt(board);
                y = abc.nextInt(board);
            }
            while ( words[x][y] != '\u0000');// It will end the loop when is = '\u0000'

            words[x][y] = letters;
            if(fill==0){
                fill = 1;
            }
            else{

                fill =0;
                //Update the character you are placing to the next character
                letters++;

            }

        }



    }

    public void printBoard() {
        System.out.print("  ");
        for(int i =0;i<words.length;i++){
            System.out.print(i);

        }
        System.out.println();

        System.out.print("  ");
        for(int i =0;i<words.length;i++){
            System.out.print("-");
        }
        System.out.println();

        for (int i =0;i<words.length;i++){
            System.out.print(i+"|");
            for(int j =0;j<words[0].length;j++)
            {
                if (revealed[i][j]){
                   //show
                   System.out.print(words[i][j]);
                }
                else{
                    System.out.print('+');
                }
            }
            System.out.println();
        }

    }

    //Default Constructor
    public WordGame(){
        words = new char[0][0];
        revealed = new boolean[0][0];
    }


    // Create constructor
    public WordGame(int deimension) {

        if ((deimension % 2) != 0) {
            System.out.println("Dimension must be even");
            return;
        }
        else{
            words = new char[deimension][deimension];
            revealed= new boolean[deimension][deimension];
            fillBoard();
        }



    }
    // Why I have to return? The constructer should not have a return type.

    public void showPosition(int row, int column){

        revealed[row][column] = true;
    }

    public void hidePosition(int row_h, int column_d){

        revealed[row_h][column_d] = false;
    }

    public boolean allRevealed(){
        for (boolean[] cell :revealed )
        {
            for(boolean value: cell){
              if(value==false){
                  return false;
              }
            }
        }

        return  true;
    }

    public boolean match(int x, int y, int x1, int y1){

        if(words[x][y]==words[x1][y1]){
            return true;
        }
        else {
            return false;
        }
    }

}









