import java.util.*;

public class FileAttente {
  LinkedList<Client> clients = new LinkedList<Client>();

  public boolean add(Client c) {
    if (this.clients.contains(c)) {
      return false;
    }

    return this.clients.add(c);
  }

  public void remove() {
    if (this.clients.isEmpty()) {
      return;
    }

    this.clients.removeFirst();
  }

  public Client head() {
    if (this.clients.size() == 0) {
      return null;
    }

    return this.clients.getFirst();
  }

  @Override
  public String toString() {
    // Collections.sort(clients) -> Modifie client donc modifie notre FIFO
    return (new TreeSet<Client>(clients)).toString();
  }

  public String listeClientsLocalite() {
    SortedSet<Client> tmp = new TreeSet<Client>(new Comparator<Client>() {
      public int compare(Client c1, Client c2) {
        return c1.postal - c2.postal;
      }
    });
    tmp.addAll(clients);
    return tmp.toString();
  }
}
