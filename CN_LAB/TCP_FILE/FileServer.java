import java.net.*;import java.io.*;
class FileServer{
  public static void main(String[] a)throws Exception{
    ServerSocket ss=new ServerSocket(5000);
    Socket s=ss.accept();
    FileInputStream in=new FileInputStream("digital_image_processing.jpg");
    OutputStream out=s.getOutputStream();
    byte[] b=new byte[1024];
    int n;
    while((n=in.read(b))!=-1)out.write(b,0,n);
    in.close();out.close();s.close();ss.close();
  }
}