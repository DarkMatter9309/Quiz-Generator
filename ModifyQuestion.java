import javax.swing.*;
import java.awt.event.*;

public class ModifyQuestion {
	int number;
    ModifyQuestion(final JFrame f, final String subject)  {
		f.setTitle("Modify a question in the bank");
		JLabel he = new JLabel();
		he.setText("Select a question number to modify:");
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
		he.setBounds(85, 50, 250, 40);
		num.setBounds(75, 100, 250, 40);
		sub.setBounds(115, 330, 150, 40);
		back.setBounds(115, 400, 150, 40);
		f.add(he);
		f.add(num);
        f.add(back);
        f.add(sub);
		if (number == 0)	{
			JLabel n = new JLabel();
			n.setText("There are no questions to modify");
			n.setBounds(75, 170, 250, 50);
			f.add(n);
			f.remove(sub);
			f.remove(he);
			f.remove(num);
		}
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
				EditQuestion eq = new EditQuestion(f, subject, s);
            }
        });
    }
}