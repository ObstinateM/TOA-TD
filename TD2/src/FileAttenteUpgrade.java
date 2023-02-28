import java.util.*;

public class FileAttenteUpgrade extends FileAttente {
  public void clear() {
    while (super.head() != null) {
      super.remove();
    }
  }

  public boolean isEmpty() {
    return super.head() == null;
  }

  public int size() {
    Client firstClient = super.head();
    if (firstClient == null) {
      return 0;
    }
    int cpt = 0;
    do {
      Client tmp = super.head();
      super.remove();
      cpt++;
      super.add(tmp);
    } while (!firstClient.equals(head()));
    return cpt;
  }

  public boolean contains(Client c) {
    List<Client> list = new ArrayList<Client>();
    while (super.head() != null) {
      list.add(super.head());
      super.remove();
    }
    for (Client client : list) {
      this.add(client);
    }
    return list.contains(c);
  }
}
