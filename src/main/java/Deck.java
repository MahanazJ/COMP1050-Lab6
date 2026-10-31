import java.util.*;
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();
    public Deck() {
        String[] suits={"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        for(String suit:suits) for(String rank:ranks) cards.add(new Card(rank,suit));
        shuffle();
    }
    public void shuffle() { Collections.shuffle(cards); }
    public Card dealCard() { if(cards.isEmpty()) throw new IllegalStateException("Deck is empty"); return cards.remove(0); }
    public int remainingCards() { return cards.size(); }
}
