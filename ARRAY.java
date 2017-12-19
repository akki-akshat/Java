import java.io.*;
class ARRAY
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = {1,2,3,4,5};
        int sum = 0;
        System.out.println("Please enter the 5 digits:");
        for(int i = 0; i< 5; i++)
        {
            System.out.print("Enter "+(i+1)+" Number: \t");
            // a[i] = Integer.parseInt(br.readLine());
            sum = sum + a[i];
            System.out.println();
        }
        System.out.println("Sum is " + sum);
    }
}