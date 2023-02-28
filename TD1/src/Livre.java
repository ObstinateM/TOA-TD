public class Livre implements Comparable<Livre> {
    int ISBN;
    String titre;
    String auteurs;

    public Livre(int isbn, String titre, String auteurs) {
        this.ISBN = isbn;
        this.titre = titre;
        this.auteurs = auteurs;
    }

    public boolean equals(Object l) {
        return (l instanceof Livre) && this.ISBN == ((Livre) l).ISBN;
    }

    public int compareTo(Livre l) {
        return this.ISBN - l.ISBN;
    }
}
