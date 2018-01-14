import java.io.*;
import java.lang.String;
import java.lang.Math;
class TEST {
    int NUM;
    String str;
 
    void read()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Number:\t");
            NUM = Integer.parseInt(br.readLine());
            System.out.print("Enter the String:\t");
            str = br.readLine();
        }
        catch(IOException e)
        {
            System.out.println("Input Output Error:\t"+e);
        }
        catch(NullPointerException e)
        {
            System.out.println("Null Pointer Error:\t"+e);
        }
    }
    void convertCase()
    {
            char[] s = new char[str.length()];
            s = str.toCharArray();
            String ST = "";
            for(int i = 0; i<str.length(); i++)
            {
                if(Character.isLowerCase(str.charAt(i))==true)
                {
                    char ch = Character.toUpperCase(str.charAt(i));
                    ST = ST + ch;
                }
                else
                {
                    char ch = Character.toLowerCase(str.charAt(i));
                    ST = ST +ch;
                }
            }
            System.out.println("Case Converted String:\t"+ST+"\n");
    }
    void powerDigit()
    {
        int sum = 0;
        double last_digit;
        System.out.println("Internal Working:");
        while(NUM!=0)
        {
            last_digit = NUM % 10;
            System.out.print("Cube of "+last_digit);
            last_digit = Math.pow((int)last_digit,3);
            System.out.println(" is "+last_digit);
            sum = sum + (int)last_digit;
            NUM = NUM/10;
        }
        System.out.println("\tSum of Digits:\t" + sum + "\n");    
    }
    int count()
    {
        try{
            char[] S = str.toLowerCase().toCharArray();
            int coun=0;
            for(int i = 0;i<str.length();i++)
            {
                if((S[i]=='a') || (S[i]=='e') || (S[i]=='i') || (S[i]=='o') || (S[i]=='u'))
                {
                    coun++;
                }
            }
            return coun;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array Out Of Bound Error:\t"+e);
            return 0;
        }
    }
    void display()
    {
        System.out.println("Entered Number = "+NUM);
        System.out.println("Entered String:\t"+str);
    }
}
public class EXAM {
 
    public static void main(String args[])
    {
        try{    
            byte ch=0;
            String s;
            int p,v;
            TEST obj = new TEST();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do{   
                System.out.println("\n\n\tPlease Choose from the options below:");
                System.out.println("1. Read Number and String");
                System.out.println("2. Convert case");
                System.out.println("3. Sum of cubes of Digits");
                System.out.println("4. Number of Vowels");
                System.out.println("5. Display Entered Values");
                System.out.println("6. All Outputs");
                System.out.println("7. Exit");
                System.out.print("\tYour Choice:\t");
                ch = Byte.parseByte(br.readLine());
                System.out.println();
                switch (ch) {
                    case 1:
                        System.out.println("Selected Option: Read");
                        obj.read();
                        System.out.println();
                        obj.display();
                        break;
                    case 2:
                        System.out.println("Selected Option: Convert Case");
                        obj.convertCase();
                        break;
                    case 3:
                        System.out.println("Selected Option: Power Digit");
                        obj.powerDigit();
                        break;
                    case 4:
                        System.out.println("Selected Option: Number of Vowels");
                        v = obj.count();
                        System.out.println("Number of Vowels:\t"+v+" Vowels");
                        break;
                    case 5:
                        System.out.println("Selected Option: Display\n");
                        obj.display();
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Selected Option: All outputs");
                        System.out.println();
                        obj.display();
                        obj.convertCase();
                        obj.powerDigit();
                        int q = obj.count();
                        System.out.println("Number of Vowels:\t"+q+" Vowels");
                        break;
                    case 7:
                        System.out.println("Exiting");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, please choose again.");
                        break;
                }
            }while(ch!=7);
        }
        catch(IOException e)
        {
            System.out.println("Input Output Exception Error:\t"+e);
        }
        catch(NullPointerException e)
        {
            System.out.println("Null Pointer Error:\t"+e);
        }
        catch(Exception e)
        {
            System.out.println("Sorry the following Error has occured:\t"+e);
        }
    }
}