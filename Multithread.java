import java.io.*;

// class MultithreadingDemo implements Runnable
// {
//     public void run()
//     {
//         try
//         {
//             // Displaying the thread that is running
//             System.out.println ("Thread " +
//                                 Thread.currentThread().getId() +
//                                 " is running");
 
//         }
//         catch (Exception e)
//         {
//             // Throwing an exception
//             System.out.println ("Exception is caught");
//         }
//     }
// }
 
// // Main Class
// class Multithread
// {
//     public static void main(String[] args)
//     {
//         int n = 8; // Number of threads
//         for (int i=0; i<8; i++)
//         {
//             Thread object = new Thread(new MultithreadingDemo());
//             object.start();
//         }
//     }
// }


// Java code for thread creation by extending
// the Thread class
// class MultithreadingDemo extends Thread
// {
//     public void run()
//     {
//         try
//         {
//             // Displaying the thread that is running
//             System.out.println ("Thread " +
//                   Thread.currentThread().getId() +
//                   " is running");
 
//         }
//         catch (Exception e)
//         {
//             // Throwing an exception
//             System.out.println ("Exception is caught");
//         }
//     }
// }
 
// // Main Class
// public class Multithread
// {
//     public static void main(String[] args)
//     {
//         int n = 8; // Number of threads
//         for (int i=0; i<8; i++)
//         {
//             MultithreadingDemo object = new MultithreadingDemo();
//             object.start();
//         }
//     }
// }

class Odd extends Thread
{
    public void run()
    {
        for(int i=1;i<20;i+=2)
        {
            System.out.println("ODD NUMBER:\t"+i);
        }
    }
}
class Even extends Thread
{
    public void run()
    {
        try
        {
            for(int i=0;i<20;i+=2)
            {
                System.out.println("EVEN NUMBER:\t"+i);
                Thread.sleep(500);
            }
        }
        catch(Exception e)
        {
            System.out.println("Eror");
        }
    }
}
class Multithread {
    public static void main(String[] args) {
        Odd od = new Odd();
        Even ev = new Even();
        od.start();
        ev.start();
    }
}