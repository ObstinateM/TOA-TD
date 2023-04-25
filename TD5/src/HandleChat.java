import java.io.*;
import java.net.*;
import java.util.*;

public class HandleChat extends Thread {
  Socket s = null;
  ArrayList<PrintWriter> outs = new ArrayList<PrintWriter>();

  public HandleChat(Socket s, ArrayList<PrintWriter> outs) {
    this.s = s;
    this.outs = outs;
  }

  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);

      this.outs.add(out);

      boolean done = false;
      while (!done) {
        String line = in.readLine();
        System.out.println(s.getInetAddress() + " :" + line);
        if (line == null)
          done = true;
        else {
          for (PrintWriter p : outs) {
            p.println(s.getInetAddress() + ": " + line);
          }
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
