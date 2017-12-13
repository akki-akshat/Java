/*
An Advertisement company keeps the main information about the advertisement such as 
Advertisement_id, Client_Name, start_date of advertisement in a class called Advertisement. From this class derive two classes: 
Commercial_Add  and Free_Add.
Commercial_Add class keeps the additional information 
such as size_of_add in cm and prize of add per cm. 
Free_Add class adds freeadd_time_duration ( in months). 
Each of these three classes should have a read() to read its data from the user through the keyboard, and a display() 
function to display its data on the screen. 
In each class, at least one parameterized constructor is required to explain 
the meaning of passing parameters from a child class constructor to parent class constructor.
Generate Advertisement_id automatically.  Implement the above classes in Java with following options
1. read data for Advertisement class
2. Display data for Advertisement class
3. Read data for Commercial_Add class
4. Display data for Commercial_Add
5. Read data fo Free_Add class
6. Display data for Free_Add class
7. Create Commercial_Add object using parameterized constructor
8. Display the advertisement id .
*/
import java.io.*;
import java.util.Scanner;
class ADVERTISEMENT
{
    private static int adId;
    private String adCName;
    private String adStartDate;
    static
    {
        adID = 1000;
    }
    ADVERTISEMENT()
    {
    }
    ADVERTISEMENT(String CName,String StrartDate)
    {
        adCName = CName;
        StrartDate = adStartDate;
        adID = adID + 1;
    }
    public void read()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please Enter Advertisement ID:\t");
        adId = Integer.parseInt(br.readLine());
        System.out.print("Please Enter Client Name:\t");
        adCName = br.readLine();
        System.out.print("Please Enter Start Date of Advertisement(dd/mm/yy):\t");
        adStartDate = br.readLine();
    }
    public void disp()
    {
        System.out.print("Advertisement ID:\t"+adId);
        System.out.print("Client Name:\t"+adCName);
        System.out.print("Start Date of Advertisement:\t"+adStartDate);
    }
}

class COMMERCIAL_ADD extends ADVERTISEMENT
{
    private float cSizeofAd;
    //Variable : price per centimeter
    private float cPPC;
    private float cCost;

    COMMERCIAL_ADD(float cSizeofAd,float cPPC)
    {
        super("RAJ","15/11/17");
        this.cSizeofAd = cSizeofAd;
        this.cPPC = cPPC;
        cCost = cPPC*cSizeofAd;
    }

    public void read()
    {
        super.read();
        System.out.print("Please Enter Size of the AD in cm:\t");
        cSizeofAd = Float.parseFloat(br.readLine());
        System.out.print("Please Enter Price per cm:\t");
        cPPC = Float.parseFloat(br.readLine());
    }
    public void disp()
    {
        System.out.print("Size of the AD in cm:\t"+cSizeofAd);
        System.out.print("Price per cm:\t"+cPPC);   
        System.out.print("Cost of AD:\t"+cCost);     
    }
}

class FREE_ADD extends ADVERTISEMENT
{
    private int fDuration;

    FREE_ADD(int fDuration)
    {
        super("RAM","23/07/2017");
        this.fDuartion = fDuration;
    }
    FREE_ADD(){}

    public void read()
    {
        super.read();
        System.out.print("Please Enter Duration of the Advertisement(in months):\t");
        fDuration = Integer.parseInt(br.readLine());
    }
    public void disp()
    {
        System.out.print("Duration of the Advertisement(in months):\t"+fDuration);
    }
}

class ADVERTISERS
{
    public static void main(String args[])
    {
        FREE_ADD fa = new FREE_ADD();
        fa.read();
        fa.disp();
        COMMERCIAL_ADD ca = new COMMERCIAL_ADD(100, 20);
        ca.disp();
    }
}