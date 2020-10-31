import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InsertFB {
    InsertFB(final JFrame f, final String subject)    {
        f.setTitle("Add a Fill in the Blank question to Quiz");
        JLabel qe = new JLabel();
        JLabel ans = new JLabel();
        final JTextField q = new JTextField();
        final JTextField a = new JTextField();
        qe.setText("Enter the question:");
        ans.setText("Enter the answer:");
        JButton back = new JButton("Back");
        JButton sub = new JButton("Submit");
        qe.setBounds(125, 50, 150, 40);
        q.setBounds(65, 100, 260, 40);
        ans.setBounds(125, 180, 150, 40);
        a.setBounds(65, 230, 260, 40);
        sub.setBounds(115, 330, 150, 40);
        back.setBounds(115, 380, 150, 40);
        f.add(back);
        f.add(sub);
        f.add(qe);
        f.add(ans);
        f.add(a);
        f.add(q);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().repaint();
                f.validate();
                InsertQuestion iq = new InsertQuestion(f, subject);
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if (q.getText().equals("") || a.getText().equals(""))	{
				    final JDialog di = new JDialog(f , "Error", true);
					di.setLayout( new FlowLayout() );
					JButton but = new JButton ("OK");
					but.addActionListener ( new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							di.setVisible(false);
						}
					});
					JLabel j2 = new JLabel ("Error. Enter all the fields.");
					di.add(j2);
					but.setBounds(70, 100, 100, 40);
					j2.setBounds(40, 30, 200, 40);
					di.setSize(250, 200);
					di.setLayout(null);
					di.add(but);
					di.setVisible(true);
				}
				else {
                    Question qu = new Question("t");
                    qu.q = q.getText();
                    qu.a = a.getText();
                    if (subject.equals("Maths"))    {
                        Main.Maths.add(qu);
                        Main.m++;
                    }
                    else if (subject.equals("Chemistry"))   {
                        Main.Chemistry.add(qu);
                        Main.c++;
                    }
                    else if (subject.equals("Physics"))   {
                        Main.Physics.add(qu);
                        Main.p++;
                    }
                    q.setText("");
                    a.setText("");
                    final JDialog d = new JDialog(f, "Question Added", true);
                    d.setLayout(new FlowLayout());
                    JButton bu = new JButton("OK");
                    bu.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            d.setVisible(false);
                        }
                    });
                    JLabel jl = new JLabel("Question successfully added.");
                    d.add(jl);
                    bu.setBounds(70, 100, 100, 40);
                    jl.setBounds(30, 30, 200, 40);
                    d.setSize(250, 200);
                    d.setLayout(null);
                    d.add(bu);
                    d.setVisible(true);
                }
            }
        });
    }
}