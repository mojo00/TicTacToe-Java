/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Game class
 * 
 * Sets up and runs game.  Creating an instance of this will automatically
 * setup game and start it.
 * 
 * @author jkwong
 */
import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    Board b;
    
    Game(){
        
        // main for loop for game
        while (true){
            // define players
            System.out.println("Tic Tac Toe");
            System.out.println("Select player 1 type (0 - human, 1 = cpu): ");
            Scanner userInput = new Scanner(System.in);
            int playerType = Integer.parseInt(userInput.nextLine());
//            int playerType = userInput.nextInt();

            System.out.println(playerType);
            if (playerType == 0){
                player1 = new HumanPlayer("Player 1 - Human", 'x');
            } else {
                player1 = new CPUPlayer("Player 1 - CPU", 'x');
            }
            System.out.println("Select player 2 type (0 - human, 1 = cpu): ");
            playerType = Integer.parseInt(userInput.nextLine());
//            playerType = userInput.nextInt();
            if (playerType == 0){
                player2 = new HumanPlayer("Player 2 - Human", 'o');
            } else {
                player2 = new CPUPlayer("Player 2 - CPU", 'o');
            }
            
            // create a blank board
            b = new Board();
            int m;
            
            // start main game loop
            
            System.out.println("Starting Game");
            char status = ' ';
            while (true){
                // get move from player 1
                System.out.println("Player 1 Turne");
                m = player1.GetMove(b);
                b.SetMove(m, player1.GetMarker());
                b.Print();
                status = b.EndGame();
                if (status != ' '){
                    break;
                }
                System.out.println("Player 2 Turne");
                m = player2.GetMove(b);
                b.SetMove(m, player2.GetMarker());
                b.Print();
                status = b.EndGame();
                if (status != ' '){
                    break;
                }
            }
            // Display end game status
            if (status == '0'){
                System.out.println("Tie game!");
            } else {
                if (status == player1.GetMarker()){
                    System.out.println("Player 1 wins");
                } else {
                    System.out.println("Player 2 wins");           
                }
                
            }
            
            
        
        }
    }
    
    
    
}
