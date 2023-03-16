package travel.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class Signup extends JFrame implements ActionListener {

    private JButton create, back;
    private JTextField tfUsername, tfName, tfAnswer;
    private JPasswordField pfPassword;
    private Choice security;

    Signup() {
        setSize(900, 420);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // ----------------------------- left panel -----------------------------------
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 420);
        p1.setBackground(new Color(131, 193, 223));
        p1.setLayout(null);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahona", Font.BOLD, 15));
        lblUsername.setBounds(60, 45, 125, 25);
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(200, 45, 180, 25);
        tfUsername.setBorder(new LineBorder(new Color(210, 210, 210)));
        p1.add(tfUsername);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahona", Font.BOLD, 15));
        lblName.setBounds(60, 85, 125, 25);
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 85, 180, 25);
        tfName.setBorder(new LineBorder(new Color(210, 210, 210)));
        p1.add(tfName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahona", Font.BOLD, 15));
        lblPassword.setBounds(60, 125, 125, 25);
        p1.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(200, 125, 180, 25);
        pfPassword.setBorder(new LineBorder(new Color(210, 210, 210)));
        p1.add(pfPassword);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setFont(new Font("Tahona", Font.BOLD, 15));
        lblSecurity.setBounds(60, 165, 135, 25);
        p1.add(lblSecurity);

        security = new Choice();
        security.add("Fav Character from The Boys");
        security.add("Favorite Marvel Superhero");
        security.add("Your Lucky Number");
        security.add("Your childhood superhero");
        security.setBounds(200, 165, 180, 25);
        security.setFocusable(false);
        p1.add(security);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahona", Font.BOLD, 15));
        lblAnswer.setBounds(60, 205, 125, 25);
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(200, 205, 180, 25);
        tfAnswer.setBorder(new LineBorder(new Color(210, 210, 210)));
        p1.add(tfAnswer);

        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(131, 193, 253));
        create.setBounds(80, 275, 100, 30);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBorder(new LineBorder(new Color(135, 135, 135)));
        create.setFocusable(false);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(131, 193, 253));
        back.setBounds(250, 275, 100, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBorder(new LineBorder(new Color(135, 135, 135)));
        back.setFocusable(false);
        back.addActionListener(this);
        p1.add(back);

        // ----------------------------- right panel -----------------------------------
        JPanel p2 = new JPanel();
        p2.setBounds(500, 0, 400, 420);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        add(p2);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        JLabel image = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        image.setBounds(90, 85, 230, 230);
        p2.add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String username = tfUsername.getText();
            String name = tfName.getText();
            String answer = tfAnswer.getText().toLowerCase();
            String question = security.getSelectedItem();
            String password = new String(pfPassword.getPassword());

            String query = "INSERT INTO account(username, name, password, question, answer) " + "values(?, ?, ?, ?, ?)";

            try {
                Connection con = Conn.getConnection();
                PreparedStatement pre_stmt = con.prepareStatement(query);

                pre_stmt.setString(1, username);
                pre_stmt.setString(2, name);
                pre_stmt.setString(3, password);
                pre_stmt.setString(4, question);
                pre_stmt.setString(5, answer);

                pre_stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();

            } catch (SQLIntegrityConstraintViolationException ex) {

                JOptionPane.showMessageDialog(null, "Username already taken");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
