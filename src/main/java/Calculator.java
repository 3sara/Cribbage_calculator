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
        System.out.println(suite);
        // in input lista di (numero, seme)
        // funzione calcola punti, che chiamerà tutte le funzioni per i vari tipi di punto
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
}
