import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Main    {
    public static int c = 0, m = 0, p = 0;
    public static ArrayList <Question> Chemistry = new ArrayList <Question>();
    public static ArrayList <Question> Maths = new ArrayList <Question>();
    public static ArrayList <Question> Physics = new ArrayList <Question>();
    public static void main(String[] args) {
        JFrame f = new JFrame("Login Page");
        f.setLayout(null);
        f.setSize(400, 500);
        ReadQuestion rq = new ReadQuestion();
        rq.readFile("out\\production\\OOPSAssignment\\Chemistry.txt");
        rq.readFile("out\\production\\OOPSAssignment\\Maths.txt");
        rq.readFile("out\\production\\OOPSAssignment\\Physics.txt");
        LoginPage lp = new LoginPage(f);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)    {
                WriteQuestion wq = new WriteQuestion();
                wq.writeFile("out\\production\\OOPSAssignment\\Chemistry.txt");
                wq.writeFile("out\\production\\OOPSAssignment\\Maths.txt");
                wq.writeFile("out\\production\\OOPSAssignment\\Physics.txt");
            }
        });
    }
}