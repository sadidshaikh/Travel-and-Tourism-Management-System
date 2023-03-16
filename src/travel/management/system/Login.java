package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    private JButton login, signup, forgotPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;

    Login() {
        setSize(900, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        // ----------------------------- left panel -----------------------------------
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 400, 420);
        p1.setBackground(new Color(131, 193, 223));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        JLabel image = new JLabel(new ImageIcon(i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        image.setBounds(100, 100, 200, 200);
        p1.add(image);

        // ----------------------------- right panel -----------------------------------
        JPanel p2 = new JPanel();
        p2.setBounds(400, 30, 450, 300);
        p2.setLayout(null);
        add(p2);

        // Username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60, 20, 100, 25);
        lblUsername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(60, 60, 300, 30);
        tfUsername.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        tfUsername.setBorder(new LineBorder(new Color(210, 210, 210)));
        p2.add(tfUsername);

        // Password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 110, 100, 25);
        lblPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(60, 150, 300, 30);
        pfPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        pfPassword.setBorder(new LineBorder(new Color(210, 210, 210)));
        p2.add(pfPassword);

        // Buttons
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(131, 193, 223));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        login.setBorder(new LineBorder(new Color(131, 193, 223)));
        login.setFocusable(false);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("SignUp");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(131, 193, 223));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        signup.setBorder(new LineBorder(new Color(131, 193, 223)));
        signup.setFocusable(false);
        signup.addActionListener(this);
        p2.add(signup);

        forgotPassword = new JButton("Forgot Password?");
        forgotPassword.setBounds(130, 250, 160, 30);
        forgotPassword.setBackground(new Color(131, 193, 223));
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 15));
        forgotPassword.setBorder(new LineBorder(new Color(131, 193, 223)));
        forgotPassword.setFocusable(false);
        forgotPassword.addActionListener(this);
        p2.add(forgotPassword);

        setVisible(true);
    }

    private ResultSet getUser(String username) {
        try {
            String query = "SELECT * FROM account WHERE username=?";

            Connection con = Conn.getConnection();

            PreparedStatement pre_stmt = con.prepareStatement(query);
            pre_stmt.setString(1, username);

            ResultSet user = pre_stmt.executeQuery();

            if (user.next()) {
                return user;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = tfUsername.getText();
        String password = new String(pfPassword.getPassword());

        if (e.getSource() == login && !username.equals("") && !password.equals("")) {
            try {

                ResultSet user = getUser(username);
                if (user != null && password.equals(user.getString(4))) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid credentials",
                            "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (e.getSource() == forgotPassword) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}