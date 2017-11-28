/*
    Dated : 21.11.17
    Question1: Implementation of function overloading and constructor overloading
    Specifications Required:1. at least 3 overloaded constructors for a class having minimum 7 attributes - 1 marks
                            2. Implementation of 3 overloaded function in the same class - 2 marks
                            3. Presentation in a Menu format - 1 mark
*/
import java.io.*;                  //Basic IO Class
import java.sql.Time;              //Class for Time
import java.util.Scanner;          //IO using scanner       
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class AEROPLANE 
{
    //Name of Airline
    private String jComp;
    //Model of the AEROPLANE being used
    private String jModel;
    //Capacity of the AEROPLANE
    private int jCapacity;
    //Price Per Ticket
    private int jPPT;
    //Arrival Time
    private Date jArrival;
    //Departure Time
    private Date jDeparture;
    //Departure City 
    private String jDCity;
    //Arival City
    private String jACity;
    //Passengers
    private String jPass1="";
    private String jPass2="";
    private String jPass3="";

    //Overlaoding function 
    AEROPLANE()
    {
        jPPT = 0;
    }
    AEROPLANE(String fromloc,String dep) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        jComp = "SpiceJet";
        jModel = "124-A101";
        jCapacity = 220;
        jPPT = 3500;
        jDCity = fromloc;
        jACity = dep;
        String arrival = "2:05 pm";
        jArrival = df.parse(arrival);
        String departure = "6:00 pm";
        jDeparture = df.parse(departure);
    }
    AEROPLANE(Date dep,String city)
    {
        // DateFormat df = new SimpleDateFormat("hh:mm aa");
        Date tem;
        jComp = "KingFisher";
        jModel = "A90-501E";
        jCapacity = 180;
        jPPT = 5000;
        jDCity = "Bengaluru";
        jACity = city;
        jDeparture = dep;
        long temp = dep.getTime();
        //As date is in milli seconds
        if(city=="Delhi")
        {
            temp = temp + (3*60*60*1000);           
            tem = new Date(temp);    
        }
        else
        {
            temp = temp + (1*60*60*1000);           
            tem = new Date(temp);   
        }
        jArrival = tem;
    }
    public void addPesenger(String n1) throws ParseException,IOException
    {
        jPass1 = n1;
        // jPass2="";
        // jPass3="";
    }
    public void addPesenger(String n1,String n2) throws ParseException,IOException
    {
        jPass1=n1;
        jPass2=n2;
        // jPass3="";
    }
    public void addPesenger(String n1,String n2,String n3) throws ParseException,IOException
    {
        jPass1=n1;
        jPass2=n2;
        jPass3=n3;
    }
   
    //Function to read the values
    public void read() throws ParseException,IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        System.out.print("Please Enter Company Name:\t");
        jComp = scan.nextLine();            
        System.out.print("Please Enter Model No.:\t");
        jModel = scan.nextLine();
        System.out.print("Please Enter the Capacity of the Model:\t");
        jCapacity = scan.nextInt();
        System.out.print("Please the Price Per Ticket:\t");
        jPPT = scan.nextInt();
        System.out.print("Please Enter Departure City:\t");
        jDCity = br.readLine();
        System.out.print("Please Enter Departure Time in hh:mm aa format:\t");
        String departure = br.readLine();
        jDeparture = df.parse(departure);
        System.out.print("Please Enter Arrival City:\t");
        jACity = br.readLine();
        System.out.print("Please Enter Arrival Time in hh:mm aa format:\t");
        String arrival = br.readLine();
        jArrival = df.parse(arrival);
    }
    //Function to calculate duartion of the flight
    public String duration() throws ParseException,IOException
    {
        // Date jDuration;
        // DateFormat df = new SimpleDateFormat("hh:mm");
        long diff = (jArrival.getTime() - jDeparture.getTime())/60000;
        long hour = diff/60;
        long mins = diff - (hour*60);
        String tem = "";
        if(hour>=0 && mins>=0)
        {
            tem = ""+hour+" hours and "+mins+" mins";
        }
        else
        {
            tem = "You have entered an invalid Departure or Arival time";
        }
        return tem;
    }
    //Function to diplay the values
    public void disp() throws ParseException,IOException
    {
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        System.out.println("Your Flight Details are as Follows:");
        System.out.println("Company Name:\t"+jComp);
        System.out.println("Model No.:\t"+jModel);
        System.out.println("Capacity of the Plane:\t"+jCapacity);
        System.out.println("Cost per head:\t"+jPPT);
        System.out.println("Departure City:\t"+jDCity);
        System.out.println("Departure Time:\t"+df.format(jDeparture));
        System.out.println("Arrival City:\t"+jACity);
        System.out.println("Arrival Time:\t"+df.format(jArrival));
        System.out.println("Duration:\t"+duration());
        if((jPass1!="")&&(jPass2=="")&&(jPass3==""))
        {
            System.out.println("Passenger is:\t"+jPass1);
            System.out.println("Total Cost = "+(1*jPPT));
        }
        else if((jPass1!="")&&(jPass2!="")&&(jPass3==""))
        {
            System.out.println("Passengers are:\t"+jPass1+" and "+jPass2);
            System.out.println("Total Cost = "+(2*jPPT));
        } 
        else if((jPass1!="")&&(jPass2!="")&&(jPass3!=""))
        {
            System.out.println("Passengers are:\t"+jPass1+" , "+jPass2+" and "+jPass3);
            System.out.println("Total Cost = "+(3*jPPT));
        } 
    }

}
public class AIRPORTSERVICE
{
    public static void addPassenger(AEROPLANE obj) throws ParseException,IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        byte passenger = 0;
        Byte ch;
        // int flag = 0;
        String n1,n2,n3;
        System.out.print("Do you want to add passenger?\n\tIf yes, Enter 1:\t");
        ch = Byte.parseByte(br.readLine());
        if(ch==1)
        {
            System.out.print("How many passengers do you want to add?(max 3)?\t");
            passenger = Byte.parseByte(br.readLine());
            if(passenger == 1)
            {
                System.out.println("Enter name of one passenger");
                n1 = br.readLine();
                obj.addPesenger(n1);
            }
            else if(passenger == 2)
            {
                System.out.println("Enter name of two passenger(Press Enter after Each passenger)");
                n1 = br.readLine();
                n2 = br.readLine();
                obj.addPesenger(n1,n2);
            }
            else if(passenger == 3)
            {
                System.out.println("Enter name of three passenger(Press Enter after Each passenger)");
                n1 = br.readLine();
                n2 = br.readLine();
                n3 = br.readLine();
                obj.addPesenger(n1,n2,n3);
            }
            else
            {
                System.out.println("Wromg Input, try again");
            }
        }
    }
    
    public static void main(String args[]) throws ParseException,IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        AEROPLANE obj = new AEROPLANE();
        byte choice = 0, choice2 = 0, choice3 =0,passenger = 0;
        Byte ch;
        int flag = 0;
        String n1,n2,n3;
      do{
        if(flag == 1)
        {
            System.out.print("Would you like to try Again?(Press 1 to Continue):\t");
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
        System.out.println("Please choose from the following Options:\n\t1.Enter Each Value manually\n\t2.Use Default most used Cities\n\t3.Get Cheapest Ticket for the Location(Spice Jet)\n\t4.Exit");
        System.out.print("\t\tYour Choice:\t");
        choice = Byte.parseByte(br.readLine());
        switch(choice)
        {
            case 1: obj.read();
                    addPassenger(obj);
                    obj.disp();
                    break;
            case 2: System.out.println("Please choose from the following most vistied cities:\n\t1.Bengaluru to Delhi\n\t2.Bengaluru to Mumbai");
                    System.out.print("\t\tYour Choice:\t");
                    choice2 = Byte.parseByte(br.readLine());
                    switch(choice2)
                    {
                        case 1: System.out.println("Select one of the available Departure Timings\n\t1. 10AM\n\t2. 2PM");
                                System.out.print("\t\tYour Choice:\t");
                                choice3 = Byte.parseByte(br.readLine());
                                switch(choice3)
                                {
                                    case 1: AEROPLANE obj2 = new AEROPLANE(df.parse("10:00 am"),"Delhi");
                                            addPassenger(obj2);
                                            obj2.disp();
                                            break;
                                    case 2: AEROPLANE obj3 = new AEROPLANE(df.parse("2:00 pm"),"Delhi");
                                            addPassenger(obj3);
                                            obj3.disp();
                                            break;
                                }
                                break;
                        case 2: System.out.println("Select one of the available Departure Timings\n\t1. 12PM\n\t2. 7PM");
                                System.out.print("\t\tYour Choice:\t");
                                choice3 = Byte.parseByte(br.readLine());
                                switch(choice3)
                                {
                                    case 1: AEROPLANE obj2 = new AEROPLANE(df.parse("12:00 pm"),"Mumbai");
                                            // obj2.disp();
                                            // flag = 1;                                            
                                            addPassenger(obj2);
                                            obj2.disp();
                                            break;
                                    case 2: AEROPLANE obj3 = new AEROPLANE(df.parse("7:00 pm"),"Mumbai");
                                            addPassenger(obj3);
                                            obj3.disp();
                                            // flag = 2;      
                                            break;
                                    default: System.out.println("Invalid Option");        
                                            break;
                                }
                   }       
                    break;
            case 3: System.out.print("Enter your City:\t");
                    String fromloc = br.readLine();
                    System.out.print("Enter the City you want to go to:\t");
                    String destination = br.readLine();
                    AEROPLANE obj4 = new AEROPLANE(fromloc,destination);
                    addPassenger(obj4);
                    obj4.disp();
                    break;
            case 4: System.exit(0);
                    break;
            default:System.out.println("Wrong Option Selected");
                    break;       
        }
    flag = 1;
      }while(choice!=4);
    }
}
