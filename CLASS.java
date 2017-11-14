/*
Question : Defvine a class student with the following:  
           Private members                 : Roll. Name, Course and 3 marks
           Public Functions : Calculate()  : overall percentage of marks
                              Read()       : Read Data
                              Dis()        : Display the data
*/                     

import java.io.*;
class Student
{
    private short sRoll;
    private String sName,sCourse;
    private byte sMarks1,sMark2,sMark3;

    public void read() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Roll No.:\t");
        sRoll = Short.parseShort(br.readLine());
        System.out.println("Enter the Name:\t");
        sName=br.readLine();
        System.out.println("Enter the Course:\t");
        sCourse=br.readLine();
        System.out.println("Enter the Marks for Subject 1:\t");
        sMarks1=Byte.parseByte(br.readLine());
        System.out.println("Enter the Marks for Subject 2:\t");
        sMark2=Byte.parseByte(br.readLine());
        System.out.println("Enter the Marks for Subject 3:\t");
        sMark3=Byte.parseByte(br.readLine());
    }
    public float Calc()
    {
        return (sMarks1 + sMark2 + sMark3)/3;
    }
    public void Disp()
    {
        System.out.println("Roll NO. = " + sRoll);
        System.out.println("Name = " + sName);
        System.out.println("Course Selected = " + sCourse);
        System.out.println("Marks in Subject 1 = " + sMarks1);
        System.out.println("Marks in Subject 2 = " + sMark2);
        System.out.println("Marks in Subject 3 = " + sMark3);
        System.out.println("Percentage = " + Calc());
    }
}
public class CLASS
{
    public static void main(String args[]) throws IOException
    {
        Student obj = new Student();
        obj.read();
        obj.Disp();
    }
}