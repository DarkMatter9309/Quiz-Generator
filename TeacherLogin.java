import javax.swing.*;
import java.awt.event.*;

public class TeacherLogin{
    TeacherLogin(final JFrame f, final String subject) {
        f.setTitle("Select Functionality");
        JLabel s = new JLabel();
        s.setText("The subject selected is:  " + subject);
        s.setBounds(90, 30, 200, 40);
        f.add(s);
        String types[] = {"Multiple Choice Questions", "True or False", "Fill in the Blanks"};
        JButton back = new JButton("Back");
        JButton i = new JButton("Insert a Question");
        JButton m = new JButton("Modify a Question");
        JButton d = new JButton("Delete a Question");
        JButton gt = new JButton("Generate Test");
        back.setBounds(150, 400, 70, 30);
        i.setBounds(110, 90, 150, 40);
        m.setBounds(110, 165, 150, 40);
        d.setBounds(110, 240, 150, 40);
        gt.setBounds(110, 315, 150, 40);
        f.add(back);
        f.add(m);
        f.add(d);
        f.add(i);
        f.add(gt);
        i.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                InsertQuestion t = new InsertQuestion(f, subject);
            }
        });
        m.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                ModifyQuestion mq = new ModifyQuestion(f, subject);
            }
        });
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                DeleteQuestion dq = new DeleteQuestion(f,subject);
            }
        });
        gt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                GenerateTest t = new GenerateTest(f, subject, "Teacher");
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                LoginPage lop = new LoginPage(f);
            }
        });
    }
}