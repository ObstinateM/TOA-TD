import java.io.*;
import java.net.*;

public class ChatClient {
  public static void main(String[] args) throws Exception {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;

    try {
      // echoSocket = new Socket("192.168.194.91", 4444);
      echoSocket = new Socket("localhost", 4444);
      out = new PrintWriter(echoSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

      new HandleIn(in).start();

      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      String userInput;
      while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
      }

      out.close();
      echoSocket.close();
      System.exit(0);
    } catch (UnknownHostException e) {
      System.err.println("Host doent exist");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("I/O error");
      System.exit(1);
    }
  }
}
