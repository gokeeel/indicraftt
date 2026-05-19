import java.net.*;import java.io.*;
class udpdnsclient{
  public static void main(String[] a)throws Exception{
    DatagramSocket s=new DatagramSocket();
    InetAddress ip=a.length==0?InetAddress.getLocalHost():InetAddress.getByName(a[0]);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter hostname: ");
    byte[] b=br.readLine().getBytes();
    s.send(new DatagramPacket(b,b.length,ip,1362));
    b=new byte[1024];
    DatagramPacket p=new DatagramPacket(b,b.length);
    s.receive(p);
    System.out.println(new String(p.getData(),0,p.getLength()));
    s.close();
  }
}