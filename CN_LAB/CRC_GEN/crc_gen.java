import java.io.*;
class crc_gen{
  static String div(String s,String g){
    char[] a=s.toCharArray(),b=g.toCharArray();
    for(int i=0;i<=a.length-b.length;i++)
      if(a[i]=='1')
        for(int j=0;j<b.length;j++)
          a[i+j]=(a[i+j]==b[j]?'0':'1');
    return new String(a);
  }

  public static void main(String[] a)throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter data bits: ");
    String d=br.readLine();

    System.out.print("Enter divisor bits: ");
    String g=br.readLine();

    String crc=d+div(d+"0".repeat(g.length()-1),g).substring(d.length());

    System.out.println("CRC code: "+crc);

    System.out.print("Enter received code: ");
    String r=br.readLine();

    System.out.println(div(r,g).contains("1")?"Error":"No Error");
  }
}