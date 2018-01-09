import java.io.*;
class mARRAY
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int sum = 0;
        int[][] a = new int[3][2];
        int[][] b = new int[3][2];
        int[][] sum = new int[3][2];
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("input for ["+(i+1)+"]["+(j+1)+"]:\t");
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("input for ["+(i+1)+"]["+(j+1)+"]:\t");
                b[i][j] = Integer.parseInt(br.readLine());
            }
        }
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("A:");
        for(int i = 0; i < a.length; i++)
        {
            System.out.println();
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("\t"+a[i][j]);
            }
        }
        System.out.println("\nB:");
        for(int i = 0; i < a.length; i++)
        {
            System.out.println();
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("\t"+b[i][j]);
            }
        }
        System.out.println("\nSUM:");
        for(int i = 0; i < a.length; i++)
        {
            System.out.println();
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.print("\t"+sum[i][j]);
            }
        }
        System.out.println();
    }
}