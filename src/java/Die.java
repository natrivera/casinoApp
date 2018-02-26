import java.security.SecureRandom;

public class Die {
    private int value;
    private SecureRandom randomNumbers = new SecureRandom();
    private String imageURL;
    
    public Die(){
        
    }
    
    //gets a random number from 1 to 6
    public void roll(){
        value = 1 + randomNumbers.nextInt(6);
        imageURL = "img/" + value + ".jpg";
    }
    
    //returns rolled value
    public int getValue(){
        return value;
    }
    
    //returns image
    public String getImageURL(){
        return imageURL;
    }
}
