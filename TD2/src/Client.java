public class Client implements Comparable<Client> {
  String prenom;
  String nom;
  int postal;

  Client(String prenom, String nom, int postal) {
    this.prenom = prenom;
    this.nom = nom;
    this.postal = postal;
  }

  public boolean equals(Object o) {
    return (o instanceof Client) && this.prenom.equals(((Client) o).prenom)
        && this.nom.equals(((Client) o).nom);
  }

  public int compareTo(Client c) {
    return this.prenom.compareTo(c.prenom);
  }

  public String toString() {
    return String.format("nom : %s, prenom : %s, postal : %d", this.prenom, this.nom, this.postal);
  }
}
