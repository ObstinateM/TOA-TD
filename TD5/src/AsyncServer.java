import java.net.*;

public class AsyncServer {
  public static void main(String[] args) throws Exception {
    try {
      ServerSocket s = new ServerSocket(4444);
      while (true) {
        Socket incoming = s.accept();
        System.out.println("Test1");
        new Connection(incoming).start();
        System.out.println("passed");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
