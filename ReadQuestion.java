import java.io.*;
import java.util.*;

public class ReadQuestion {
    private Scanner sc;
    public void readFile(String filename)  {
        try{
            sc = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (filename.equals("out\\production\\OOPSAssignment\\Chemistry.txt"))   {
            while (sc.hasNext()) {
                String type = sc.nextLine();
                Question ques = new Question(type);
                ques.q = sc.nextLine();
                if (type.equals("m")) {
                    ques.a = sc.nextLine();
                    ques.op1 = sc.nextLine();
                    ques.op2 = sc.nextLine();
                    ques.op3 = sc.nextLine();
                    ques.op4 = sc.nextLine();
                }
                else if (type.equals("t"))
                    ques.a = sc.nextLine();
                else if (type.equals("b"))
                    ques.a = sc.nextLine();
                Main.Chemistry.add(ques);
                Main.c++;
            }
        }
        else if (filename.equals("out\\production\\OOPSAssignment\\Physics.txt"))   {
            while (sc.hasNext()) {
                String type = sc.nextLine();
                Question ques = new Question(type);
                ques.q = sc.nextLine();
                if (type.equals("m")) {
                    ques.a = sc.nextLine();
                    ques.op1 = sc.nextLine();
                    ques.op2 = sc.nextLine();
                    ques.op3 = sc.nextLine();
                    ques.op4 = sc.nextLine();
                } else if (type.equals("t"))
                    ques.a = sc.nextLine();
                else if (type.equals("b"))
                    ques.a = sc.nextLine();
                Main.Physics.add(ques);
                Main.p++;
            }
        }
        else if (filename.equals("out\\production\\OOPSAssignment\\Maths.txt"))   {
            while (sc.hasNext()) {
                String type = sc.nextLine();
                Question ques = new Question(type);
                ques.q = sc.nextLine();
                if (type.equals("m")) {
                    ques.a = sc.nextLine();
                    ques.op1 = sc.nextLine();
                    ques.op2 = sc.nextLine();
                    ques.op3 = sc.nextLine();
                    ques.op4 = sc.nextLine();
                } else if (type.equals("t"))
                    ques.a = sc.nextLine();
                else if (type.equals("b"))
                    ques.a = sc.nextLine();
                Main.Maths.add(ques);
                Main.m++;
            }
        }
        sc.close();
    }
}