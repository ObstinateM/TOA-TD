import java.util.*;

public class Bibliotheque extends BibliothequeAbstraite implements Iterable<Livre> {
    List<Livre> livres = new ArrayList<Livre>();

    public Iterator<Livre> iterator() {
        return this.livres.iterator();
    }

    public boolean add(Livre l) {
        // Le contains fait un .equal -> on l'a pas redefini
        // Donc il fait une comp de reference, donc ca marche pas correctement
        // => Definir equals dans Livre
        if (this.livres.contains(l)) {
            return this.livres.add(l);
        }
        return false;
    }

    public Livre remove() {
        int size = this.livres.size();

        if (size == 0) {
            return null;
        }

        return this.livres.remove(size - 1);
    }

    @Override
    public boolean contains(Livre l) {
        return this.livres.contains(l);
    }
}
