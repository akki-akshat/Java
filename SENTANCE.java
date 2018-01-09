import java.io.*;
import java.lang.String;
import java.lang.StringBuffer;

class SENTANCE
{
    public static void main(String args[]) throws IOException
    {
        String S = null;
        int count = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(isr);
        System.out.print("Enter Desired Sentence:\t");
        S = br.readLine(); 
        System.out.print("\n\tEntered Sentence:\t");
        System.out.println(S);
        String[] words = S.split("\\W+");
        String[] revwords = new String[words.length];
        for (int i = 0; i < words.length; i++)
        {
            System.out.print((i+1)+". Main cword:\t");
            System.out.println(words[i]);
            revwords[i] = new StringBuffer(words[i]).reverse().toString();
            System.out.println(""+revwords[i]);
            System.out.print((i+1)+". Reversed word:\t");
        }  
        System.out.println();
        for (int i = 0; i < words.length; i++)
        {
            if(words[i].equalsIgnoreCase(revwords[i]) == true)
            {
                count++;
                System.out.print("\t"+count);
                System.out.println("Main word:\t"+words[i]);
                System.out.println("\t  Reversed word:\t"+revwords[i]);
            }
        }
        System.out.println("\nTotal Pallendrome words in the sentence:\t"+count);
    }
}   