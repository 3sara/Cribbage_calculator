import java.util.Arrays;

public class Hand {
    private final Card[] cards;

    Hand (Card[] cards) throws Exception {
        if (cards.length != 5) {
            throw new Exception("You should specify exactly 5 cards (characters pairs composed by rank and suit)");
        }

        this.cards = cards;
    }

    Hand (String hand) throws Exception {
        if (hand.length() != 10) {
            throw new Exception("You should specify exactly 5 cards (characters pairs composed by rank and suit)");
        }

        Card[] cards = new Card[5];

        for (int i = 0; i < hand.length(); i += 2) {
            cards[i/2] = new Card(hand.substring(i, i+2));
        }

        this.cards = cards;
    }

    public int[] sorted(){
        int[] enumerate = new int[5];
        for (int i = 0; i < 5; i++) {
            enumerate[i] = cards[i].getEnumeratedRank();
        }
        Arrays.sort(enumerate);

        return enumerate;
    }

    public Card getCard(int index) {
        return cards[index];
    }

    public Card[] getHand() {
        return cards;
    }
}
