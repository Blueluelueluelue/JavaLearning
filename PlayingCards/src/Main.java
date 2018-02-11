import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        Random gen = new Random();
        Card c = new Card(gen.nextInt(52));
        Card c1 = new Card(gen.nextInt(52));

        System.out.print("2 Random cards: ");
        System.out.printf("%s ",c);
        System.out.println(c1);

        System.out.println("Same Suit?: " + c.sameSuit(c1));
        System.out.println("Same Rank?: " + c.sameRank(c1));
        System.out.println("Same Card?: " + c.sameCard(c1));

    }
}
