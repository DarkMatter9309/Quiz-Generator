import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteQuestion {
    int number;
    DeleteQuestion(final JFrame f, final String subject)  {
        f.setTitle("Delete a question from bank");
        JLabel he = new JLabel();
        he.setText("Select a question number to delete:");
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
        JButton back = new JButton("Back");
        JButton sub = new JButton("Submit");
        he.setBounds(85, 25, 250, 40);
        num.setBounds(75, 70, 250, 30);
        sub.setBounds(115, 365, 150, 40);
        back.setBounds(115, 410, 150, 40);
        f.add(he);
        f.add(num);
        f.add(back);
        f.add(sub);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                TeacherLogin tl = new TeacherLogin(f, subject);
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                String s = (String) num.getItemAt(num.getSelectedIndex());
                ShowDelete sd = new ShowDelete(f, subject, s);
            }
        });
    }
}