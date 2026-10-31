public class Card {
    private final String rank;
    private final String suit;
    public Card(String rank, String suit) { this.rank=rank; this.suit=suit; }
    public String getRank() { return rank; }
    public String getSuit() { return suit; }
    public int getValue() {
        if (rank.equalsIgnoreCase("Ace") || rank.equalsIgnoreCase("A")) return 11;
        if (rank.equalsIgnoreCase("Jack") || rank.equalsIgnoreCase("Queen") || rank.equalsIgnoreCase("King") || rank.equalsIgnoreCase("J") || rank.equalsIgnoreCase("Q") || rank.equalsIgnoreCase("K")) return 10;
        return Integer.parseInt(rank);
    }
    @Override public String toString() { return rank+" of "+suit; }
}
