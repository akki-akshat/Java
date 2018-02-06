import java.io.*;
import java.util.Collection;
class STUDENT implements Serializable{
    
    String name;
    int regno;
    int[] marks = new int[3];
    int total = 0;
    STUDENT(){}
    STUDENT(String name, int regno, int mark1, int mark2, int mark3)
    {
        this.name = name;
        this.regno = regno;
        this.marks[0] = mark1;
        this.marks[1] = mark2;
        this.marks[2] = mark3;
        for(int i =0;i<3;i++)
        {
            total+=marks[i];
        }
    }
    @Override
    public String toString()
    {
        return "\t"+name+"\t"+regno+"\t  "+marks[0]+"\t"+marks[1]+"\t"+marks[2];
    }
}
public class STUFILE {
 
    public static void main(String args[]) throws IOException,ClassNotFoundException
    {
        byte ch;
        int sn = 0,i,n=5;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.print("Please choose an option:\n"+
                             " 1. Enter  5 Records\n"+
                             " 2. Display Records\n"+
                             " 3. Display Records in Descending Order\n"+
                             " 4. Exit\n"+
                             "\tChoice\t:"
                            );
            ch = Byte.parseByte(br.readLine());
            switch (ch) {
                case 1:
                    System.out.println("Please Enter the following data");
                    for(i=0;i<n;i++)
                    {
                        int[] mark = new int[3];
                        System.out.print("Enter Name:\t\t\t");
                        String name = br.readLine();
                        System.out.print("Enter Reg No.:\t\t\t");
                        int regno = Integer.parseInt(br.readLine());
                        for(int j=0;j<3;j++)
                        {
                            System.out.print("Enter Marks for subject "+(j+1)+":\t");
                            mark[j] = Integer.parseInt(br.readLine());
                        }
                        STUDENT obji = new STUDENT(name,regno,mark[0],mark[1],mark[2]);
                        FileOutputStream output = new FileOutputStream("files/"+i+".ser");
                        ObjectOutputStream foos = new ObjectOutputStream(output);
                        foos.writeObject(obji);
                        System.out.println("**OBJECT WRITTEN**");
                        foos.flush();
                        foos.close();
                        output.close();
                    }
                    break;

                case 2:
                    System.out.println("Sl.No\tName\tReg No.\tMarks1\tMarks2\tMarks3");
                    for(i=0;i<n;i++)
                    {
                        FileInputStream input = new FileInputStream("files/"+i+".ser");
                        ObjectInputStream fois = new ObjectInputStream(input);
                        STUDENT objo = (STUDENT)fois.readObject();
                        sn++;
                        System.out.print(sn);
                        System.out.println(objo);
                        fois.close();
                        input.close();
                    }  
                    sn = 0;
                    break;

                case 3:
                    int min; 
                    STUDENT[] obj = new STUDENT[5];
                    STUDENT temp = new STUDENT();
                    // int temp;
                    System.out.println("Sl.No\tName\tReg No.\tMarks1\tMarks2\tMarks3\tTotal Marks");
                    for(i=0;i<n;i++)
                    {
                        FileInputStream input = new FileInputStream("files/"+i+".ser");
                        ObjectInputStream fois = new ObjectInputStream(input);
                        obj[i] = (STUDENT)fois.readObject();
                        fois.close();
                        input.close();
                    }  
                    for(i=0; i < n; i++)
                    {       
                        for(int j=1;j<(n-i);j++)
                        {            
                                if(obj[j-1].total > obj[j].total)
                                {  
                                    temp = obj[j-1];  
                                    obj[j-1] = obj[j];  
                                    obj[j] = temp;  
                                }             
                        }
                    }
                    for(i=4;i>=0;i--)
                    {
                        sn++;
                        System.out.print(sn);
                        System.out.print(obj[i]);
                        System.out.println("\t"+obj[i].total);       
                    }
                    
                    
                
                    sn = 0;
                    break;

                case 4:
                    System.exit(0);
                    break;
            
                default:
                    break;
            }    
        }while(ch!=4);
    }
}