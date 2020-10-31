import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class GenerateTest {
    int number;
    GenerateTest(final JFrame f, final String subject, final String k)    {
        f.setTitle(subject + " Quiz");
        JLabel h = new JLabel();
        JButton back = new JButton("Back");
        JButton sub = new JButton("Submit");
        h.setText("How many questions do you want in the test?");
        if (subject.equals("Chemistry"))
            number = Main.c;
        else if (subject.equals("Maths"))
            number = Main.m;
        else
            number = Main.p;
        String[] arr = new String[number];
        for (int i=0; i<number; i++)	{
            arr[i] = i+1 + "";
        }
        final JComboBox num = new JComboBox(arr);
        h.setBounds(55, 50, 290, 40);
        num.setBounds(75, 100, 220, 40);
        sub.setBounds(115, 330, 150, 40);
        back.setBounds(115, 400, 150, 40);
        f.add(back);
        f.add(num);
        f.add(h);
        f.add(sub);
        if (number == 0)	{
            JLabel n = new JLabel();
            n.setText("There are no questions to create a test");
            n.setBounds(75, 170, 250, 50);
            f.add(n);
            f.remove(sub);
            f.remove(h);
            f.remove(num);
        }
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                if (k.equals("Teacher")) {
                    TeacherLogin tl = new TeacherLogin(f, subject);
                } else if (k.equals("Student")) {
                    StudentLogin sl = new StudentLogin(f, subject);
                }
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                String s = (String) num.getItemAt(num.getSelectedIndex());
                PrintTest eq = new PrintTest(f, subject, s, number, k);
            }
        });
    }
}