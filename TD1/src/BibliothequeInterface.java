interface BibliothequeInterface {
  int size();

  boolean isEmpty();

  boolean add(Livre l);

  Livre remove();

  boolean addAll(BibliothequeInterface b);

  boolean removeAll(BibliothequeInterface b);

  void clear();
}
