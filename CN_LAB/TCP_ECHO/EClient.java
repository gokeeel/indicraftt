import java.net.*;import java.io.*;
class EClient{
  public static void main(String[] a)throws Exception{
    Socket c=new Socket("localhost",9000);
    BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
    BufferedReader s=new BufferedReader(new InputStreamReader(c.getInputStream()));
    PrintWriter o=new PrintWriter(c.getOutputStream(),true);
    String l;
    while(true){
      l=k.readLine();
      o.println(l);
      if(l.equalsIgnoreCase("end"))break;
      System.out.println("Server: "+s.readLine());
    }
    c.close();
  }
}