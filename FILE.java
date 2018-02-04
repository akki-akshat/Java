/*To demonstrate FileInputStream and FileOutput Stream Classes	
    1. use of FileInputStream and FileOutputStream classes              - 2 marks
    2. Writing an object into file and read an object from the file      - 2 marks
*/
import java.io.*;
class STUDENT implements Serializable{
        //Data Members
        int regNo;
        String name;
        String gender;
        int age;
    
        public STUDENT(int reg, String name, String gender, int age) 
        {
            this.regNo = reg;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }    

        public int getReg()
        {
            return this.regNo;
        }

        @Override
        public String toString() {
            return "\n\n**Studnet Details:**\n Name:\t\t" + this.name +  "\n Register No.:\t" + this.regNo + "\n Age:\t\t" + this.age + "\n Gender:\t" + this.gender;
        }
}
public class FILE {
 
    public static void main(String args[]) throws IOException, InterruptedException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte op = 0;
        do {
            System.out.print("\nPlease Enter Your Choice\n" +
                             " 1. Create a new Object and input in the file\n" +  
                             " 2. Read the object from created File\n" +
                             " 3. Write a text File\n" +
                             " 4. Read a file \n" +
                             " 5. Copy one file to another \n" +
                             " 6. Exit\n" +
                             "\tChoice:\t"
                            );
            op = Byte.parseByte(br.readLine());
            switch (op) {
                case 1:
                    System.out.println("\nPlease Enter the following details of the student:");
                    System.out.print("Register No:\t");
                    int reg = Integer.parseInt(br.readLine());
                    System.out.print("Name:\t\t");
                    String name = br.readLine();
                    System.out.print("Gender:\t\t");
                    String gender = br.readLine();
                    System.out.print("Age:\t\t");
                    int age = Integer.parseInt(br.readLine());
                    STUDENT objo = new STUDENT(reg, name, gender, age);
                    // System.out.println(objo);
                    try {
                        System.out.print("Do you want to save object File using Register Number?\nY/n\t");
                        char saver = (char)br.read();
                        br.readLine();
                        String path4 = "";
                        if(saver == 'Y' || saver == 'y')
                        {
                            path4 = "files/"+objo.getReg() ;  
                        }    
                        else
                        {
                            System.out.println("Please enter the path to save the file");
                            path4 = br.readLine();
                        }
                        FileOutputStream output = new FileOutputStream(path4+".ser");
                        BufferedOutputStream bos = new BufferedOutputStream(output);
                        ObjectOutputStream foos = new ObjectOutputStream(bos);
                        foos.writeObject(objo);
                        System.out.println("Object Written Sucessfully\n");
                        foos.flush();
                        foos.close();
                        bos.close();
                        output.close();
                    } catch (Exception e) {
                        System.out.println("Error:\t"+e);
                    }
                    br.readLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                
                case 2:
                       try 
                        {
                            System.out.print("Was the file saved with register no.\nY/n:\t");
                            char retriver = (char)br.read();
                            br.readLine();
                            String path3 = "";
                            if(retriver == 'Y' || retriver == 'y')
                            {
                                System.out.print("Please enter the Register Number:\t");
                                String regn = br.readLine();
                                path3 = "files/"+regn;
                            }
                            else
                            {
                                System.out.println("Please Provide the path of \".ser\" File:");
                                path3 = br.readLine();
                            }
                            FileInputStream input = new FileInputStream(path3+".ser");
                            BufferedInputStream bin=new BufferedInputStream(input);
                            ObjectInputStream fois = new ObjectInputStream(bin);
                            STUDENT obji = (STUDENT)fois.readObject();
                            System.out.println(obji);
                            bin.close();
                            fois.close();
                            input.close();
                        } catch (Exception e) 
                        {
                            System.out.println("Error:\t" +e);
                        }
                        br.readLine();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                   break;

                case 3:
                    System.out.println("Enter the text to be written");
                    String inputS = br.readLine();
                    byte data[] = inputS.getBytes(); 
                    System.out.print("Enter the Name of the file:\t");
                    String path = br.readLine();
                    FileOutputStream output = new FileOutputStream(path+".txt");
                    BufferedOutputStream bos = new BufferedOutputStream(output);
                    bos.write(data);
                    bos.close();
                    bos.flush();
                    output.close();
                    System.out.println("File writing successful");
                    br.readLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 4:
                    System.out.println("Please Enter the path:\t");
                    String path2;
                    path2 = br.readLine();
                    try
                    {
                        FileInputStream fi = new FileInputStream(path2);
                        int line = fi.read();
                        System.out.println("Output of the file:");
                        while(line!=-1)
                        {
                            System.out.print((char)line);
                            line = fi.read();
                        }
                        System.out.println();
                        fi.close();
                    }
                    catch(Exception e)
                    {
                        System.out.print("Error : \t" + e);
                    }
                    br.readLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 5:
                    System.out.print("Enter File path of Source file\t\t");
                    String source = br.readLine();
                    System.out.print("Enter File path of Destination file\t");
                    String dest = br.readLine();
                    FileOutputStream df = new FileOutputStream(dest);
                    FileInputStream sf = new FileInputStream(source);
                    byte[] buffer = new byte[256]; 
                    int count = sf.read(buffer);
                    while(count!=-1)
                    {
                        df.write(buffer,0,count);
                        count = sf.read();
                    }
                    System.out.println("Completed!");
                    br.readLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                       System.out.println("Wrong Option Selected");
                       br.readLine();
                       System.out.print("\033[H\033[2J");
                       System.out.flush();
                    break;
            }
        } while (op!=6);
    }
}