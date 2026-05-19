import java.io.*;
import javax.net.ssl.*;

class GoogleClient {
  public static void main(String[] a) throws Exception {
    SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("www.google.com", 443);

    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

    out.print("GET / HTTP/1.1\r\nHost: www.google.com\r\nConnection: close\r\n\r\n");
    out.flush();

    BufferedWriter file = new BufferedWriter(new FileWriter("google_homepage.html"));
    String line;
    while ((line = in.readLine()) != null) {
      file.write(line);
      file.newLine();
    }

    file.close();
    in.close();
    out.close();
    s.close();

    System.out.println("Google homepage downloaded.");
  }
}