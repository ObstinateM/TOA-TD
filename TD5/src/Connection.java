import java.io.*;
import java.net.*;

public class Connection extends Thread {
  Socket s = null;

  public Connection(Socket s) {
    this.s = s;
  }

  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);
      out.println("type 'exit' to close the connection");
      boolean done = false;
      while (!done) {
        String line = in.readLine();
        System.out.println(s.getInetAddress() + " :" + line);
        if (line == null)
          done = true;
        else {
          out.println("Echo: " + line);
          if (line.trim().equals("exit"))
            done = true;
        }
      }
      s.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
