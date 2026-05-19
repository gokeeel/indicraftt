import java.net.*;import java.io.*;
class UDPserver{
  public static void main(String[] a)throws Exception{
    DatagramSocket s=new DatagramSocket(789);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    byte[] b=new byte[1024];
    while(true){
      DatagramPacket p=new DatagramPacket(b,b.length);
      s.receive(p);
      String x=new String(p.getData(),0,p.getLength());
      if(x.equals("end"))break;
      System.out.println("Client: "+x);
      String y=br.readLine();
      b=y.getBytes();
      s.send(new DatagramPacket(b,b.length,p.getAddress(),p.getPort()));
    }
    s.close();
  }
}