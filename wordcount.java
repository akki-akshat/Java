import java.io.*;
import java.lang.String;
class ABC
{
    private String S;
    ABC(String A)
    {
        S = A;
    }
    public int count()
    {
        int count = 0;
        int n = S.length();
        System.out.println(S.charAt(n-1));
        for(int i=0;i<n-1;i++)
        {
            if(((S.charAt(i)==' ') || (S.charAt(i)=='\t')))
            {
                if(((S.charAt(i+1)!=' ')&&S.charAt(i+1)!='\t'))
                {
                    count++;
                }
            }
        }
        return count+1;
    }
}
class wordcount 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input String\t:");
        String S = br.readLine();
        ABC obj = new ABC(S);
        System.out.println("The count is : "+obj.count());
    }
}