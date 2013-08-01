/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  CPU player class.  Implements Player interface.
 *  Does not find best move.  Chooses random move.
 * 
 * 
 * @author jkwong
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class CPUPlayer implements Player{
    
    String name;
    char marker;
    int playerType;
    
    CPUPlayer(String name, char marker){
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
        // get all possible moves
        boolean [] possibleMovesMask = b.FindMoves();
//        possibleMovesMask = b.FindMoves();
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        // get an ArrayList of possible moves;
        for (int i = 0; i< 8; i++){
            if (possibleMovesMask[i]){
                possibleMoves.add(i);
            }
        }
        // For now the cpu just chooses a random move
        Random randGenerator = new Random();
        System.out.println(possibleMoves.size());
        int index = randGenerator.nextInt(possibleMoves.size());
        return(possibleMoves.get(index));
    }
}
