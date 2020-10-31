import javax.swing.*;
import java.awt.event.*;

public class InsertQuestion {
    InsertQuestion(final JFrame f, final String subject)  {
        f.setTitle("Insert a Question");
        JLabel op = new JLabel();
        op.setText("Select the type of question to be inserted:");
        op.setBounds(60, 50, 250, 40);
        f.add(op);
        String[] types = {"Multiple Choice Question", "True or False", "Fill in the blanks"};
        final JComboBox ty = new JComboBox(types);
        ty.setBounds(50, 130, 250, 30);
        f.add(ty);
        JButton b = new JButton("Submit");
        b.setBounds(125, 290, 100, 45);
        f.add(b);
        b.addActionListener(new ActionListener()   {
            public void actionPerformed(ActionEvent e) {
                if (ty.getItemAt(ty.getSelectedIndex()).equals("True or False"))   {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    InsertTF tf = new InsertTF(f, subject);
                }
                else if (ty.getItemAt(ty.getSelectedIndex()).equals("Multiple Choice Question"))    {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    InsertMCQ mcq = new InsertMCQ(f, subject);
                }
                else if (ty.getItemAt(ty.getSelectedIndex()).equals("Fill in the blanks"))  {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    InsertFB fb = new InsertFB(f, subject);
                }
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(125, 370, 100, 45);
        f.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                TeacherLogin tl = new TeacherLogin(f, subject);
            }
        });
    }
}