import java.io.*;

public class HandleIn extends Thread {
  BufferedReader in = null;

  HandleIn(BufferedReader in) {
    this.in = in;
  }

  public void run() {
    try {
      while (true) {
        System.out.println(in.readLine());
      }
    } catch (IOException err) {
      System.out.println("Error in in.ready");
    }
  }
}
