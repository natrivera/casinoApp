public class Card 
{
   private final String face; // face of card
   private final String suit; // suit of card
   
   Card() {
   
       face = "i";
       suit = "";
   }

   // constructor
   public Card(String cardFace, String cardSuit)
   {
      face = cardFace; // initialize face of card
      suit = cardSuit; // initialize suit of card
   } 

   // return card face
   public String getFace()
   {
      return face;
   } 

   // return card suit
   public String getSuit()
   {
      return suit;
   }

   // return String representation of Card
   public String toString() 
   { 
       if(face.equals("i")) {
       
           return face;
       } else {
      
           return face + " of " + suit;
           
       }
      
   } 

} // end class Card
