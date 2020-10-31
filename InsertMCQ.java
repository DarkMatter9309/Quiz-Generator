import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InsertMCQ {
    InsertMCQ(final JFrame f, final String subject)   {
        f.setTitle("Add a Multiple Choice question to Quiz");
        JLabel qe = new JLabel();
        final JTextField q = new JTextField();
        JLabel a = new JLabel();
        JButton back = new JButton("Back");
        JButton sub = new JButton("Submit");
        String[] types = {"Option 1", "Option 2", "Option 3", "Option 4"};
        final JComboBox ans = new JComboBox(types);
        JLabel op = new JLabel();
        final JTextField o1 = new JTextField();
        final JTextField o2 = new JTextField();
        final JTextField o3 = new JTextField();
        final JTextField o4 = new JTextField();
        qe.setText("Enter the question:");
        a.setText("Select the correct option:");
        op.setText("Enter the options:");
        qe.setBounds(125, 20, 200, 30);
        q.setBounds(50, 65, 300, 40);
        a.setBounds(135, 125, 150, 40);
        ans.setBounds(75, 160, 250, 30);
        op.setBounds(135, 197, 150, 40);
        o1.setBounds(75,240 ,250, 30);
        o2.setBounds(75,280 ,250, 30);
        o3.setBounds(75,320 ,250, 30);
        o4.setBounds(75,360 ,250, 30);
        sub.setBounds(75, 400, 120, 40);
        back.setBounds(205, 400, 120, 40);
        f.add(qe);
        f.add(a);
        f.add(q);
        f.add(back);
        f.add(sub);
        f.add(ans);
        f.add(op);
        f.add(o1);
        f.add(o2);
        f.add(o3);
        f.add(o4);
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
				if (q.getText().equals("") || o1.getText().equals("") || o2.getText().equals("") || o3.getText().equals("") || o4.getText().equals(""))	{
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
				else 	{
                String s = (String) ans.getItemAt(ans.getSelectedIndex());
                Question qu = new Question("m");
                qu.q = q.getText();
                qu.op1 = o1.getText();
                qu.op2 = o2.getText();
                qu.op3 = o3.getText();
                qu.op4 = o4.getText();
                if (s.equals("Option 1")) {
                    qu.a = "a";
                }
                else if (s.equals("Option 2")) {
                    qu.a = "b";
                }
                else if (s.equals("Option 3")) {
                    qu.a = "c";
                }
                else if (s.equals("Option 4")) {
                    qu.a = "d";
                }
                if (subject.equals("Maths"))    {
                    Main.Maths.add(qu);
                    Main.m++;
                }
                else if (subject.equals("Chemistry"))    {
                    Main.Chemistry.add(qu);
                    Main.c++;
                }
                else if (subject.equals("Physics"))    {
                    Main.Physics.add(qu);
                    Main.p++;
                }

                q.setText("");
                o1.setText("");
                o2.setText("");
                o3.setText("");
                o4.setText("");
                final JDialog d = new JDialog(f , "Question Added", true);
                d.setLayout( new FlowLayout() );
                JButton bu = new JButton ("OK");
                bu.addActionListener ( new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        d.setVisible(false);
                    }
                });
                JLabel jl = new JLabel ("Question successfully added.");
                d.add(jl);
                bu.setBounds(70, 100, 100, 40);
                jl.setBounds(30, 30, 200, 40);
                d.setSize(250,200);
                d.setLayout(null);
                d.add(bu);
                d.setVisible(true);
				}
            }
        });
    }
}