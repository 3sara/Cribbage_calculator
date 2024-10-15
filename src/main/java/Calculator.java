import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) {
        String[] input = args[0].split ("");
        String[] rank = new String[5];
        String[] suite = new String[5];
        for (int i=0; i<10; i=i+2) {
            rank[i/2] = input[i];
            suite[i/2] = input[i+1];
        }

        int[] points = convertRank(rank);
        int fifteenTwosPoints = fifteenTwos(points, 0, 0);
        int runs = runs(rank);
        System.out.println(runs);
        System.out.println(fifteenTwosPoints);
    }

    public static int[] convertRank(String[] rank){
        int[] points = new int[rank.length];
        for (int i=0; i<rank.length; i++) {
            points[i] = switch (rank[i]){
                case "A" -> 1;
                case "0", "J", "Q", "K" -> 10;
                default -> Integer.parseInt(rank[i]);
            };
        }

        return points;
    }

    public static int[] convertEnumerate(String[] rank){
        int[] enumerate = new int[rank.length];
        for (int i=0; i<rank.length; i++) {
            enumerate[i] = switch (rank[i]){
                case "A" -> 0;
                case "0" -> 10;
                case "J" -> 11;
                case "Q" -> 12;
                case "K" -> 13;
                default -> Integer.parseInt(rank[i]);
            };
        }

        return enumerate;
    }

    public static int fifteenTwos(int[] card_points, int start, int current) {
        // 2 or more cards sum to 15
        // Jack, King, Queen = 10
        // Ace = 1
        int point = 0;

        for (int i = start; i< card_points.length; i++) {
            int value = current + card_points[i];
            if (value == 15) point +=2;
            if (value < 15) {
                point += fifteenTwos(card_points, start = i+1, current = value);
            }
        }
        return point;
    }

    public static int runs(String[] rank){
        int points=0;
        int[] enumerate= convertEnumerate(rank);
        Arrays.sort(enumerate);
        int counter=0;
        for (int i=0; i<enumerate.length-1; i++) {
            if (enumerate[i+1]-enumerate[i]==1) counter++;
            else if (enumerate[i+1]==enumerate[i]) continue;
            else counter=0;

            if (counter>2) points=counter;
        }

        return points;
    }
}
