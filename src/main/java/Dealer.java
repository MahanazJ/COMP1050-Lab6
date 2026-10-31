import java.util.*;
public class Dealer {
    private final ArrayList<Card> hand=new ArrayList<>();
    public void addCard(Card card) { hand.add(Objects.requireNonNull(card)); }
    public List<Card> getHand() { return Collections.unmodifiableList(hand); }
    public int getHandTotal() {
        int total=0,aces=0;
        for(Card card:hand) { total+=card.getValue(); if(card.getRank().equalsIgnoreCase("Ace")||card.getRank().equalsIgnoreCase("A")) aces++; }
        while(total>21 && aces-->0) total-=10;
        return total;
    }
    public boolean shouldHit() { return getHandTotal()<17; }
}
