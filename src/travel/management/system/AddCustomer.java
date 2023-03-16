package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    private String username;
    private JComboBox<String> comboId;
    private JTextField tfnumber, tfCountry, tfAddres, tfUsername, tfName, tfPhone, tfEmail;
    private JRadioButton rmale, rfemale;
    private JButton addButton, backButton;

    AddCustomer(String username) {
        this.username = username;

        setSize(850, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("Add Personal Details");
        heading.setBounds(95, 15, 300, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        tfUsername = new JTextField();
        tfUsername.setBounds(220, 80, 180, 25);
        tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfUsername.setBackground(new Color(213, 213, 213));
        add(tfUsername);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(30, 120, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        comboId = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboId.setBounds(220, 120, 180, 25);
        comboId.setFont(new Font("Tahome", Font.PLAIN, 16));
        comboId.setBackground(Color.white);
        add(comboId);

        JLabel lblnumber = new JLabel("ID Number:");
        lblnumber.setBounds(30, 160, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 160, 180, 25);
        tfnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfnumber);

        JLabel name = new JLabel("Name:");
        name.setBounds(30, 200, 150, 25);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(220, 200, 180, 25);
        tfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfName.setBackground(new Color(213, 213, 213));
        add(tfName);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30, 240, 150, 25);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 240, 70, 25);
        rmale.setFont(new Font("Tahoma", Font.BOLD, 14));
        rmale.setBackground(Color.WHITE);
        rmale.setFocusable(false);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(290, 240, 80, 25);
        rfemale.setFont(new Font("Tahoma", Font.BOLD, 14));
        rfemale.setBackground(Color.WHITE);
        rfemale.setFocusable(false);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(30, 280, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220, 280, 180, 25);
        tfCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfCountry);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 320, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblAddress);

        tfAddres = new JTextField();
        tfAddres.setBounds(220, 320, 180, 25);
        tfAddres.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfAddres);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(30, 360, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220, 360, 180, 25);
        tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 400, 150, 25);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 400, 180, 25);
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfEmail);


        addButton = new JButton("Add");
        addButton.setBounds(75, 465, 100, 25);
        addButton.setFont(new Font("San Serif", Font.BOLD, 16));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setFocusable(false);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(210, 465, 100, 25);
        backButton.setFont(new Font("San Serif", Font.BOLD, 16));
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setFocusable(false);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);


        // Image on the right side of the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);


        // Getting the username and name from the database as soon as the frame opens
        try {
            ResultSet user = getUser(username, "account");

            assert user != null;
            tfUsername.setText(username);
            tfUsername.setEditable(false);
            tfName.setText(user.getString(3));
            tfName.setEditable(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    private ResultSet getUser(String username, String table) {
        try {
            String query = "SELECT * FROM " + table + " WHERE username=?";

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
        if (e.getSource() == addButton) {

            String username = tfUsername.getText();
            String name = tfName.getText();
            String id = (String) comboId.getSelectedItem();
            String id_number = tfnumber.getText();
            String country = tfCountry.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String address = tfAddres.getText();
            String gender = "";
            if (rmale.isSelected()) gender = "Male";
            else if (rfemale.isSelected()) gender = "Female";

            if (id_number.equals("") || country.equals("")
                    || phone.equals("") || email.equals("") || gender.equals("") || address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    ResultSet user = getUser(username, "customer");
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "Details already saved, try updating",
                                "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Connection con = Conn.getConnection();
                        String query = "INSERT INTO customer value(?,?,?,?,?,?,?,?,?)";

                        PreparedStatement pre_stmt = con.prepareStatement(query);
                        pre_stmt.setString(1, username);
                        pre_stmt.setString(2, id);
                        pre_stmt.setString(3, id_number);
                        pre_stmt.setString(4, name);
                        pre_stmt.setString(5, gender);
                        pre_stmt.setString(6, country);
                        pre_stmt.setString(7, address);
                        pre_stmt.setString(8, phone);
                        pre_stmt.setString(9, email);

                        pre_stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Details added successfully");
                        dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == backButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new AddCustomer("devil");
    }
}