public class Card {
    private final String rank;
    private final String suit;
    private final int points;
    private final int enumeratedRank;

    public Card(String rank, String suit, int points, int enumeratedRank) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
        this.enumeratedRank = enumeratedRank;
    }

    public Card(String card) {
        this.rank           = card.substring(0, 1);
        this.suit           = card.substring(1, 2);
        this.points         = convertRank(this.rank);
        this.enumeratedRank = convertEnumerate(this.rank);
    }

    private int convertRank(String rank){
        return switch (rank){
            case "A" -> 1;
            case "0", "J", "Q", "K" -> 10;
            default -> Integer.parseInt(rank);
        };
    }

    private int convertEnumerate(String rank){
        return switch (rank){
            case "A" -> 0;
            case "0" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(rank);
        };
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoints() {
        return points;
    }

    public int getEnumeratedRank() {
        return enumeratedRank;
    }
}
