public abstract class BibliothequeAbstraite implements BibliothequeInterface {
    public void clear() {
        while (!this.isEmpty()) {
            this.remove();
        }
        // this.removeAll(this); // Peut fonctionner mais p-e edge case
    }

    public boolean isEmpty() {
        return this.size() == 0;
        // Livre l = this.remove();
        // if (l == null) {
        // return true;
        // }
        // this.add(l);
        // return false;
    }

    public int size() {
        int cpt = 0;
        Livre l = this.remove();

        if (l != null) {
            cpt = 1 + this.size();
            this.add(l);
        }

        return cpt;
    }

    public boolean contains(Livre l) {
        Livre curr = this.remove();
        if (curr == null) {
            return false;
        }

        if (curr.equals(l)) {
            this.add(l);
            return true;
        }

        boolean value = this.contains(l);
        this.add(curr);

        return value;

        // Methode 2: (La biblio est un Set, pas de doublons)
        // if (this.add(l)) { this.remove(); return false }
        // return true;
    }
}
