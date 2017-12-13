/*Define a class Person with the following members
Data Members
Name of the person, age of the person and gender of the person
Member functions
read() - to read values to the data members
disp() - To display values of the data members
One default constructor and one overloaded constructor for Person class
Define a class Worker which inherits from Person class with the following
specification

Data members of Worker class
No.of hours worked per day and wage per hour

Member functions of Worker class
read() - to read values to the data members
calcwg() - to calculate the wage of a worker and return the value
extraWage() - if the twage of the worker is less than Rs. 200, then an extra
amount of Rs. 150 will be paid to the worker. Otherwise Rs. 50
will be paid.
TotalWage() - To find the total wage of the worker.
One default constructor and one overloaded constructor for worker class.
Overloaded constructor has to pass parameters to the parent class constructor.
display() - to display the values of the data members and the total wage
as shown below.
Output format
Name of the worker :
Age of the worker
No. Of Hours worked :
Wage per Hour :
Wage of the worker :
Extra wage :
Total Wage*/
import java.io.*;
class PERSON
{
    //Variabel Declaration
    private String pName;
    private short pAge;
    private char pGender;
    
    //Constuctors
    PERSON()
    {
        pName = " ";
        pAge = 0;
        pGender = 'U';
    }
    PERSON(String name,short age,char gender)
    {
        pName =name;
        pAge = age;
        pGender = gender;
    }
    //Public Functions
    public void read() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Worker's Name:\t");
        pName = br.readLine();
        System.out.print("Enter Worker's Age:\t");
        pAge = Short.parseShort(br.readLine());
        System.out.print("Enter Worker's Gender:\t");
        pGender = (char)br.read();
    }
    public void disp()
    {
        System.out.println("Worker's Name:\t\t\t"+pName);
        System.out.println("Worker's Age:\t\t\t"+pAge);
        System.out.println("Worker's Gender:\t\t"+pGender);
    }
}
class WORKER extends PERSON
{
    //Variable Declaration
    //Hours Worked Per Day
    private byte wHWPD; 
    //Wage Per Hour
    private int wWPH;
    
    //Constructors
    WORKER()
    {
        wHWPD = 0;
        wWPH = 0;
    }
    WORKER(byte wHWPD,int wWPH,String pName,short pAge,char pGender)
    {
        super(pName,pAge,pGender);
        this.wHWPD = wHWPD;
        this.wWPH = wWPH;
    }

    //Funtions
    public void read() throws IOException
    {
        super.read();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the No.  of Hours worker worked:\t");
        wHWPD = Byte.parseByte(br.readLine());
        System.out.print("Enter Wage to be givem per Hour:\t");
        wWPH = Integer.parseInt(br.readLine());
    }
    public int calWage()
    {
        return wHWPD*wWPH;
    }
    public int extraWage()
    {
        if(calWage()<200)
        {
            return 150;
        }
        else
        {
            return 50;
        }
    }
    public int totalWage()
    {
        return calWage()+extraWage();
    }
    public void display()
    {
        disp();
        System.out.println("No. of Hours Worked :\t\t"+wHWPD);
        System.out.println("Wage per Hour :\t\t\t"+wWPH);
        System.out.println("Wage of the worker :\t\t"+calWage());
        System.out.println("Extra Wage :\t\t\t"+extraWage());
        System.out.println("Total Wage :\t\t\t"+totalWage());
    }

}

class MODEL
{
    public static void main(String args[]) throws IOException
    {
        // WORKER obj = new WORKER();
        WORKER obj1 = new WORKER((byte)8,50,"Akshat",(short)19,(char)'M');
        // obj.read();
        obj1.display();

    }
}
