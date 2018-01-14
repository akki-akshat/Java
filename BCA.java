/*define a class bca with 1 string data member and one integer data member with following functions:
length()
conertcase():makes upper letter small and small letter upper
pow(): find the sum of the digits of the number and display its square.
replace(): all the vowels in the string with the word 'the'
*/
import java.io.*;
import java.lang.String;

// import javax.sound.midi.Soundbank;

import java.lang.Math;
class BCA
{
    public static int sdigit(int n) 
    {
        int sum = 0;
        double last_digit;
        while(n!=0)
        {
            last_digit = n % 10;
            last_digit = Math.pow((int)last_digit,2);
            sum = sum + (int)last_digit;
            n = n/10;
        }
        return sum;    
    }
    public static void main(String[] args) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int n;
        System.out.print("Enter n:\t");
        n = Integer.parseInt(br.readLine());
        System.out.println("Sum of digits:" + sdigit(n));
        System.out.println("Sqaure of digits is:\t"+Math.pow(sdigit(n),2));
        System.out.println("Enter String");
        s = br.readLine();
        System.out.println("Length is:\t"+s.length());
        char[] str = s.toCharArray();
        // System.out.println(str);
        for(int i = 0;i<s.length();i++)
        {
            if(i%2==0)
            {
                char ch = Character.toUpperCase(s.charAt(i));
                str[i]=ch;
            }
            else
            {
                char ch = Character.toLowerCase(s.charAt(i));
                str[i]=ch;
            }
        }
        System.out.println(s);
        System.out.println(str);
        String[] word = s.split("\\W+");
        for(int i=0; i<word.length; i++)
        {
            if(i%2==0)
            {
                word[i].toUpperCase();
                // System.out.println();
            }
            else
            {
                word[i].toLowerCase();
            }
        }
        for(int i=0; i<word.length; i++)
        {
            System.out.println(word[i]);
        }
        
    }
}
