import java.net.*;import java.io.*;
class UDPclient{
  public static void main(String[] a)throws Exception{
    DatagramSocket s=new DatagramSocket();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    InetAddress ip=InetAddress.getByName("localhost");
    byte[] b;
    while(true){
      String x=br.readLine();
      if(x.equals("end"))break;
      b=x.getBytes();
      s.send(new DatagramPacket(b,b.length,ip,789));
      DatagramPacket p=new DatagramPacket(new byte[1024],1024);
      s.receive(p);
      System.out.println(new String(p.getData(),0,p.getLength()));
    }
    s.close();
  }
}