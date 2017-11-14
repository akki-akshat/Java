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
        cBal = 20161;
    }

    public void read() throws IOException
    {
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Customer Name");
        // cName=br.readLine();
        cName = scan.next();
        System.out.println("Enter Customer age");
        // cAge=Byte.parseByte(br.readLine());
        cAge = scan.nextByte();
        System.out.println("Enter the Customer Account Number");
        // cAccNo=Long.parseLong(br.readLine());
        cAccNo = scan.nextLong();
        System.out.println("Enter the Minimum Balance");
        // cMiniBal=Short.parseShort(br.readLine());
        cMiniBal = scan.nextShort();
        System.out.println("Enter Balance Amount");
        // cBal=Float.parseFloat(br.readLine());
        cBal = scan.nextFloat();
        System.out.println("Enter Customer gender");
        // cGender=(char)br.read();
        cGender = scan.next().charAt(0);
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

public class Scannerrr
{
    public static void main(String arg[]) throws IOException
    {
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        Scanner scan = new Scanner(System.in);
        int ch=0;
        do{   
            System.out.println("Please Choose from the following:\n1.OBJ1\n2.OBJ2\n3.OBJ3\n4.Exit\nChoice:\t");
            // ch = Integer.parseInt(br.readLine());
            ch = scan.nextInt();
            if(ch==1)
            {
                Customer obj = new Customer();
                obj.disp();
            }
            else if(ch==2)
            {
                Customer obj2 = new Customer("AKKI",(byte)25);
                obj2.disp();
            }
            else if(ch==3)
            {
                Customer obj3 = new Customer();
                obj3.read();
                obj3.disp();
            }
            else if(ch==4)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid Option");
            }
        }while(ch!=4);
    }
}
