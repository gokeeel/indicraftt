import java.io.*;import java.net.*;
class TCPServer{
  public static void main(String[] a)throws Exception{
    ServerSocket ss=new ServerSocket(9000);
    Socket s=ss.accept();
    BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
    BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out=new PrintWriter(s.getOutputStream(),true);
    String x;
    while((x=in.readLine())!=null){
      if(x.equalsIgnoreCase("end"))break;
      System.out.println("Client: "+x);
      System.out.print("Server: ");
      x=kb.readLine();
      out.println(x);
      if(x.equalsIgnoreCase("end"))break;
    }
    s.close();ss.close();
  }
}