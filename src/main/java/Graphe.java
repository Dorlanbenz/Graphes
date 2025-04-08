import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graphe {
    private TreeMap<Integer, Set<Integer>> sommetVoisin;

    public Graphe(int[][] parsomVoisin) {
        sommetVoisin = new TreeMap<>();
        for(int i = 0; i < parsomVoisin.length; i++) {
            TreeSet<Integer> voisin = new TreeSet<>();
            for(int j = 0; j < parsomVoisin[i].length; j++) {
                voisin.add(parsomVoisin[i][j]);
            }
            sommetVoisin.put(i, voisin);
        }
    }

    public Set getSommets(){
        return sommetVoisin.keySet();
    }

    public int getOrdre(){
        return sommetVoisin.size();
    }

    public int degre(int sommet){
        return sommetVoisin.get(sommet).size();
    }

    public int taille(){
        int somme = 0;
        for(int i : sommetVoisin.keySet()) {
            somme += this.degre(i);
        }
        return somme /2;
    }




    public int degre_minimal(){
        int[] tousDegreMin = new int[this.getOrdre()];
        int ind = 0;
        for(int i : sommetVoisin.keySet()) {
            tousDegreMin[ind] = this.degre(i);
            ind++;

        }
        int min = tousDegreMin[0];
        for(int j : tousDegreMin) {
            if(j < min) {
                min = j;
            }
        }
        return min;
    }

    public int degre_maximal(){
        int[] tousDegreMax = new int[this.getOrdre()];
        int ind = 0;
        for(int i : sommetVoisin.keySet()) {
            tousDegreMax[ind] = this.degre(i);
            ind++;
        }
        int max = tousDegreMax[0];
        for(int j : tousDegreMax) {
            if(j > max) {
                max = j;
            }
        }
        return max;

    }

    public String toString() {
        String affichage = "ordre : " + this.getOrdre() + "\n" + "taille : " + this.taille() + "\n"
                + "degré_minimal : " + this.degre_minimal() + "\n" + "degré_maximal : " + this.degre_maximal() + "\n";
        for(int i : sommetVoisin.keySet()) {
            affichage += "sommet " + i + " degré=" + this.degre(i) + " voisins : " + sommetVoisin.get(i) + "\n";
        }
        return affichage;
    }
}
