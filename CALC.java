/*
To demonstrate the usage of Math class.	
1. Implementation of any 10 methods from the Math class 
2. Menu interface
*/
import java.io.*;
import java.lang.Math;

class MATH
{
    void disp()
    {   
        System.out.println("\n\n\tPlease Choose an option from below to perform Calculations:\n");
        System.out.println("1.  Generate a random number");
        System.out.println("2.  Power of x raised to y");
        System.out.println("3.  Absolute value of a number");
        System.out.println("4.  Cube root of a number");
        System.out.println("5.  Floor of a number");
        System.out.println("6.  Greatest number between two a number");
        System.out.println("7.  Smallest number between two a number");
        System.out.println("8.  Round the number to its closest value");
        System.out.println("9.  Square root of a number");
        System.out.println("10. Base 10 Log of a number");
        System.out.print("11. Exit\n\tChoice:\t\t");
    }
}
// Main class
class CALC
{
    public static void main(String args[]) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(isr);
        MATH obj = new MATH();
        byte choice,ch;
        while(true)
        {
            obj.disp();
            choice = Byte.parseByte(br.readLine());
            System.out.println();
            double x,y;
            long a;
            switch(choice)
            {
                case 1:
                    if((Math.random()<0.3))
                    {
                        a = Math.round(Math.random()*10); 
                    }
                    if((Math.random()>0.3) && (Math.random()<0.65))
                    {
                        a = Math.round(Math.random()*100); 
                    }
                    else
                    {
                        a = Math.round(Math.random()*1000);
                    }
                    System.out.println("\n Randomly generated number between 1 and 1000 is:\t\t" + a);
                    break;
                case 2:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.round(Math.random()*100);
                        y = Math.round(Math.random()*100);
                    }
                    else
                    {
                        System.out.print("\nPlease Enter the first no.: ");
                        x = Double.parseDouble(br.readLine());
                        System.out.print("Please Enter the second no.: ");
                        y = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe value of " + x + " raised to " + y + " is:\t\t" + Math.pow(x, y));
                    break;
                case 3:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        if(Math.random()<0.5)
                        {
                            x = Math.random()*-100;
                        }
                        else
                        {
                            x = Math.random()*100;
                        }
                    }
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe absolute value of " + x + " is:\t\t" + Math.abs(x));
                    break;
                case 4:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe cube root of " + x + " is:\t\t" + Math.cbrt(x));
                    break;
                case 5:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe Floor of " + x + " is:\t\t" + Math.floor(x));
                    break;
                case 6:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                        y = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("\nPlease Enter the first no.: ");
                        x = Double.parseDouble(br.readLine());
                        System.out.print("Please Enter the second no.: ");
                        y = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe greater number between " + x + " and " + y + " is:\t\t" + Math.max(x, y));
                    break;
                case 7:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                        y = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("Please Enter the first no.:\t");
                        x = Double.parseDouble(br.readLine());
                        System.out.print("Please Enter the second no.:\t");
                        y = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe smallest number between " + x + " and " + y + " is:\t\t" + Math.min(x, y));
                    break;
                case 8:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe round of " + x + " is:\t\t" + Math.round(x));
                    break;
                case 9:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;
                    }
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());
                    }
                    System.out.println("\nThe cube root of " + x + " is:\t\t" + Math.sqrt(x));
                    break;  
                case 10:
                    System.out.print("\nEnter 1 to use random numbers:\t");
                    ch = Byte.parseByte(br.readLine());
                    if(ch == 1)
                    {
                        x = Math.random()*100;                        
                    }   
                    else
                    {
                        System.out.print("\nPlease Enter a number:\t\t");
                        x = Double.parseDouble(br.readLine());                        
                    }                    
                    System.out.println("\nThe base 10 log of " + x + " is:\t\t" + Math.log(x));
                    break;
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option, please try again.");
                    break;
            }
    
        }
        
    }
}