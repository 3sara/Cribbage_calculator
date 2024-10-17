public class Calculator {
    public static int countPoints(Hand hand) {
        return fifteenTwos(hand, 0, 0) + runsPairs(hand) + flush(hand);
    }

    private static int fifteenTwos(Hand hand, int start, int current) {
        // 2 or more cards sum to 15
        // Jack, King, Queen = 10
        // Ace = 1
        int fifteenTwosPoint = 0;

        for (int i = start; i < 5; i++) {
            int runningPoints = current + hand.getCard(i).getPoints();
            if (runningPoints == 15) fifteenTwosPoint +=2;
            if (runningPoints < 15) {
                fifteenTwosPoint += fifteenTwos(hand, i+1, runningPoints);
            }
        }
        return fifteenTwosPoint;
    }

    private static int runsPairs(Hand hand){
        int runsPoints  = 0;
        int pairsPoints = 0;

        int[] enumerate = hand.sorted();

        int runs  = 1;
        int pairs = 0;

        for (int i=0; i<enumerate.length-1; i++) {
            if (enumerate[i+1]-enumerate[i]==1) {
                runs++;
                pairs = 0;
            }
            else if (enumerate[i+1]==enumerate[i]) pairs++;
            else {
                runs = 1;
                pairs = 0;
            }

            if (runs >2) runsPoints = runs;
            if (pairs == 1) pairsPoints += 2;
            else if (pairs == 2) pairsPoints += 4;
            else if (pairs == 3) pairsPoints += 6;
        }

        return runsPoints + pairsPoints;
    }


    private static int flush(Hand hand) {
        boolean allSameSuite = true;
        int pointsFlush = 0;
        int pointsJack = 0;
        String firstSuite = hand.getCard(0).getSuit();
        String starterSuite = hand.getCard(4).getSuit();

        for (int i = 1; i < 4; i++) {
            if (!hand.getCard(i).getSuit().equals(firstSuite)) {
                allSameSuite = false;
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (hand.getCard(i).getRank().equals("J") && hand.getCard(i).getSuit().equals(starterSuite)) {
                pointsJack = 1;
                break;
            }
        }

        if (allSameSuite) pointsFlush = firstSuite.equals(starterSuite) ? 5 : 4;

        return pointsFlush + pointsJack;
    }
}
