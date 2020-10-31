import javax.swing.*;
import java.awt.event.*;

public class LoginPage {
    private String username, password, subject;

    LoginPage(final JFrame f) {
        f.setTitle("Login Page");
        String subjects[] = {"Physics", "Chemistry", "Maths"};
        final JComboBox cb = new JComboBox(subjects);
        JLabel lb = new JLabel();
        final JLabel lg = new JLabel();
        lg.setText("Enter login credentials");
        lg.setBounds(110, 160, 200, 20);
        lb.setText("Select a subject");
        lb.setBounds(120, 30, 150, 20);
        cb.setBounds(100, 70, 150, 20);
        f.add(cb);
        f.add(lb); f.add(lg);
        setSubject("Physics");
        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sub = (String) cb.getItemAt(cb.getSelectedIndex());
                setSubject(sub);
            }
        });
        JLabel u = new JLabel();
        JLabel p = new JLabel();
        final JTextField usr = new JTextField();
        final JPasswordField pwd = new JPasswordField();
        p.setBounds(30, 250, 100, 20);
        p.setText("Enter Password:");
        pwd.setBounds(150, 250, 150, 20);
        u.setBounds(30, 200, 100, 20);
        u.setText("Enter Username:");
        usr.setBounds(150, 200, 150, 20);
        f.add(usr);
        f.add(u);
        f.add(pwd);
        f.add(p);
        final JButton b = new JButton("Login");
        f.add(b);
        b.setBounds(115, 300, 150, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton b = (JButton) e.getSource();
                    String user = usr.getText();
                    String pass = new String(pwd.getPassword());
                    setUsername(user);
                    setPassword(pass);
                    if (username.equals("username") && password.equals("password")) {
                        f.getContentPane().removeAll();
                        f.getContentPane().repaint();
                        f.validate();
                        TeacherLogin t = new TeacherLogin(f, subject);
                    }
                    else    {
                        lg.setText("Invalid Credentials. Try Again");
                        usr.setText("");
                        pwd.setText("");
                    }
                }
            }
        });
        JLabel or = new JLabel();
        or.setText("or");
        or.setBounds(185, 355, 50, 20);
        f.add(or);
        JButton st = new JButton("I am a student");
        st.setBounds(115, 400, 150, 40);
        f.add(st);
        st.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.validate();
                    StudentLogin s = new StudentLogin(f, subject);
            }
        });
        f.setVisible(true);
    }

    public void setUsername(String username)  {
        this.username = username;
    }

    public void setPassword(String password)  {
        this.password = password;
    }

    public void setSubject(String subject)  {
        this.subject = subject;
    }
}