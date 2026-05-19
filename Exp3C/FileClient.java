import java.net.*;import java.io.*;
class FileClient{
  public static void main(String[] a)throws Exception{
    Socket s=new Socket("localhost",5000);
    InputStream in=s.getInputStream();
    FileOutputStream out=new FileOutputStream("received_file.jpg");
    byte[] b=new byte[1024];
    int n;
    while((n=in.read(b))!=-1)out.write(b,0,n);
    out.close();s.close();
  }
}