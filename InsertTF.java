import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InsertTF{
    InsertTF(final JFrame f, final String subject) {
        f.setTitle("Add a True or False question to Quiz");
        JLabel qe = new JLabel();
        final JTextField q = new JTextField();
        JLabel a = new JLabel();
        JButton back = new JButton("Back");
        JButton sub = new JButton("Submit");
        qe.setText("Enter the question:");
        a.setText("Select Answer:");
        final JRadioButton tr = new JRadioButton("True");
        final JRadioButton fa = new JRadioButton("False");
        final ButtonGroup bg = new ButtonGroup();
        bg.add(tr);
        bg.add(fa);
        tr.setBounds(150, 220, 150, 40);
        fa.setBounds(150, 260, 150, 40);
        qe.setBounds(125, 50, 200, 30);
        q.setBounds(50, 100, 300, 40);
        a.setBounds(135, 180, 150, 40);
        sub.setBounds(115, 325, 150, 40);
        back.setBounds(115, 400, 150, 40);
        f.add(qe);
        f.add(a);
        f.add(q);
        f.add(fa);
        f.add(tr);
        f.add(back);
        f.add(sub);
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
				if (bg.getSelection()==null || q.getText().equals(""))	{
					final JDialog di = new JDialog(f , "Error", true);
					di.setLayout( new FlowLayout() );
					JButton but = new JButton ("OK");
					but.addActionListener ( new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							di.setVisible(false);
						}
					});
					JLabel j2 = new JLabel ("Error. Try again.");
					di.add(j2);
					but.setBounds(70, 100, 100, 40);
					j2.setBounds(70, 30, 150, 40);
					di.setSize(250, 200);
					di.setLayout(null);
					di.add(but);
					di.setVisible(true);
				}
				else {
                    Question qu = new Question("t");
                    qu.q = q.getText();
                    if (tr.isSelected())
                        qu.a = "True";
                    else if (fa.isSelected())
                        qu.a = "False";
                    if (subject.equals("Maths")) {
                        Main.Maths.add(qu);
                        Main.m++;
                    } else if (subject.equals("Chemistry")) {
                        Main.Chemistry.add(qu);
                        Main.c++;
                    } else if (subject.equals("Physics")) {
                        Main.Physics.add(qu);
                        Main.p++;
                    }
                    q.setText("");
                    bg.clearSelection();
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
