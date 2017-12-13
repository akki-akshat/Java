/*
            INTERFACE IMPLIMENTATION
1. Define one interface with minimum 1  method and use in the class           - 1 mark
2. Define 2 interface with minimum 1 method each and use in the class         - 1 mark
3. Extend one interface to another interface and use in the class             - 1 mark
4. Implement interface in a package and use in the class                      - 1 mark
*/ 
import AEROPLANE.STAFF;                //Interface Package
import AEROPLANE.PASSENGER;
import java.io.*;                  //Basic IO Class
import java.sql.Time;              //Class for Time
import java.util.Scanner;          //IO using scanner       
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

interface READ
{
	public void read();
}
interface ESSENTIALS extends READ
{
	public void disp(); 
}

class AEROPLANE implements STAFF, PASSENGER, ESSENTIALS 
{
    //Name of Airline
    private String jComp;
    //Model of the AEROPLANE being used
    private String jModel;
    //Capacity of the AEROPLANE
    private int jCapacity;
    //Price Per Ticket - Sttic as it will increarse
    static int jPPT;
    //Arrival Time
    private Date jArrival;
    //Departure Time
    private Date jDeparture;
    //Departure City 
    private String jDCity;
    //Arival City
    private String jACity;
    //No of passengers on board
    static int jPassengerId;
    //Passengers
    private String jPass="";
    //Static Block
    private String[] staff = new String[3];
    static 
    {
        jPassengerId = 1000;
        jPPT = 2850;
    }

    //Constructor
    AEROPLANE(Date dep)
    {
        Date tem;
        jComp = "Jet Airways";
        jModel = "A90-501E";
        jCapacity = 180;
        jDCity = "Bengaluru";
        jACity = "Delhi";
        jDeparture = dep;
        long temp = dep.getTime();
        //As date is in milli seconds
        temp = temp + (3*60*60*1000);           
        tem = new Date(temp);    
        jArrival = tem;
    }

    //Static Function
    public static void jCounter()
    {
        if((jPassengerId-1000)<10)
        {
            jPPT = jPPT + 150;
        }
        else
        {
            jPPT = jPPT + 50;
        }
        jPassengerId++;
    }
    public void addPassenger(String n1) 
    {
            jPass = n1;
    }


    //Function to read the values
    public void read() 
    {
	    try
	    {
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	Scanner scan = new Scanner(System.in);
            	DateFormat df = new SimpleDateFormat("hh:mm aa");
            	System.out.print("Please Enter Departure Time in hh:mm aa format:\t");
            	String departure = br.readLine();
            	jDeparture = df.parse(departure);
	    }
	    catch(ParseException e)
	    {
	    	System.out.println("ERROR: "+e);
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
    }
    
    public void staffDetails()
    {
        staff[0] = "Arjun";
        staff[1] = "Ram";
        staff[2] = "Madhur";
    }

    //Function to calculate duartion of the flight
    public String duration() throws ParseException,IOException
    {
        long diff = (jArrival.getTime() - jDeparture.getTime())/60000;
        long hour = diff/60;
        long mins = diff - (hour*60);
        String tem = "";
        if(hour>=0 && mins>=0)
        {
            tem = ""+hour+" hours and "+mins+"else mins";
        }
        else
        {
            tem = "You have entered an invalid Departure or Arival time";
        }
        return tem;
    }

    //Function to diplay the values
    public void disp()
    {
        try
        {
            staffDetails();
            DateFormat df = new SimpleDateFormat("hh:mm aa");
            System.out.println("\n\t\t**Your Flight Details are as Follows:**\n");
            System.out.println("Company Name:\t\t"+jComp);
            System.out.println("Model No.:\t\t"+jModel);
            System.out.println("Capacity of the Plane:\t"+jCapacity);
	        for(int i =0;i<3;i++)
	        {
	        	System.out.println("Staff Member "+ (i+1) + ":\t\t" + staff[i]);
	        }	
            System.out.println("Cost per head:\t\t"+jPPT);
            System.out.println("Departure City:\t\t"+jDCity);
            System.out.println("Departure Time:\t\t"+df.format(jDeparture));
            System.out.println("Arrival City:\t\t"+jACity);
            System.out.println("Arrival Time:\t\t"+df.format(jArrival));
            System.out.println("Duration:\t\t"+duration());
            System.out.println("Passenger ID is:\t"+jPassengerId);
            System.out.println("Passenger is:\t\t"+jPass);
            System.out.println("Total Cost is:\t\t"+jPPT);
        }
        catch(IOException e)
        {
            System.out.println("Error in Display: "+e);
        }
        catch(ParseException e)
	    {
	    	System.out.println("ERROR: "+e);
        }
    }

}
public class AIRLINE
{
    //Another Static Function
    public static void main(String args[]) throws ParseException,IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        // AEROPLANE obj = new AEROPLANE();
        byte choice = 0, choice2 = 0;
        Byte ch;
        int flag = 0;
        String n1;
      do{
        if(flag == 1)
        {
            System.out.print("\n\nWould you like to try Again?(Press 1 to Continue):\t");
            ch = Byte.parseByte(br.readLine());
            if(ch==1)
            {
                System.out.println("");
            }
            else
            {
                System.exit(0);
            }
        }
        System.out.println("Please choose from the following Options:\n\t1.Book a flight to Delhi\n\t2.Get the no of passengers who have already booked\n\t3.Exit");
        System.out.print("\t\tYour Choice:\t");
        choice = Byte.parseByte(br.readLine());
        switch(choice)
        {
            case 1: System.out.println("Select one of the available Departure Timings\n\t1. 10AM\n\t2. 2PM");
                    System.out.print("\t\tYour Choice:\t");
                    choice2 = Byte.parseByte(br.readLine());
                    switch(choice2)
                    {
                        case 1: AEROPLANE obj2 = new AEROPLANE(df.parse("10:00 am"));
                                System.out.println("Enter name of one passenger");
                                n1 = br.readLine();
                                obj2.addPassenger(n1);
                                obj2.jCounter();
                                obj2.disp();
                                break;
                        case 2: AEROPLANE obj3 = new AEROPLANE(df.parse("2:00 pm"));
                                System.out.println("Enter name of passenger:\t");
                                n1 = br.readLine();
                                obj3.addPassenger(n1);
                                AEROPLANE.jCounter();
                                obj3.disp();
                                break;
                        default:System.out.println("Invalid Option");        
                                break;
                    }
                    break;       
            case 2: int no = AEROPLANE.jPassengerId - 1000;
                    System.out.println("\n\nTotal number of users who have booked are:\t"+no);
                    break;
            case 3: System.exit(0);
                    break;
            default:System.out.println("Wrong Option Selected");
                    break;       
        }
    flag = 1;
      }while(choice!=3);
    }
}