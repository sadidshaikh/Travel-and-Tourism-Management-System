package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomer extends JFrame implements ActionListener {

    private String username;
    private JLabel ansUsername, ansCountry, ansaddress, ansid, ansnumber;
    private JLabel ansphone, ansgender, ansemail, ansname;
    private JButton delete, back;

    ViewCustomer(String username) {
        this.username = username;

        setSize(875, 670);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("View Personal Details");
        heading.setBounds(290, 7, 300, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 24));
        heading.setForeground(Color.BLUE);
        add(heading);


        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(100, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        ansUsername = new JLabel();
        ansUsername.setBounds(250, 80, 200, 25);
        ansUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansUsername);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(440, 80, 150, 25);
        lblCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblCountry);

        ansCountry = new JLabel();
        ansCountry.setBounds(590, 80, 200, 25);
        ansCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansCountry);


        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(100, 140, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        ansid = new JLabel();
        ansid.setBounds(250, 140, 200, 25);
        ansid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansid);

        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(440, 140, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbladdress);

        ansaddress = new JLabel();
        ansaddress.setBounds(590, 140, 200, 25);
        ansaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansaddress);


        JLabel lblnumber = new JLabel("ID Number :");
        lblnumber.setBounds(100, 200, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        ansnumber = new JLabel();
        ansnumber.setBounds(250, 200, 200, 25);
        ansnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansnumber);

        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(440, 200, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        ansphone = new JLabel();
        ansphone.setBounds(590, 200, 200, 25);
        ansphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansphone);


        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(100, 260, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);

        ansgender = new JLabel();
        ansgender.setBounds(250, 260, 200, 25);
        ansgender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansgender);

        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(440, 260, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblemail);

        ansemail = new JLabel();
        ansemail.setBounds(590, 260, 200, 25);
        ansemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansemail);


        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(100, 320, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        ansname = new JLabel();
        ansname.setBounds(250, 320, 200, 25);
        ansname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(ansname);


        // Buttons
        delete = new JButton("Delete ?");
        delete.setBounds(220, 380, 140, 32);
        delete.setFont(new Font("San Serif", Font.BOLD, 18));
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setFocusable(false);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        delete.setEnabled(false);
        add(delete);

        back = new JButton("Back");
        back.setBounds(500, 380, 140, 32);
        back.setFont(new Font("San Serif", Font.BOLD, 18));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // Bottom Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        ImageIcon i2 = new ImageIcon(i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT));

        JLabel image = new JLabel(i2);
        image.setBounds(130, 450, 600, 200);
        add(image);


        // Display name and username;
        try {
            ResultSet user = getUser(username, "account");
            assert user != null;
            ansUsername.setText(user.getString(2));
            ansname.setText(user.getString(3));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get rest of the user data to display
        try {
            ResultSet user = getUser(username, "customer");
            if (user != null) {
                ansid.setText(user.getString(2));
                ansnumber.setText(user.getString(3));
                ansgender.setText(user.getString(5));
                ansCountry.setText(user.getString(6));
                ansaddress.setText(user.getString(7));
                ansphone.setText(user.getString(8));
                ansemail.setText(user.getString(9));
                delete.setEnabled(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    private ResultSet getUser(String username, String table) {
        try {
            Connection con = Conn.getConnection();
            String query = "SELECT * FROM " + table + " WHERE username=?";

            PreparedStatement pre_stmt = con.prepareStatement(query);
            pre_stmt.setString(1, username);

            ResultSet user = pre_stmt.executeQuery();

            if (user.next()) {
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void deleteDetails(String username) {
        try {
            Connection con = Conn.getConnection();
            String query = "DELETE FROM customer WHERE username=?";

            PreparedStatement pre_stmt = con.prepareStatement(query);
            pre_stmt.setString(1, username);

            pre_stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure, you want to delete " +
                    "all the customer details ?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (response == 0) {
                deleteDetails(username);
                JOptionPane.showMessageDialog(null, "Customer details deleted successfully");
                delete.setEnabled(false);
                dispose();
            }

        } else if (e.getSource() == back) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("Sadid");
    }

}
