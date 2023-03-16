package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookPackage extends JFrame {

    private JLabel ansusername, ansid, ansidnumber, ansphone, ansprice;
    private JTextField anspersons;
    private JComboBox<String> comboPackage;
    private String persons, price;
    private int[] packagePrices;
    private String[] packages;
    private boolean showFrame;

    BookPackage(String username) {
        packagePrices = new int[]{32000, 25000, 12000};
        packages = new String[]{"Gold Package", "Silver Package", "Bronze Package"};

        setSize(1000, 570);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("Book Package");
        heading.setBounds(120, 8, 300, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        ansusername = new JLabel("Sadid");
        ansusername.setBounds(220, 80, 180, 25);
        ansusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansusername);


        JLabel lblpackge = new JLabel("Select Package :");
        lblpackge.setBounds(30, 140, 150, 25);
        lblpackge.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackge);

        comboPackage = new JComboBox<>(packages);
        comboPackage.setBounds(220, 140, 180, 25);
        comboPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboPackage.setBackground(Color.white);
        add(comboPackage);


        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setBounds(30, 190, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);

        anspersons = new JTextField("1");
        anspersons.setBounds(220, 190, 180, 25);
        anspersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(anspersons);


        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 240, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        ansid = new JLabel();
        ansid.setBounds(220, 240, 180, 25);
        ansid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansid);


        JLabel lblidnumber = new JLabel("ID Number :");
        lblidnumber.setBounds(30, 290, 150, 25);
        lblidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblidnumber);

        ansidnumber = new JLabel();
        ansidnumber.setBounds(220, 290, 180, 25);
        ansidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansidnumber);


        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(30, 340, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        ansphone = new JLabel();
        ansphone.setBounds(220, 340, 180, 25);
        ansphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansphone);


        JLabel lblprice = new JLabel("Price :");
        lblprice.setBounds(30, 390, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblprice);

        ansprice = new JLabel();
        ansprice.setBounds(220, 390, 180, 25);
        ansprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        ansprice.setForeground(Color.RED);
        add(ansprice);


        // image on the right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(535, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(445, 40, 535, 370);
        add(image);


        JButton checkPrice = new JButton("Check Price");
        checkPrice.setBounds(30, 455, 155, 30);
        checkPrice.setFont(new Font("San Serif", Font.BOLD, 16));
        checkPrice.setBorder(BorderFactory.createEmptyBorder());
        checkPrice.setFocusable(false);
        checkPrice.setBackground(Color.BLUE);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.addActionListener(e -> ansprice.setText("Rs " + getPrice()));
        add(checkPrice);

        JButton bookNow = new JButton("Book Package");
        bookNow.setBounds(225, 455, 155, 30);
        bookNow.setFont(new Font("San Serif", Font.BOLD, 16));
        bookNow.setBorder(BorderFactory.createEmptyBorder());
        bookNow.setFocusable(false);
        bookNow.setBackground(Color.BLUE);
        bookNow.setForeground(Color.WHITE);
        bookNow.addActionListener(e -> {
            try {
                String id = ansid.getText();
                String idnumber = ansidnumber.getText();
                String phone = ansphone.getText();
                String pack = packages[comboPackage.getSelectedIndex()];
                String price = "Rs " + getPrice();
                String persons = anspersons.getText();

                Connection con = Conn.getConnection();
                String query = "insert into book_package value(?,?,?,?,?,?,?)";

                PreparedStatement pre_smt = con.prepareStatement(query);
                pre_smt.setString(1, username);
                pre_smt.setString(2, pack);
                pre_smt.setString(3, persons);
                pre_smt.setString(4, id);
                pre_smt.setString(5, idnumber);
                pre_smt.setString(6, phone);
                pre_smt.setString(7, price);

                if(JOptionPane.showConfirmDialog(null,"Are you sure, you want to book package?",
                        "CONFIRT", JOptionPane.YES_NO_OPTION)==0) {
                    pre_smt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Package booked successfully!");
                    dispose();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(bookNow);

        JButton back = new JButton("Back");
        back.setBounds(420, 455, 155, 30);
        back.setFont(new Font("San Serif", Font.BOLD, 16));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> dispose());
        add(back);


        // Get User Details
        try {
            Connection con = Conn.getConnection();
            String query = "select * from customer where username=?";

            PreparedStatement pre_smt = con.prepareStatement(query);
            pre_smt.setString(1, username);
            ResultSet user = pre_smt.executeQuery();

            if (user.next()) {
                ansid.setText(user.getString(2));
                ansidnumber.setText(user.getString(3));
                ansphone.setText(user.getString(8));
                ansusername.setText(username);
                showFrame = true;
            } else {
                System.out.println("Hi");
                JOptionPane.showMessageDialog(null, "Please fill user details first.");
                showFrame = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(showFrame);
    }

    private int getPrice() {
        int person = 1;
        persons = anspersons.getText();
        if (!persons.equals("")) {
            person = Integer.parseInt(persons);
        }
        return person * packagePrices[comboPackage.getSelectedIndex()];
    }

    public static void main(String[] args) {
        new BookPackage("suniket");
    }
}
