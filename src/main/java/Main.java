public class Main {
    public static void main(String[] args) throws Exception {
        Card[] hand = {
                new Card("5", "H", 5, 4),
                new Card("5", "D", 5, 4),
                new Card("5", "S", 5, 4),
                new Card("J", "C", 10, 11),
                new Card("5", "C", 5, 4)
        };


        Hand hand1 = new Hand("5H5D5SJC5C");
        Hand hand1_arrays = new Hand(hand);
        Hand hand2 = new Hand("0DJHQSAC9D");

        System.out.println(Calculator.countPoints(hand1));
        System.out.println(Calculator.countPoints(hand1_arrays));
        System.out.println(Calculator.countPoints(hand2));
    }
}


