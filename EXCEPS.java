/*
 Implementation of Exceptions
1. use of the keywords   try, catch, finally, throw, throws - 1 marks
2. use of any six built in exceptions -  1.5  marks
3. implementation of a user defined exception - 1.5 marks
*/

import java.io.*;                  //Basic IO Class
import java.sql.Time;              //Class for Time
import java.util.Scanner;          //IO using scanner       
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class MyException extends Exception
{
    public MyException(String s)
    {
        super(s);
    }
}

class EXCEPS
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        byte op = 0;
        int a,b,c = 0,d,age;
        String str = null;
        Date dat;
        int[] arr = new int[5];
        do
        {
            System.out.println("Please choose from the following:");
            System.out.println("\t1. AirthematicError: Division By 0");
            System.out.println("\t2. NullPointer Exception");
            System.out.println("\t3. NumberFormat Exception");
            System.out.println("\t4. Array Out of Bound");
            System.out.println("\t5. StringIndexOutOfBound Exception");
            System.out.println("\t6. ParseException");
            System.out.println("\t7. Custom Error: Invalid Driving Age Exception");
            System.out.println("\t8. Exit");
            System.out.print("\t\tYour Choice:\t\t");
            op=Byte.parseByte(br.readLine());
            switch(op)
            {
                case 1:
                    try
                    {
                        System.out.println("Please Enter Quitient followed by divisor:");
                        a=Integer.parseInt(br.readLine());
                        b=Integer.parseInt(br.readLine());
                        c=a/b;
                        System.out.println(a +"/" + b +" is " +c);
                    } 
                    catch(ArithmeticException e)
                    {
                        System.out.println("Airthematic Error:\t" + e);
                    }
                    break;
                case 2:
                    try 
                    {
                        System.out.println(str.length());
                    } 
                    catch (NullPointerException e) 
                    {
                        System.out.println("Null Pointer Error:\t" + e);
                    }
                    break;
                case 3:
                    try 
                    {
                        System.out.println("Enter String instead of Number");
                        d=Integer.parseInt(br.readLine());
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Number Format Error:\t" + e);
                    }
                    break;
                case 4:
                    try 
                    {
                        System.out.println("Access element 10 when size is 5:" + arr[10]);
                    } 
                    catch (ArrayIndexOutOfBoundsException e) 
                    {
                        System.out.println("Array Out of Bound Error:\t" + e);
                    }
                    break;
                case 5:
                    try 
                    {
                        String s = "This is a trial";    // length is 15
                        char ch = s.charAt(20); 
                        System.out.println(ch);
                    }
                    catch(StringIndexOutOfBoundsException e) 
                    {
                        System.out.println("String Out Of Bounds Error:\t"+e);
                    }
                    break;
                case 6:
                    try 
                    {
                        DateFormat df = new SimpleDateFormat("hh:mm aa");
                        System.out.print("Please Enter Time in hh:mm aa format:\t");
                        String arrival = br.readLine();
                        dat = df.parse(arrival);
                        System.out.println("Arrival Time:\t"+df.format(dat));
                    }
                    catch(ParseException e) 
                    {
                        System.out.println("Parsing Error:\t"+e);
                    }
                    break;
                case 7:
                    try
                    {
                        System.out.print("Please Enter Your age:\t");
                        age=Integer.parseInt(br.readLine());
                        if(c<18)
                        {
                          throw new MyException("Not valid for Driving");
                        }
                    }
                    catch(MyException e)
                    {
                        System.out.print("This Error States that:\t");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("**Invalid Choice Try Again**");
            }
        }while(op!=8);
            try 
            {
                System.out.println("Please Enter 0 to check for Final BLock");
                int m = Integer.parseInt(br.readLine());
                int k = 5/m;
            } 
            catch (Exception e) 
            {
                System.out.println("General Exception\t"+e);
            }
            finally
            {
                  System.out.println("In the final block"); 
            }
    }
}