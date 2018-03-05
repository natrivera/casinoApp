import java.util.ArrayList;
import java.util.Random;

public class Deck
{
   private static final String[] faces = 
      { "Deuce", "Three", "Four", "Five", "Six", 
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" , "Ace"};
   private static final String[] suits = 
      {"Hearts", "Diamonds", "Clubs", "Spades"};
   
   private String message;

   // random number generator
   private static final Random randomNumbers = new Random(); 
   private static final int NUMBER_OF_CARDS = 52; // constant number of cards

   private Card[] deck; // array of Card objects
   private int currentCard; // the index of next Card to be dealt
   private int score;

    public int getScore()
    {
        return score;
    }

   // constructor fills deck of cards
   public Deck()
   {
      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // initialize currentCard 

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++) 
         deck[count] = 
            new Card(faces[count % 13], suits[count / 13]);
   } 
   

    public Card[] getDeck()
    {
        return deck;
    }

   // shuffle deck of cards with one-pass algorithm
   public void shuffle()
   {
      currentCard = 0; // reinitialize currentCard

      // for each card, pick another random card and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 
   
   public String getBet()
   {    
       return message;
   }

   // deal one card
   public Card dealCard()
   {
      // determine whether cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else        
         return null; // return null to indicate that all cards were dealt
   } 

   // tally the number of each face card in hand
   private int[] totalHand(Card hand[])
   {
      int[] numbers = new int[faces.length]; // store number of face

      // initialize all elements of numbers to zero
      for (int i = 0; i < 13; i++)
         numbers[i] = 0;

      // compare each card in the hand to each element in the faces array
      for (int h = 0; h < hand.length; h++)
      {
         for (int f = 0; f < 13; f++)
         {
            if (hand[h].getFace() == faces[f])
               ++numbers[f];
         } 
      } 

      return numbers;
   } 
   
   //get the highest card 
   public void highCard(Card hand[]) {
       
       ArrayList<Integer> temp = new ArrayList();
       for (int i = 0; i < faces.length; i++) {
       
           for (int j = 0; j < hand.length; j++) {
           
               if(faces[i].equals(hand[j].getFace())) {
               
                   temp.add(i);
                   score = i;
               }
           }
       }
       String facer = faces[temp.get(4)];
       message = "High card " + facer;
   }
   
   public void setSingleCardScore(Card card[]){
      
       ArrayList<Integer> temp = new ArrayList();
       for (int i = 0; i < faces.length; i++) {
       
           for (int j = 0; j < card.length; j++) {
           
               if(faces[i].equals(card[j].getFace())) {
               
                   score = i;
               }
           }
       }
   }

   // determine if hand contains pairs
   public int pairs(Card hand[])
   {
       
      int couples = 0;
      int[] numbers = totalHand(hand);

      // count pairs
      for (int k = 0; k < numbers.length; k++)
      {
            if (numbers[k] == 2) 
            {
               message = String.format("Pair of %ss\n", faces[k]);

               score = 200 + k;
               ++couples;
            } 
        } 

      return couples;
   }

   // determine if hand contains a three of a kind
   public int threeOfAKind(Card hand[])
   {
      int triples = 0;
      int[] numbers = totalHand(hand);
      
      // count three of a kind
      for (int k = 0; k < numbers.length; k++)
      {
         if (numbers[k] == 3) 
         {
             message = String.format("Three %ss\n", faces[k]);
             score = 400 + k;
            ++triples;
            break;
         } 
      } 

      return triples;
   } 

   // determine if hand contains a four of a kind
   public void fourOfAKind(Card hand[])
   {
      int[] numbers = totalHand(hand);

      for (int k = 0; k < faces.length; k++)
      {
         
          
         if (numbers[k] == 4)
         {
            message = String.format("Four %ss\n",  faces[k]);
            score = 1000 + k;
         }
         
          
      } 
   } 

   // determine if hand contains a flush
   public void flush(Card[] hand)
   {
      String theSuit = hand[0].getSuit();

      for (int s = 1; s < hand.length; s++)
      {
         if (hand[s].getSuit() != theSuit)
            return;   // not a flush
      } 

       message = String.format("Flush in %s\n", theSuit);
       score = 600;
    
   } 

   // determine if hand contains a straight
   public void straight(Card[] hand)
   {
      int[] locations = new int[5];
      int z = 0;
      int[] numbers = totalHand(hand);

      for (int y = 0; y < numbers.length; y++)
      {
         if (numbers[y] == 1)
            locations[z++] = y;
      } 

      int faceValue = locations[0];

      if (faceValue == 0) // special case, faceValue is Ace
      {
         faceValue = 13;
  
         for (int m = locations.length - 1; m >= 1; m--) 
         {
            if (faceValue != locations[m] + 1)
               return; // not a straight
            else
               faceValue = locations[m];
         } 
      } 
      else
      {
         for (int m = 1; m < locations.length; m++) 
         {
            if (faceValue != locations[m] - 1)
               return; // not a straight
            else
               faceValue = locations[m];
         } 
      } 

       message = String.format("\nStraight");
       score = 500;
       
   } 

   // determine if hand contains a full house
   public void fullHouse(int couples, int triples)
   {
      if (couples == 1 && triples == 1) 
      {
          message = String.format("\nFull House!");
          score = 700;
          
      }
   } 

   // determine if hand contains two pairs
   public void twoPairs(int couples)
   {
      if (couples == 2) 
      {
          message = String.format("\nTwo Pair!");
          score = score + 100;
          
      }
   } 
} // end class Deck