import java.io.*;
class CLI
{
    public static void main(String[] args)
    {
        int sum=0;
        for(int i=0;i<args.length;i++)
        {
            System.out.println(args[i]);
            sum = sum + Integer.parseInt(args[i]);
        }
        System.out.println(sum);
        System.out.println(args.length);
    }
}