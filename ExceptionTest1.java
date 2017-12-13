import java.io.*;

/*class MyException extends Exception
{
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}*/
class ExceptionTest 
{

   public static void main(String args[]) 
   {  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      int a[] = new int[2];
      String str = null;
       int b,c,d; 
	   try
	   {
	        b=Integer.parseInt(br.readLine());
	       c=Integer.parseInt(br.readLine());
	    //   if(c==0)
		//   {
		// 	  throw new MyException("division by zero");
        	
        //   }
          
	 	  d=b/c;

          System.out.println("Access element three :" + a[33]);
	 	 System.out.println(str.length());
       } 
	   catch (ArrayIndexOutOfBoundsException e)
	   {
          System.out.println("Exception thrown  ArrayIndex:" + e);
       }
	   catch(NullPointerException e)
	   {
	   System.out.println("Exception thrown  NullPointer: " + e);

	   }
	   catch(NumberFormatException e)
	   {
	 	System.out.println("Exception thrown  Number format Exception: " + e);
  
	   }
	   catch(IOException e)
	   {
	 	 System.out.println("Exception thrown  IOException: " + e);
   
	   }
	   catch(ArithmeticException e)
	   {
	 	  System.out.println("Exception thrown  ArithmeticException : " + e);
   
	   }
	   finally
	   {
	 	System.out.println("In the final block");
     
	   }
	  /*catch(MyException e)
	  {
		  System.out.println("Caught");
             // Print the message from MyException object
            System.out.println(e.getMessage());
      }*/
	  System.out.println("Code after exception");
   }
}