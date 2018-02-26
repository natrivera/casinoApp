public class CrapsModel {
    private int point;
    
    public CrapsModel(){
        
    }

    //returns point variable
    public int getPoint() {
        return point;
    }

    //setter for point variable
    public void setPoint(int point) {
        this.point = point;
    }
    
    //method that is used for first roll when a player first clicks Play, it returns a string message stating wheter they won, lost, or continue to second phase of craps
    public String firstRoll(Die die1, Die die2){
        String message = "";
        die1.roll();
        die2.roll();
        
        int sumOfDice = die1.getValue() + die2.getValue();
        
        switch(sumOfDice)
        {
            case 7: 
            case 11:
               message = "won";
               break;
            case 2:
            case 3:
            case 12:
                message = "lost";
                break;
            default:
                point = sumOfDice;
                message = "continue";
                break;                
        }
        
        return message;
    }
    
    //method that gets used if the player lands a number 4,5,6,8,9,10, it rolls the dice again returning a message depending on wheter they won, lost, or got another number other than the point
    //if the point the player rolled is rolled again, the player wins the game
    //if the player rolls a 7, the player loses the game, otherwise the player keeps rolling until one of those two conditions are made
    public String rollAgain(Die die1, Die die2){
        String message = "";
        die1.roll();
        die2.roll();
        
        int sumOfDice = die1.getValue() + die2.getValue();
        
        if(sumOfDice == point){
            message = "won";
        }
        else if(sumOfDice == 7){
            message = "lost";
        }
        else{
            message = "continue";
        }
        
        return message;
    }
}
