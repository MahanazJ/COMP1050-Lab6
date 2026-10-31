import java.util.*;
public class Player {
     private final ArrayList<Card> hand;
    private boolean standing;
    // TODO 1: Create an ArrayList<Card> to store this player's hand.
    // TODO 2: Add a boolean field to track whether the player has stood.
    public Player() { 
        hand = new ArrayList<>();
        standing = false;
        // TODO 3: Initialize the player's fields if needed.
    }
    public void addCard(Card card) {
        // TODO 4: Add the supplied card to the hand.
          hand.add(Objects.requireNonNull(card));
    
    }
    public List<Card> getHand() {
        // TODO 5: Return the player's hand (a copy or unmodifiable view is recommended).
          return Collections.unmodifiableList(hand);
    }
    public int getHandTotal() {
        
        // TODO 6: Add card values. Treat Aces as 11, then reduce by 10 for each Ace needed to avoid busting.
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            total += card.getValue();

            if (card.getRank().equalsIgnoreCase("Ace")
                    || card.getRank().equalsIgnoreCase("A")) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    
    public void hit(Deck deck) {
       
        // TODO 7: Draw a card from the deck and add it to the hand.
     addCard(deck.dealCard());
    

    }

    public void stand() {

        // TODO 8: Mark the player as standing.
        standing = true;
    }
    public boolean isStanding() {
        // TODO 9: Return whether the player has stood.
        return standing;
    }
    public boolean isBust() {
        // TODO 10: Return true when the total exceeds 21.
         return getHandTotal() > 21;
    }
}
