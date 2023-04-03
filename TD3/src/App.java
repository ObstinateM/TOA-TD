import java.util.*;
import java.util.function.Predicate;

public class App {
    /**
     * Écrire deux méthodes statiques génériques qui permettent, pour l’une, d’afficher les éléments
     * d’un tableau et pour l’autre d’échanger les positions de deux éléments différents dans un
     * tableau
     */
    public static <T> void afficher(List<T> tab) {
        for (T t : tab) {
            System.out.println(t);
        }
    }

    public static <T> void echanger(List<T> tab, int i, int j) {
        T tmp = tab.get(i);
        tab.set(i, tab.get(j));
        tab.set(j, tmp);
    }

    /**
     * Écrire une méthode statiques générique qui cherche et renvoie le maximum des éléments dans
     * l’intervalle [début, fin] d’une liste (collection ordonnée) donnée.
     */
    public static <T extends Comparable<T>> T max(List<T> tab, int debut, int fin) {
        T max = tab.get(debut);
        for (int i = debut; i <= fin; i++) {
            if (tab.get(i).compareTo(max) > 0) {
                max = tab.get(i);
            }
        }
        return max;
    }

    /**
     * Écrire une méthode générique qui compte et renvoie le nombre d’éléments vérifiant une
     * propriété spécifique dans une collection donnée (par exemple, des entiers impairs, des
     * nombres premiers, des palindromes, etc.). Invoquez la méthode générique définie pour trouver
     * le nombre de chaînes de caractères ayant une longueur impaire (nombre de caractères impair)
     * d’une collection donnée.
     */
    public static <T> int count(List<T> tab, Predicate<T> p) {
        int count = 0;
        for (T t : tab) {
            if (p.test(t)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Comment invoquer la méthode suivante pour trouver le premier entier dans une liste qui soit
     * premier par rapport à une liste de nombres entiers spécifiés ? public static <T> int
     * findFirst (Liste <T> liste, int début, int end, UnaryPredicate <T> p) Noter que deux entiers
     * a et b sont premiers entre eux si pgcd(a, b) = 1, où pgcd est l’abréviation de plus grand
     * commun diviseur.
     */
    public static void main(String[] args) throws Exception {
        count(Arrays.asList("1", "22", "333"), new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.length() % 2 == 1;
            }
        });
    }
}
