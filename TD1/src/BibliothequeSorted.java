import java.util.*;

public class BibliothequeSorted extends Bibliotheque {
  private SortedSet<Livre> sortedLivres = new TreeSet<Livre>();

  public Iterator<Livre> iterator() {
    return this.sortedLivres.iterator();
  }

  public boolean add(Livre l) {
    sortedLivres.add(l); // sorted => Check if already exists too
    return super.add(l);
  }

  public Livre remove() {
    Livre l = super.remove();
    if (l != null)
      this.sortedLivres.remove(l);
    return l;
  }

  // TODO: Modifier toutes les opérations qui modifie la structure de donnée, add, remove, addAll,
  // removeAll, clear, ...
}
