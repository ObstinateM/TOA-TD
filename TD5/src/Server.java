import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws Exception {
    try {
      ServerSocket s = new ServerSocket(4444);
      Socket incoming = s.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
      PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
      out.println("exit plz");
      boolean done = false;
      while (!done) {
        String line = in.readLine();
        System.out.println(line);
        if (line == null)
          done = true;
        else {
          out.println("Echo: " + line);
          if (line.trim().equals("exit"))
            done = true;
        }
      }
      incoming.close();
      s.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
