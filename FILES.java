import java.io.*;
public class FILES
{
public static void main(String[] args)
{
try
{
//example for FileReader and FileWriter class use
/*\\FileReader input = new FileReader(args[0]);
FileWriter output = new FileWriter(args[1]);
char[] buffer = new char[128];
*/
//Example for FileInputStream and FileOutputStream classes

/*FileInputStream input = new FileInputStream(args[0]);
FileOutputStream output = new FileOutputStream(args[1]);
byte[] buffer = new byte[256];

  int charsRead;
charsRead = input.read(buffer);
System.out.println(charsRead);
while ( charsRead != -1 ) 
{
  output.write(buffer, 0, charsRead);
  charsRead = input.read(buffer);
 System.out.println(charsRead);
 }//end of while
 input.close();
 output.close();
*/ 
//Example of BufferedReader and BufferedWrite classes

FileReader input = new FileReader(args[0]);
BufferedReader br=new BufferedReader(input);
FileWriter output = new FileWriter(args[1]);
BufferedWriter bw=new BufferedWriter(output);
String line;
line=br.readLine();
while(line!=null)
{
bw.write(line);
bw.newLine();
System.out.println(line);
line=br.readLine();
}
br.close();
bw.close();


}//end of try
catch(Exception e)
{
System.out.println(e);
}//end of catch





}//end of main
}// end of class