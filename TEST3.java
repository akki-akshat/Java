import java.io.*;
class THRE extends Thread{
    public void run()
    {
        for (int i=0;i<20;i+=2) {
            System.out.println(i);
            try{Thread.sleep(10);}catch(Exception e){ System.out.println("Error"); }    
        }
    }
}
class THRE2 implements Runnable{
    public void run() 
    {
        try {
            for(int i=1;i<20;i+=2)
            {
                System.out.println(i);
                try{Thread.sleep(10);}catch(Exception e){ System.out.println("Error"); }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
public class TEST3 {
    
    public static void main(String args[]) throws IOException
    {
        THRE t1 = new THRE(); //class THREading
        Thread t2 = new Thread(new THRE2()); //runnable
        t1.start();
        t2.start();
        FileOutputStream input = new FileOutputStream("test.txt");
        String a = "HII all";
        byte b[] = a.getBytes();
        input.write(b);
        input.close();
        FileInputStream in = new FileInputStream("test.txt");
        int i = in.read();
        System.out.println("Reading data");
        while(i!=-1)
        {
            System.out.print((char)i);
            i = in.read();
        }
        System.out.println();
    }
}