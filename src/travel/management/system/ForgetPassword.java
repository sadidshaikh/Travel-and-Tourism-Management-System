package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    private JTextField tfusername, tfname, tfsecurity, tfanswer, tfpassword;
    private JButton search, retrieve, back;

    ForgetPassword() {
        setSize(900, 420);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(605, 70, 220, 220);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(20, 30, 530, 320);
        p1.setLayout(null);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 25, 100, 25);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblUsername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 25, 170, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);


        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(390, 25, 100, 25);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setFocusable(false);
        search.addActionListener(this);
        p1.add(search);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 75, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 75, 170, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);


        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(40, 125, 130, 25);
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblsecurity);

        tfsecurity = new JTextField();
        tfsecurity.setBounds(200, 125, 170, 25);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsecurity);


        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 175, 130, 25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(200, 175, 170, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);


        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(390, 175, 100, 25);
        retrieve.setBorder(BorderFactory.createEmptyBorder());
        retrieve.setFocusable(false);
        retrieve.addActionListener(this);
        p1.add(retrieve);


        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 225, 130, 25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 225, 170, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);


        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(200, 275, 100, 25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    private ResultSet getUser(String username) {
        ResultSet user = null;
        try {
            String query = "SELECT * FROM account WHERE username=?";

            Connection con = Conn.getConnection();

            PreparedStatement pre_stmt = con.prepareStatement(query);
            pre_stmt.setString(1, username);

            user = pre_stmt.executeQuery();

            if (user.next()) {
                tfname.setText(user.getString(3));
                tfsecurity.setText(user.getString(5));
            } else {
                tfname.setText("");
                tfsecurity.setText("");
                JOptionPane.showMessageDialog(null, "No user with given username");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = tfusername.getText();
        String answer = tfanswer.getText();

        if (e.getSource() == search && !tfusername.getText().equals("")) {
            getUser(username);
        } else if (!username.equals("") && !answer.equals("") && e.getSource() == retrieve) {

            ResultSet user = getUser(username);

            if (user != null) {
                try {
                    if (answer.toLowerCase().equals(user.getString(6))) {
                        tfpassword.setText(user.getString(4));
                    } else {
                        tfpassword.setText("");
                        JOptionPane.showMessageDialog(null, "Wrong answer");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }

}