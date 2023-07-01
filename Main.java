import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int board;
        String instruction;
        Scanner scan;
        scan = new Scanner(System.in);
        WordGame into = new WordGame();

//        long time = System.currentTimeMillis();
//
//        long sec = time/1000;
//
//        double second = Math.round(sec*100)/100;


        System.out.println("Do you want an instruction? (Enter Yes or No)");
        instruction = scan.next();

        if (instruction.equalsIgnoreCase("Yes")){
            into.printInstructions();
        } else if (instruction.equalsIgnoreCase("No")){
            System.out.println("Great, let's get start!");
        }


        System.out.println("How big of a board (Enter an even number)?");
        board = scan.nextInt();
        WordGame object = new WordGame(board); // Define that it's even or not
        object.printBoard();

        int r;
        int c;

        int r2=0;
        int c2=0;

        int playerturn =0;

        int score =0;


        do {
            System.out.println("Enter First Row");
            Scanner row = new Scanner(System.in);
            r = row.nextInt();
            System.out.println("Enter First Column");
            Scanner column = new Scanner(System.in);
            c = column.nextInt();
            if (r > board || c> board){
                System.out.println("Please enter number 0 or less than "+ board);
            }
             else{
                 object.showPosition(r,c);
                 if(playerturn==0){
                     // This is the player first picked!
                     // Store the player's choice for future
                     r2 = r;
                     c2 = c;
                     playerturn = 1;
                     // It will alternate b/t the if block (39-41) and the else if block(47-54) every single time it has to make a decision (line 36)

                 } else if (playerturn==1)
                 {
                     //This player second picked!
                     playerturn = 0;

                     if(object.match(r,c,r2,c2)){
                         // The two picked match was success!
                         score+=10;
                     } else{
                         object.hidePosition(r,c);
                         object.hidePosition(r2,c2);
                         score-=5;
                     }

                 }

              object.printBoard();
            }

        } while ( !(object.allRevealed())); // it will keep running as long as it's true!

     System.out.println("Your score: " +score);
     if (score>0){
         System.out.println("Congrats, you win this game!!!");
     }else{
         System.out.println("Your score is below zero, but nice try!");
     }


//     System.out.println("Duration: " + second + " seconds");

    }
}