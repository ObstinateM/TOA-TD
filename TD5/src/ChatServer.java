import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
  protected static ArrayList<PrintWriter> outs = new ArrayList<PrintWriter>();

  public static void main(String[] args) throws Exception {
    try {
      ServerSocket s = new ServerSocket(4444);
      while (true) {
        Socket incoming = s.accept();
        new HandleChat(incoming, outs).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
