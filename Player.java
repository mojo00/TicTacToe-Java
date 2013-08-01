/**
 *  Player Interface
 * 
 * @author J Kwong
 */

interface Player{
    
    public void SetMarker(char marker);
    public char GetMarker();
    public void SetName();
    public int GetMove(Board b);
    
    
}