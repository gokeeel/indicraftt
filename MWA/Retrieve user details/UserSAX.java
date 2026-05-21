import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class UserSAX extends DefaultHandler
{
    boolean bId=false, bName=false, bAddress=false, bGender=false;

    String inputId="";
    String tempId="";

    public void startDocument()
    {
        try
        {
            BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter User ID: ");

            inputId = br.readLine();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
    {
        if(qName.equals("userid"))
            bId=true;

        else if(qName.equals("name"))
            bName=true;

        else if(qName.equals("address"))
            bAddress=true;

        else if(qName.equals("gender"))
            bGender=true;
    }

    public void characters(char ch[], int start, int length)
    {
        String value =
        new String(ch,start,length).trim();

        if(value.length()==0)
            return;

        if(bId)
        {
            tempId=value;
            bId=false;
        }

        else if(bName)
        {
            if(tempId.equals(inputId))
                System.out.println("Name : "+value);

            bName=false;
        }

        else if(bAddress)
        {
            if(tempId.equals(inputId))
                System.out.println("Address : "+value);

            bAddress=false;
        }

        else if(bGender)
        {
            if(tempId.equals(inputId))
                System.out.println("Gender : "+value);

            bGender=false;
        }
    }

    public static void main(String args[]) throws Exception
    {
        SAXParserFactory factory =
        SAXParserFactory.newInstance();

        SAXParser parser =
        factory.newSAXParser();

        parser.parse(new File("users.xml"),
        new UserSAX());
    }
}