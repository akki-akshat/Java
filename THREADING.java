import java.io.*;

class Multithread1 implements Runnable
{
    public void run()
    {
        try
        {
            System.out.println ("Thread " +
                                Thread.currentThread().getId() +
                                " with name " + 
                                Thread.currentThread().getName() +
                                " has started running.");
            System.out.println("running thread priority is:" +
                                Thread.currentThread().getPriority());
            if(Thread.currentThread().isDaemon())
            {  
                System.out.println("Daemon Thread is running");  
            }
            for(int i = 1;i<10;i++)
            {
                if(Thread.currentThread().isDaemon())
                    try{Thread.sleep(200);}catch(Exception e){ System.out.println("Error"); }
                else
                    try{Thread.sleep(100);}catch(Exception e){ System.out.println("Error"); }
                System.out.println("Ones Thread Output:\t"+i);
            }
 
        }
        catch (Exception e)
        {
            System.out.println ("Error");
        }
    }
}
class Multithread2 extends Thread
{
    public void run()
    {
        try
        {
            System.out.println ("Thread " +
                                Thread.currentThread().getId() +
                                " with name " + 
                                Thread.currentThread().getName() +
                                " has started running.");
            System.out.println("running thread priority is:" +
                                Thread.currentThread().getPriority());
            for(int i = 10;i<100;i+=10)
            {
                try{Thread.sleep(100);}catch(Exception e){ System.out.println("Error"); }
                System.out.println("Tens Thread Output:\t"+i);
            }
        }
        catch (Exception e)
        {
            System.out.println ("Error:"+e);
        }
    }
}

class Multithread3 extends Thread
{
    public void run()
    {
        try
        {
            System.out.println ("Thread " +
                                Thread.currentThread().getId() +
                                " with name " + 
                                Thread.currentThread().getName() +
                                " has started running.");
            System.out.println("running thread priority is:" +
                                Thread.currentThread().getPriority());                      
            for(int i = 100;i<1000;i+=100)
            {
                try{Thread.sleep(100);}catch(Exception e){ System.out.println("Error"); }
                System.out.println("Hundreds Thread Output:\t"+i);
            }
        }
        catch (Exception e)
        {
            System.out.println ("Error:"+e);
        }
    }
}


class THREADING
{
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Creating Threads
        Thread t1 = new Thread(new Multithread1());
        Multithread2 t2 = new Multithread2();
        Multithread3 t3 = new Multithread3();
        //Naming Threads
        t1.setName("Ones");
        t2.setName("Tens");
        t3.setName("Hundreds");
        byte op = 0;
        try{Thread.sleep(100);}catch(Exception e){ System.out.println("Error"); }
        System.out.print("Please Chhose from the following:\n" +
                         "1. Run according to Priority.\n" + 
                         "2. Run Without giving Priority.\n" + 
                         "3. Implementation using Daemon and Priority.\n" + 
                         "4. Exit\n" + 
                         "\tChoice:\t");
        op = Byte.parseByte(br.readLine());
            switch (op) 
            {
                case 1:
                    //Setting Thread Priority 
                    t1.setPriority(Thread.MAX_PRIORITY);
                    t2.setPriority(Thread.NORM_PRIORITY);
                    t3.setPriority(Thread.MIN_PRIORITY);
                    //Starting a thread
                    t1.start();
                    t2.start();
                    t3.start();
                    break;

                case 2:
                    t1.start();
                    t2.start();
                    t3.start();
                    break;
                
                case 3: 
                    t1.setDaemon(true);
                    t1.setPriority(1);
                    t2.setPriority(10);
                    t3.setPriority(8);
                    t1.start();                         //Daemon Thread
                    t2.start();
                    t3.start();
                    break;

                case 4:
                    System.exit(0);
            
                default:
                    System.out.println("Wrong Option, please select a valid option");
                    break;
            }
    }
}