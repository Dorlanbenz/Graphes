public class ClientGraphe {
    public static void main(String[] args) {
        int [][] tabVoisins = {
                {1,2,4},
                {0,2},
                {0,1,3,4},
                {2,4},
                {0,2,3},

        };

        int [][] tabVoisins2 = {
                {1,2},
                {},
                {5},
                {2,4},
                {5},
                {}
        };

        Graphe graphe = new Graphe(tabVoisins2);
        System.out.println(graphe);

    }
}
