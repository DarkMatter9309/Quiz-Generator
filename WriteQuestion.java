import java.util.*;

public class WriteQuestion {
    Formatter sc;
    public void writeFile(String filename) {
        try {
            sc = new Formatter(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filename.equals("out\\production\\OOPSAssignment\\Chemistry.txt")) {
            for (Question q: Main.Chemistry)    {
                if (q.t.equals("m")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n"+ q.op1 + "\n"+ q.op2 + "\n"+ q.op3 + "\n"+ q.op4 + "\n");
                }
                if (q.t.equals("t")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
                if (q.t.equals("b")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
            }
        }
        else if (filename.equals("out\\production\\OOPSAssignment\\Maths.txt")) {
            for (Question q: Main.Maths)    {
                if (q.t.equals("m")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n"+ q.op1 + "\n"+ q.op2 + "\n"+ q.op3 + "\n"+ q.op4 + "\n");
                }
                if (q.t.equals("t")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
                if (q.t.equals("b")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
            }
        }
        else if (filename.equals("out\\production\\OOPSAssignment\\Physics.txt")) {
            for (Question q: Main.Physics)    {
                if (q.t.equals("m")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n"+ q.op1 + "\n"+ q.op2 + "\n"+ q.op3 + "\n"+ q.op4 + "\n");
                }
                if (q.t.equals("t")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
                if (q.t.equals("b")) {
                    sc.format(q.t + "\n" + q.q + "\n" + q.a + "\n");
                }
            }
        }
        sc.close();
    }
}
//1747 lines of shit