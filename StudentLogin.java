import javax.swing.*;
import java.awt.event.*;

public class StudentLogin{

    StudentLogin(final JFrame f, final String subject)  {
        f.setTitle("Student Login");
        JLabel s = new JLabel();
        s.setText("The subject selected is:  " + subject);
        s.setBounds(90, 90, 200, 40);
        f.add(s);
        JButton b = new JButton("Generate Test");
        b.setBounds(90, 200, 200, 75);
        f.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                GenerateTest t = new GenerateTest(f, subject, "Student");
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(140, 350, 100, 40);
        f.add(back);
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