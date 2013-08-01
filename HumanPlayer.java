/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Human player class implements from Player class.
 * 
 * @author jkwong
 */
import java.util.Scanner;


public class HumanPlayer implements Player{
    
    String name;
    char marker;
    int playerType;
    
    HumanPlayer(String name, char marker){
        this.name = name;
        this.marker = marker;
        this.playerType = 1;
    }
    
    public void SetMarker(char marker){
        // sets marker; not user settable because always either x or o
        this.marker = marker;
    }
    public char GetMarker(){
        return(marker);
    }
    public void SetName(){
        Scanner userInput = new Scanner(System.in);
        this.name = userInput.next();
    }
    
    public int GetMove(Board b){
        int move = 0;
        System.out.println("Enter Move >");
        Scanner userInput = new Scanner(System.in);

        while (true){
            String temp = userInput.nextLine();
            System.out.println("asdf");
            move = Integer.parseInt(temp);
            // move = userInput.nextInt();
            if (b.CheckMove(move)){ // see if move is possible
                break;
            } else {
                System.out.println("Move invalid.");
            }
        }
        return(move);
    }
}
