import javafx.beans.property.StringProperty;

public class Card
{
    private int rank;
    private int suit;

    /**
     * Creates a new card.
     * @param rank this is an int representation of the rank of a card. eg - ace, two, king, ten....
     * @param suit this is an int representation of the suit of a card. eg - diamonds, spades....
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Creates a new card with only a card number.
     * @param cardno integer representation which will be converted to get a rank and a suit. eg 0 = 2 of clubs, 14 = 3 of diamonds
     */
    public Card(int cardno) {
        rank = cardno % 13;
        suit = (cardno/13) % 4;
    }

    /**
     * Returns the rank of the card.
     * @return rank
     */
    public int rank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     * @return suit
     */
    public int suit() {
        return suit;
    }

    /**
     * Checks if the caller card has the same suit as the parameter card.
     * @param c is the Card object
     * @return boolean value
     */
    public boolean sameSuit(Card c) {
        return (this.suit == c.suit);
    }

    /**
     * Checks if the caller card has the same rank as the parameter card.
     * @param c is the Card object
     * @return boolean value
     */
    public boolean sameRank(Card c) {
        return (this.rank == c.rank);
    }

    /**
     * Checks if the caller card is the same as the parameter card.
     * @param c is the Card object
     * @return boolean value
     */
    public boolean sameCard(Card c) {
        return (this.sameRank(c) && this.sameSuit(c));
    }

    /**
     * Returns the difference between the ranks of 2 cards.
     * @param c is the Card object
     * @return an int
     */
    public int rankDiff(Card c) {
        return (this.rank - c.rank);
    }

    /**
     * Whenever System.out.print() is called this method is fired. This method maps the rank and suit to
     * the representation that has to be printed and concatenates them into a String to return.
     * @return a String
     */
    @Override
    public String toString() {
        String ranks = "23456789TJKQA";
        String suits = "\u2663\u2666\u2665\u2660";
        return ranks.charAt(rank) + "" + suits.charAt(suit);
    }
}
