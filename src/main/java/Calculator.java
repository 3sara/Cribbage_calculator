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

    public static int fifteenTwos(int[] points, int start, int current) {
        // 2 or more cards sum to 15
        // Jack, King, Queen = 10
        // Ace = 1
        int counter = 0;

        for (int i=start; i<points.length; i++) {
            int value = current + points[i];
            if (value == 15) counter++;
            if (value < 15) {
                counter += fifteenTwos(points, start = i+1, current = value);
            }
        }
        return 2*counter;
    }
}
