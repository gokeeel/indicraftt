import java.io.*;import java.net.*;
class TCPClient{
  public static void main(String[] a)throws Exception{
    Socket s=new Socket("localhost",9000);
    BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
    BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out=new PrintWriter(s.getOutputStream(),true);
    while(true){
      System.out.print("Client: ");
      String x=kb.readLine();
      out.println(x);
      if(x.equalsIgnoreCase("end"))break;
      System.out.println("Server: "+in.readLine());
    }
    s.close();
  }
}