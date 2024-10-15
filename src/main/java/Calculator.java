public class Calculator {
    public static void main(String[] args) {
        String[] input = args[0].split ("");
        String[] rank = new String[5];
        String[] suite = new String[5];
        for (int i=0; i<10; i=i+2) {
            rank[i/2] = input[i];
            suite[i/2] = input[i+1];
        }

        System.out.println(rank);
        System.out.println(suite);
        // in input lista di (numero, seme)
        // funzione calcola punti, che chiamerà tutte le funzioni per i vari tipi di punto
    }
}
