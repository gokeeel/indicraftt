import java.net.*;
class udpdnsserver{
  public static void main(String[] a)throws Exception{
    String[] h={"yahoo.com","gmail.com","cricinfo.com","facebook.com"},
             ip={"68.180.206.184","209.85.148.19","80.168.92.140","69.63.189.16"};
    DatagramSocket s=new DatagramSocket(1362);
    byte[] b=new byte[1024];
    while(true){
      DatagramPacket p=new DatagramPacket(b,b.length);
      s.receive(p);
      String x=new String(p.getData(),0,p.getLength()).trim(), r="Host Not Found";
      for(int i=0;i<h.length;i++)if(h[i].equalsIgnoreCase(x)){r=ip[i];break;}
      b=r.getBytes();
      s.send(new DatagramPacket(b,b.length,p.getAddress(),p.getPort()));
    }
  }
}