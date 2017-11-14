import java.io.*;
import java.util.Scanner;
class Customer
{
    private String cName;
    private byte cAge;
    private long cAccNo;
    private char cGender;
    private short cMiniBal;
    private float cBal;
    private long cId;

    public Customer()
    {
        cName = "Akshat";
        cAge = 19;
        cGender = 'M';
        cBal = 50265;
    }

    public Customer(String N,byte a)
    {
        cName = N;
        cAge = a;
        cGender = 'M';
        cBal = 50265;
    }

    public void read() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        // Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Customer Name");
        cName=br.readLine();
        System.out.println("Enter Customer age");
        cAge=Byte.parseByte(br.readLine());
        System.out.println("Enter the Customer Account Number");
        cAccNo=Long.parseLong(br.readLine());
        System.out.println("Enter the Minimum Balance");
        cMiniBal=Short.parseShort(br.readLine());
        System.out.println("Enter Balance Amount");
        cBal=Float.parseFloat(br.readLine());
        System.out.println("Enter Customer gender");
        cGender=(char)br.read();
    }

    public void disp()
    {
        System.out.println("Customer Name = "+cName);
        System.out.println("Customer Age = "+cAge);
        System.out.println("Customer Account Number = "+cAccNo);
        System.out.println("Customer Balance = "+cBal);
        System.out.println("Customer Gender = "+cGender);
    }
}

public class Constructor
{
    public static void main(String arg[]) throws IOException
    {
        Customer obj = new Customer();
        // obj.read();
        obj.disp();
        Customer obj2 = new Customer("AKKI",(byte)10);
        // obj.read();
        obj2.disp();
        Customer obj3 = new Customer();
        obj3.read();
        obj3.disp();
    }
}
