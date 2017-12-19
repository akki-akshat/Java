/*
 Implementation of super and this 
1. use of this keyword to initialize data members    - 1 mark
2. use of this keyword in constructor chaining          - 1 mark
3. use of super keyword to call parent class methods  - 1 marks
4. Use of super keyword to pass parameters to parent class constructor  - 1 mark"

*/
import java.io.*;                  //Basic IO Class
import java.sql.Time;              //Class for Time
import java.util.Scanner;          //IO using scanner       
//Parent Class
class SCHOOL
{
    //Variable declaration
	private int schNo;	
    private String schName;
    private String schCity;
    private String schHead;
    SCHOOL(int schNo,String schName,String schHead)
    {
        this.schNo = schNo;
        this.schName = schName;
        this.schHead = schHead;                    
    }
    SCHOOL(int schNo,String schName,String schHead,String schCity)
    {
        //Constructor Chaining
        this(schNo,schName,schHead);
        this.schCity = schCity;
    }
    SCHOOL()
    {
        schNo = 0;
    }
    public void schDisplay()
    {
        System.out.println("\n\t\t*SCHOOL INFORMATION*\n");
        System.out.println("School's No is:\t\t\t"+schNo);
        System.out.println("School's Name is:\t\t"+schName);
        System.out.println("School is in:\t\t\t"+schCity);
        System.out.println("School's Head is:\t\t"+schHead);
    }

}

// Child Class for SCHOOL
class CLASS extends SCHOOL
{
    //Variable decalration
    private String cLocation;
    private String cName;
    private String cSection;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CLASS(String cLocation)
    {
        this.cLocation = cLocation;
    }
    CLASS()
    {
        //Passing parameter to parent class constructor 
        super(17822,"Mordern Public School","Mr. Augusti","Delhi");
    }
    public void cRead() throws IOException
    {
        System.out.print("Enter Location of the class:\t");
        cLocation = br.readLine();
        System.out.print("Enter Name of the class:\t");
        cName = br.readLine();
        System.out.print("Enter Section of the class:\t");
        cSection = br.readLine();    
    }
    public void schDisp()
    {
        super.schDisplay();
        System.out.println("\n\t\t*CLASS INFORMATION*\n");
        System.out.println("Location of the class is:\t" + cLocation);
        System.out.println("Name of the class is:\t\t"+cName);
        System.out.println("Section of the class is:\t"+cSection);
    }
}

//Child class to CLASS
class STUDENT extends CLASS
{
	private int sRollNo;
    private String sName;
    private short sAge;
    public void sRead() throws IOException
    {
        super.cRead();
        System.out.print("Enter Student's Roll No.:\t");        
        sRollNo = Integer.parseInt(super.br.readLine());
        System.out.print("Enter Student's Name:\t\t");        
        sName = super.br.readLine();
        System.out.print("Enter Student's Age:\t\t");        
        sAge = Short.parseShort(super.br.readLine());
    }
    public void schDisp()
    {
        super.schDisp();
        System.out.println("\n\t\t*PERSONAL INFORMATION*\n");
        System.out.println("Student's Roll No is.:\t\t" + sRollNo);
        System.out.println("Student's Name is:\t\t" + sName);        
        System.out.println("Student's Age is:\t\t" + sAge);        
    }

}

//Child class to STUDENT
class RESULT extends STUDENT
{
    private String[] sub= {"English","Hindi  ","Maths  ","Science","EVS   "};
    private float[] rMarks = new float[5];
    private float res = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void rRead() throws IOException
	{
        super.sRead(); 
        int i;
        res = 0;	
		for(i=0; i<5; i++)
		{
            System.out.print("Marks in " + sub[i] + ":\t\t");
            rMarks[i] = Float.parseFloat(br.readLine());
                if(rMarks[i] < 101)
                {
                    res = res + rMarks[i];
                }
                else
                {
                    i--;
                    System.out.println("Error:Marks should be less than 100");
                }
        }
    }
    
    
	public void rDisp()
	{
        super.schDisp();
        System.out.println("\t\t*MARKS*\n");
        int i;	
        for(i=0; i<5; i++)
        {
            System.out.println("Marks in " + sub[i] + " is:\t\t" + rMarks[i]);
        }
    }
    //Checking if the student is pass or fail
	public void pof()
	{
        float ress = (res/5);
        System.out.println("Percentage :\t\t\t" + ress + "%");
    if (ress>35)
        System.out.println("Result :\t\t\tPASS\n");
    else
        System.out.println("Result :\t\t\tFAIL\n");
    }
}

public class REPORT
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RESULT obj = new RESULT();
        byte ch = 0,choice =0;
     do {      
        System.out.println("\n\t***Please Enter the Following Details for Mordern Public School***\n");
        obj.rRead();
        do
        {
            System.out.print("\nChoose from the following:\n\t1. Display Result\n\t2. Status and Percentage\n\t3. Enter Values again or Exit\n\nChoice:\t\t");
            ch =  Byte.parseByte(br.readLine());
            System.out.print("\n");
            if(ch==1)
            {
                System.out.println("\n\n\t\t\t**Report Card:**");
                obj.rDisp();
            }
            else if(ch==2)
            {
                obj.pof();
            }
            else if(ch==3)
            {
                break;
            }
            else
            {
                System.out.println("\n\n\t\t**Not a valid option, please try again!**\n\n");
            }
       }while(ch!=3);
       System.out.print("\nPress 1 if you want to exit, otherwise enter any number to enter new values:\t");
       choice =  Byte.parseByte(br.readLine());
      }while (choice!=1);
    }
}
