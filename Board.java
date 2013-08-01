/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Board Object
 *  Contains pieces.  Has functions for printing board, setting pieces, 
 *  etc.
 * 
 * 
 * @author jkwong
 */
public class Board {    
    char [] grid = new char[9];
    // default constructor
    Board(){
        // creat blank board
        for (int i = 0; i < 9; i++){
            grid[i] = ' '; // space
        }
    }
    
    public void Print(){
//        Indices:
//        0 1 2
//        3 4 5
//        6 7 8
        System.out.println("-------");
        for (int i = 0; i < 3; i++){
            System.out.println("|" + String.valueOf(grid[i*3]) + "|" +  String.valueOf(grid[i*3+1]) + "|" + String.valueOf(grid[i*3+2]) + "|");
//            System.out.println(grid[i*3] +  grid[i*3+1] + grid[i*3+2]);
            System.out.println("-------");
        }
    }
    
    public boolean CheckMove(int move){
        System.out.println(grid[move]);
        return(grid[move] == ' ');
    }
    
    
    public boolean SetMove(int move, char marker){
        if (CheckMove(move)){
            grid[move] = marker;
            return(true);
        } else {
            System.out.println("Move Invalid.");
            return(false);
        }
    }
    public boolean[] FindMoves(){
        boolean [] moves = {false, false, false, false, false, false, false, false, false};
        for (int i = 0; i < 9; i++){
            if (grid[i] == ' '){
                moves[i] = true;
            }
        }
        return(moves);
    }
    // checks to see if the game has ended
    // returns ' ' if not over
    // returns char of winner player
    // returns '0' if game has ended with a tie
    public char EndGame(){
        char status;
        // Check if the board is full
        boolean temp = true;
        for (int i = 0; i < 9; i++){
            temp = temp & (grid[i] != ' ');
        }
        if (temp){
            return('0');
        }
        
        // check horizontals
        for (int i = 0; i < 3; i++){
            if (grid[i*3] != ' '){
                if ( (grid[i*3] == grid[i*3+1]) && (grid[i*3+1] == grid[i*3+2])){
                    status = grid[i*3];
                    return(status);
                }
            }
        }
        // check verticals
        for (int i = 0; i < 3; i++){
            if (grid[i] != ' '){
                if ( (grid[i] == grid[i+3]) && (grid[i+3] == grid[i+6])){
                    status = grid[i];
                    return(status);
                }
            }
        }
        // check diagonals
        if (grid[4] != ' '){
            if ( (grid[0] == grid[4]) && (grid[4] == grid[8])){
                status = grid[4];
                return(status);
            }
            if ( (grid[2] == grid[4]) && (grid[4] == grid[6])){
                status = grid[4];
                return(status);
            }
        }
        // game is not over yet
        return(' ');
        
    }
    
    
}
