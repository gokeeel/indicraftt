import java.net.*;import java.io.*;
class EServer{
  public static void main(String[] a)throws Exception{
    ServerSocket ss=new ServerSocket(9000);
    Socket c=ss.accept();
    BufferedReader i=new BufferedReader(new InputStreamReader(c.getInputStream()));
    PrintWriter o=new PrintWriter(c.getOutputStream(),true);
    String l;
    while((l=i.readLine())!=null){
      if(l.equalsIgnoreCase("end"))break;
      System.out.println("Client: "+l);
      o.println(l);
    }
    c.close();
    ss.close();
  }
}