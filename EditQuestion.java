import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditQuestion {
    String ty, op1, op2, op3, op4, qt, a;
    Question Q;
    EditQuestion(final JFrame f,final String subject, final String e) {
        final int num = Integer.parseInt(e)-1;
        if (subject.equals("Maths")) {
            ty = ((Question) Main.Maths.get(num)).t;
            op1 = ((Question) Main.Maths.get(num)).op1;
            op2 = ((Question) Main.Maths.get(num)).op2;
            op3 = ((Question) Main.Maths.get(num)).op3;
            op4 = ((Question) Main.Maths.get(num)).op4;
            a = ((Question) Main.Maths.get(num)).a;
            qt = ((Question) Main.Maths.get(num)).q;
        }
        else if (subject.equals("Chemistry")) {
            ty = ((Question) Main.Chemistry.get(num)).t;
            op1 = ((Question) Main.Chemistry.get(num)).op1;
            op2 = ((Question) Main.Chemistry.get(num)).op2;
            op3 = ((Question) Main.Chemistry.get(num)).op3;
            op4 = ((Question) Main.Chemistry.get(num)).op4;
            a = ((Question) Main.Chemistry.get(num)).a;
            qt = ((Question) Main.Chemistry.get(num)).q;
        }
        else if (subject.equals("Physics")) {
            ty = ((Question) Main.Physics.get(num)).t;
            op1 = ((Question) Main.Physics.get(num)).op1;
            op2 = ((Question) Main.Physics.get(num)).op2;
            op3 = ((Question) Main.Physics.get(num)).op3;
            op4 = ((Question) Main.Physics.get(num)).op4;
            a = ((Question) Main.Physics.get(num)).a;
            qt = ((Question) Main.Physics.get(num)).q;
        }
        if (ty.equals("m")) {
            JButton back = new JButton("Back");
            JButton sub = new JButton("Submit");
            final JTextField o1 = new JTextField();
            final JTextField o2 = new JTextField();
            final JTextField o3 = new JTextField();
            final JTextField o4 = new JTextField();
            final JTextField ques = new JTextField();
            String[] types = {"Option 1", "Option 2", "Option 3", "Option 4"};
            final JComboBox ans = new JComboBox(types);
            f.setTitle("Edit Question to Quiz");
            JLabel qe = new JLabel();
            JLabel aw = new JLabel();
            JLabel op = new JLabel();
            qe.setText("Question:");
            aw.setText("Select the correct option:");
            op.setText("Options:");
            ques.setText(qt);
            o1.setText(op1);
            o2.setText(op2);
            o3.setText(op3);
            o4.setText(op4);
            qe.setBounds(125, 20, 200, 30);
            ques.setBounds(50, 65, 300, 40);
            aw.setBounds(135, 125, 150, 40);
            ans.setBounds(75, 160, 250, 30);
            op.setBounds(135, 197, 150, 40);
            o1.setBounds(75, 240, 250, 30);
            o2.setBounds(75, 280, 250, 30);
            o3.setBounds(75, 320, 250, 30);
            o4.setBounds(75, 360, 250, 30);
            sub.setBounds(75, 400, 120, 40);
            back.setBounds(205, 400, 120, 40);
            f.add(qe);
            f.add(aw);
            f.add(ques);
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
                    ModifyQuestion mq = new ModifyQuestion(f, subject);
                }
            });
            sub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (ques.getText().equals("") || o1.getText().equals("") || o2.getText().equals("") || o3.getText().equals("") || o4.getText().equals("")) {
                        final JDialog di = new JDialog(f, "Error", true);
                        di.setLayout(new FlowLayout());
                        JButton but = new JButton("OK");
                        but.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                di.setVisible(false);
                            }
                        });
                        JLabel j2 = new JLabel("Error. Enter all the fields.");
                        di.add(j2);
                        but.setBounds(70, 100, 100, 40);
                        j2.setBounds(40, 30, 200, 40);
                        di.setSize(250, 200);
                        di.setLayout(null);
                        di.add(but);
                        di.setVisible(true);
                    } else {
                        Q = new Question(ty);
                        Q.q = ques.getText();
                        Q.op1 = o1.getText();
                        Q.op2 = o2.getText();
                        Q.op3 = o3.getText();
                        Q.op4 = o4.getText();
                        a = (String) ans.getItemAt(ans.getSelectedIndex());
                        if (a.equals("Option 1")) {
                            Q.a = "a";
                        } else if (a.equals("Option 2")) {
                            Q.a = "b";
                        } else if (a.equals("Option 3")) {
                            Q.a = "c";
                        } else if (a.equals("Option 4")) {
                            Q.a = "d";
                        }
                        if (subject.equals("Maths")) {
                            Main.Maths.remove(num);
                            Main.Maths.add(num, Q);
                        } else if (subject.equals("Chemistry")) {
                            Main.Chemistry.remove(num);
                            Main.Chemistry.add(num, Q);
                        } else if (subject.equals("Physics")) {
                            Main.Physics.remove(num);
                            Main.Physics.add(num, Q);
                        }
                        final JDialog d = new JDialog(f, "Question Modified", true);
                        d.setLayout(new FlowLayout());
                        JButton bu = new JButton("OK");
                        bu.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                d.setVisible(false);
                            }
                        });
                        JLabel jl = new JLabel("Question successfully modified.");
                        d.add(jl);
                        bu.setBounds(70, 100, 100, 40);
                        jl.setBounds(30, 30, 200, 40);
                        d.setSize(250, 200);
                        d.setLayout(null);
                        d.add(bu);
                        d.setVisible(true);
                        ques.setText("");
                        o1.setText("");
                        o2.setText("");
                        o3.setText("");
                        o4.setText("");
                        f.getContentPane().removeAll();
                        f.getContentPane().repaint();
                        f.validate();
                        ModifyQuestion w = new ModifyQuestion(f,subject);
                    }
                }
            });
        }
        else if (ty.equals("t")) {
            f.setTitle("Modify a True or False question to Quiz");
            JLabel qe = new JLabel();
            final JTextField qy = new JTextField();
            qy.setText(qt);
            JLabel aw = new JLabel();
            JButton back = new JButton("Back");
            JButton sub = new JButton("Submit");
            qe.setText("Enter the question:");
            aw.setText("Select Answer:");
            final JRadioButton tr = new JRadioButton("True");
            final JRadioButton fa = new JRadioButton("False");
            final ButtonGroup bg = new ButtonGroup();
            bg.add(tr);
            bg.add(fa);
            tr.setBounds(150, 220, 150, 40);
            fa.setBounds(150, 260, 150, 40);
            qe.setBounds(125, 50, 200, 30);
            qy.setBounds(50, 100, 300, 40);
            aw.setBounds(135, 180, 150, 40);
            sub.setBounds(115, 325, 150, 40);
            back.setBounds(115, 400, 150, 40);
            f.add(qe);
            f.add(aw);
            f.add(qy);
            f.add(fa);
            f.add(tr);
            f.add(back);
            f.add(sub);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    ModifyQuestion mq = new ModifyQuestion(f, subject);
                }
            });
            sub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (bg.getSelection()==null || qy.getText().equals(""))	{
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
                        qu.q = qy.getText();
                        if (tr.isSelected())
                            qu.a = "True";
                        else if (fa.isSelected())
                            qu.a = "False";
                        if (subject.equals("Maths")) {
                            Main.Maths.remove(num);
                            Main.Maths.add(num, qu);
                        } else if (subject.equals("Chemistry")) {
                            Main.Chemistry.remove(num);
                            Main.Chemistry.add(num, qu);
                        } else if (subject.equals("Physics")) {
                            Main.Physics.remove(num);
                            Main.Physics.add(num, qu);
                        }
                        qy.setText("");
                        bg.clearSelection();
                        final JDialog d = new JDialog(f, "Question Modified", true);
                        d.setLayout(new FlowLayout());
                        JButton bu = new JButton("OK");
                        bu.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                d.setVisible(false);
                            }
                        });
                        JLabel jl = new JLabel("Question successfully modified.");
                        d.add(jl);
                        bu.setBounds(70, 100, 100, 40);
                        jl.setBounds(30, 30, 200, 40);
                        d.setSize(250, 200);
                        d.setLayout(null);
                        d.add(bu);
                        d.setVisible(true);
                        f.getContentPane().removeAll();
                        f.getContentPane().repaint();
                        f.validate();
                        ModifyQuestion w = new ModifyQuestion(f,subject);
                    }
                }
            });
        }
        else if (ty.equals("b"))    {
            f.setTitle("Modify a Fill in the Blank question to Quiz");
            JLabel qe = new JLabel();
            JLabel ans = new JLabel();
            final JTextField qw = new JTextField();
            qw.setText(qt);
            final JTextField af = new JTextField();
            af.setText(a);
            qe.setText("Enter the question:");
            ans.setText("Enter the answer:");
            JButton back = new JButton("Back");
            JButton sub = new JButton("Submit");
            qe.setBounds(125, 50, 150, 40);
            qw.setBounds(65, 100, 260, 40);
            ans.setBounds(125, 180, 150, 40);
            af.setBounds(65, 230, 260, 40);
            sub.setBounds(115, 330, 150, 40);
            back.setBounds(115, 380, 150, 40);
            f.add(back);
            f.add(sub);
            f.add(qe);
            f.add(ans);
            f.add(af);
            f.add(qw);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    ModifyQuestion mq = new ModifyQuestion(f, subject);
                }
            });
            sub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (qw.getText().equals("") || af.getText().equals(""))	{
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
                        Question qu = new Question(ty);
                        qu.q = qw.getText();
                        qu.a = af.getText();
                        if (subject.equals("Maths"))    {
                            Main.Maths.remove(num);
                            Main.Maths.add(num, qu);
                        }
                        else if (subject.equals("Chemistry"))   {
                            Main.Chemistry.remove(num);
                            Main.Chemistry.add(num, qu);
                        }
                        else if (subject.equals("Physics"))   {
                            Main.Physics.remove(num);
                            Main.Physics.add(num, qu);
                        }
                        qw.setText("");
                        af.setText("");
                        final JDialog d = new JDialog(f, "Question Modified", true);
                        d.setLayout(new FlowLayout());
                        JButton bu = new JButton("OK");
                        bu.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                d.setVisible(false);
                            }
                        });
                        JLabel jl = new JLabel("Question successfully modified.");
                        d.add(jl);
                        bu.setBounds(70, 100, 100, 40);
                        jl.setBounds(30, 30, 200, 40);
                        d.setSize(250, 200);
                        d.setLayout(null);
                        d.add(bu);
                        d.setVisible(true);
                        f.getContentPane().removeAll();
                        f.getContentPane().repaint();
                        f.validate();
                        ModifyQuestion w = new ModifyQuestion(f,subject);
                    }
                }
            });
        }
    }
}