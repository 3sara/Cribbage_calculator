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
        int runsPairsPoints = runsPairs(rank);
        int flush=flush(rank,suite);
        System.out.println("Total Points: " + (fifteenTwosPoints + runsPairsPoints + flush));
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

    public static int runsPairs(String[] rank){
        int pointsRuns=0;
        int pointsPairs=0;
        int[] enumerate= convertEnumerate(rank);
        Arrays.sort(enumerate);

        int runs  = 0;
        int pairs = 0;

        for (int i=0; i<enumerate.length-1; i++) {
            if (enumerate[i+1]-enumerate[i]==1) {
                runs++;
                pairs = 0;
            }
            else if (enumerate[i+1]==enumerate[i]) pairs++;
            else {
                runs = 0;
                pairs = 0;
            }

            if (runs >2) pointsRuns = runs;
            if (pairs == 1) pointsPairs += 2;
            else if (pairs == 2) pointsPairs += 4;
            else if (pairs == 3) pointsPairs += 6;
        }

        return pointsRuns + pointsPairs;
    }


    public static int flush(String[] rank, String[] suite) {
        boolean allSameSuite = true;
        int pointsFlush = 0;
        int pointsJack = 0;

        for (int i = 1; i < suite.length - 1; i++) {
            if (!suite[i].equals(suite[0])) {
                allSameSuite = false;
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rank[i].equals("J") && suite[i].equals(suite[4])) {
                pointsJack = 1;
                break;
            }
        }

        if (allSameSuite) pointsFlush = suite[0].equals(suite[4]) ? 5 : 4;

        return pointsFlush + pointsJack;
    }
}
