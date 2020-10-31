import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PrintTest {
    Formatter sc;
    PrintTest(final JFrame f, final String subject, final String e, final int number, final String k) {
        int bound = Integer.parseInt(e);
        final int num = Integer.parseInt(e)-1;
        f.setTitle(subject + " Quiz");
        JTextArea display = new JTextArea();
        JScrollPane sp = new JScrollPane(display);
        JButton back = new JButton("Back");
        JButton qp = new JButton("Generate Question Set");
        JButton ap = new JButton("Generate Answer Set");
        String ans = "";
        String q = "";
        Set<Integer> s = new HashSet<>();
        while(s.size() != bound){
           s.add((int) (Math.random() * number));
        }
        Integer[] arr = s.toArray(new Integer[s.size()]);
        int i=1;
        if (subject.equals("Maths")) {
            for (int j : arr) {
                ans += "(" + i + ") " + Main.Maths.get(j).a + "\n";
                q += "(" + i + ") " + Main.Maths.get(j).q;
                if (Main.Maths.get(j).t.equals("m")) {
                    q += "\na) " + Main.Maths.get(j).op1 + "\n";
                    q += "b) " + Main.Maths.get(j).op2 + "\n";
                    q += "c) " + Main.Maths.get(j).op3 + "\n";
                    q += "d) " + Main.Maths.get(j).op4 + "\n\n\n";
                }
                else if (Main.Maths.get(j).t.equals("t"))    {
                    q += "     (T/F)\n\n";
                }
                else if (Main.Maths.get(j).t.equals("b"))    {
                    q += "\n\n";
                }
                i++;
            }
        }
        else if (subject.equals("Chemistry")) {
            for (int j : arr) {
                ans += "(" + i + ") " + Main.Chemistry.get(j).a + "\n";
                q += "(" + i + ") " + Main.Chemistry.get(j).q;
                if (Main.Chemistry.get(j).t.equals("m")) {
                    q += "\na) " + Main.Chemistry.get(j).op1 + "\n";
                    q += "b) " + Main.Chemistry.get(j).op2 + "\n";
                    q += "c) " + Main.Chemistry.get(j).op3 + "\n";
                    q += "d) " + Main.Chemistry.get(j).op4 + "\n\n\n";
                }
                else if (Main.Chemistry.get(j).t.equals("t"))    {
                    q += "     (T/F)\n\n";
                }
                else if (Main.Chemistry.get(j).t.equals("b"))    {
                    q += "\n\n";
                }
                i++;
            }
        }
        else if (subject.equals("Physics")) {
            for (int j: arr) {
                ans += "(" + i + ") " + Main.Physics.get(j).a + "\n";
                q += "(" + i + ") " + Main.Physics.get(j).q;
                if (Main.Physics.get(j).t.equals("m")) {
                    q += "\na) " + Main.Physics.get(j).op1 + "\n";
                    q += "b) " + Main.Physics.get(j).op2 + "\n";
                    q += "c) " + Main.Physics.get(j).op3 + "\n";
                    q += "d) " + Main.Physics.get(j).op4 + "\n\n\n";
                }
                else if (Main.Physics.get(j).t.equals("t"))    {
                    q += "     (T/F)\n\n";
                }
                else if (Main.Physics.get(j).t.equals("b"))    {
                    q += "\n\n";
                }
                i++;
            }
        }
        back.setBounds(130, 430, 150, 30);
        display.setBounds(10, 10, 370, 360);
        sp.setBounds(10, 10, 370, 360);
        ap.setBounds(20, 390, 175, 30);
        qp.setBounds(200, 390, 175, 30);
        display.setText(q);
        f.add(back);
        f.add(qp);
        f.add(ap);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setVisible(true);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.getContentPane().add(sp);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                GenerateTest tl = new GenerateTest(f, subject, k);
            }
        });
        final String pp = q;
        final String aa = ans;
        qp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sc = new Formatter("out\\production\\OOPSAssignment\\QuestionPaper.txt");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                sc.format(pp);
                sc.close();
            }
        });
        qp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sc = new Formatter("out\\production\\OOPSAssignment\\SolutionSet.txt");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                sc.format(aa);
                sc.close();
            }
        });
    }
}