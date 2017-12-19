import java.io.*;

/*class MyException extends Exception
{
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}*/
class MyException extends Exception{  
	MyException(String s){  
	 super(s);  
	}  
   }
class ExceptionTest1
{

   public static void main(String args[]) throws MyException
   {  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      int a[] = new int[2];
      String str = null;
       int b,c,d; 
	   try
	   {
	      b=Integer.parseInt(br.readLine());
	      c=Integer.parseInt(br.readLine());
		  d=b/c;
		  if(c==0)
		  {
		    throw new MyException("division by zero");
		  }
        System.out.println("Access element three :" + a[1]);
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
	//    catch(ArithmeticException e)
	//    {
	//  	  System.out.println("Exception thrown  ArithmeticException : " + e);
   
	//    }
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