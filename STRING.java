/*
To implement the methods of String class.
1. Implementation of any 10 methods in the String class   
2. Menu interface
*/
import java.io.*;
import java.lang.String;
class STR
{
   void disp()
    {
        System.out.println("\n\n\tPlease Choose an option from below to perform Calculations:\n");
        System.out.println("0.  Enter new string");
        System.out.println("1.  Check if the string is Empty");         //isEmpty
        System.out.println("2.  Know the length of string");            //length
        System.out.println("3.  Trim the string");                      //trim
        System.out.println("4.  Know char at a particuar index");       //charAt
        System.out.println("5.  Copy string to another string");        //intern
        System.out.println("6.  Replace a word in the string");         //replace
        System.out.println("7.  Compare with another String");          //CompareTo
        System.out.println("8.  Compare ignoring case");                //equalsToIgnoreCase
        System.out.println("9.  Print a substring from an index no");   //substring
        System.out.println("10. Concat with another string");           //concat
        System.out.println("11. Display Strings");
        System.out.print("12. Exit\n\tChoice:\t\t");
    }
}

class STRING
{
    public static void main(String args[])  throws IOException,NullPointerException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(isr);
        STR obj = new STR();
        byte choice,ch;
        String s = null,s2 = "Not copied yet",s3,s4;
        int start,end;
        while(true)
        {
            obj.disp();
            choice = Byte.parseByte(br.readLine());
            System.out.println();
            switch(choice)
            {
                case 0:
                    System.out.print("Enter String:\t");
                    s = br.readLine();
                    System.out.println("Entered String:\t" + s);
                    break;
                case 1:
                    if(s.isEmpty()==true)
                    {
                        System.out.println("\nString is Empty, please enter the string again");
                    }
                    else
                    {
                        System.out.println("\nString is not Empty, you may proceed");
                    }
                    break;
                case 2:
                    System.out.println("\nLength of the entered String is:\t"+s.length());
                    break;
                case 3:
                    s = s.trim();
                    System.out.println("\nNew String:\t"+s);
                    break;
                case 4:
                    System.out.print("\nEnter the index of char you want to extract:\t");
                    ch = Byte.parseByte(br.readLine());
                    System.out.println("Char at "+ch+" is:\t"+ s.charAt(ch-1));
                    break;
                case 5:
                    s2 = s.intern();
                    System.out.println("\nYour String has been copied to another string\nNew String:\t"+s2);
                    break;
                case 6:
                    System.out.print("\nEnter string to be replaced:\t");
                    s3 = br.readLine();
                    System.out.print("\nEnter string you want to replace "+s3+" with:\t");
                    s4 = br.readLine();
                    s = s.replace(s3, s4);
                    System.out.println("New String:\t" + s);
                    break;
                case 7:
                    System.out.print("\nEnter the string to be compared with "+s+":\t");
                    s3 = br.readLine();
                    if(s.compareTo(s3)==0)
                    {
                        System.out.println("Entered Strings are Same");
                    }
                    else
                    {
                        System.out.println("Entered Strings are not Same");
                    }
                    break;
                case 8:
                    System.out.print("\nEnter the string to be compared with "+s+"(case insensetive):\t");
                    s3 = br.readLine();
                    if(s.equalsIgnoreCase(s3)==true)
                    {
                        System.out.println("Entered Strings are Same(considering case-insensetive)");
                    }
                    else
                    {
                        System.out.println("Entered Strings are not Same");
                    }
                    break;
                case 9:
                    System.out.print("\nEnter the index to get the substring from(start followed by end)(Enter -1 for end if you don't wont to enter the end):\t");
                    start = Integer.parseInt(br.readLine());
                    end = Integer.parseInt(br.readLine());
                    if(end == -1)
                    {
                        System.out.println("Substring from "+start+" to end is:\t"+s.substring(start));
                    }
                    else
                    {
                        System.out.println("Substring from index"+start+" to end endex"+end+" is:\t"+s.substring(start,end));
                    }
                    break;  
                case 10:
                    System.out.print("\nEnter the String to be concated\t");
                    s3 = br.readLine();
                    s = s.concat(s3);
                    System.out.println("New String:\t" + s);
                    break;
                case 11:
                    System.out.println("String:\t\t" + s);
                    System.out.println("Copied String:\t" + s2);
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option, please try again.");
                    break;
            }
    
        }
        
    }
}