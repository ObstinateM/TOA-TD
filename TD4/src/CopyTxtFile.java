import java.io.*;

public class CopyTxtFile {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: cp <source> <dest>");
      System.exit(1);
    }

    String dest;

    if (args.length < 1) {
      dest = args[0] + "Copie";
    } else {
      dest = args[1];
    }

    try {
      if (!new File(args[0]).exists()) {
        System.out.println("File " + args[0] + " does not exist.");
        System.exit(1);
      }

      if (new File(dest).exists()) {
        System.out.println("File " + dest + " already exists.");
        System.exit(1);
      }

      BufferedReader sourceBuf = new BufferedReader(new FileReader(args[0]));
      BufferedWriter destBuf = new BufferedWriter(new FileWriter(dest));
      // PrintWriter pw = new PrintWriter(dest);

      // Char version
      int r = sourceBuf.read();
      while (r != -1) {
        destBuf.write(r);
        r = sourceBuf.read();
      }

      // Line version
      // while (sourceBuf.ready()) {
      // destBuf.write(sourceBuf.readLine());
      // destBuf.newLine();
      // }

      // String s;
      // while((s = sourceBuf.readLine()) != null) {
      // pw.println(s);
      // }

      sourceBuf.close();
      destBuf.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
