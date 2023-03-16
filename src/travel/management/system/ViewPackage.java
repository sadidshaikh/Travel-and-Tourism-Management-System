package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewPackage extends JFrame {

    private boolean showFrame;
    private JLabel ansusername, anspackage, ansid, ansidnumber, ansphone, ansprice, anspersons;

    public ViewPackage(String username) {
        setSize(1000, 570);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setBounds(70, 8, 300, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        ansusername = new JLabel("Sadid");
        ansusername.setBounds(280, 80, 180, 25);
        ansusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansusername);


        JLabel lblpackge = new JLabel("Select Package :");
        lblpackge.setBounds(40, 130, 150, 25);
        lblpackge.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackge);

        anspackage = new JLabel("Silver Package");
        anspackage.setBounds(280, 130, 180, 25);
        anspackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(anspackage);


        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setBounds(40, 180, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);

        anspersons = new JLabel("1");
        anspersons.setBounds(280, 180, 180, 25);
        anspersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(anspersons);


        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(40, 230, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        ansid = new JLabel("Pan Card");
        ansid.setBounds(280, 230, 180, 25);
        ansid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansid);


        JLabel lblidnumber = new JLabel("ID Number :");
        lblidnumber.setBounds(40, 280, 150, 25);
        lblidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblidnumber);

        ansidnumber = new JLabel("123445678");
        ansidnumber.setBounds(280, 280, 180, 25);
        ansidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansidnumber);


        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(40, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        ansphone = new JLabel("7620236431");
        ansphone.setBounds(280, 330, 180, 25);
        ansphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansphone);


        JLabel lblprice = new JLabel("Price :");
        lblprice.setBounds(40, 380, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblprice);

        ansprice = new JLabel("Rs 50000");
        ansprice.setBounds(280, 380, 180, 25);
        ansprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        ansprice.setForeground(Color.RED);
        add(ansprice);


        // image on the right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(535, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(445, 40, 535, 370);
        add(image);


        JButton delete = new JButton("Delete ?");
        delete.setBounds(50, 455, 145, 30);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 19));
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setFocusable(false);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(e -> {
            try {
                if (JOptionPane.showConfirmDialog(null,
                        "Do you really want to cancel your bookings ?","CONFIRMATION",
                        JOptionPane.YES_NO_OPTION)==0) {

                    Connection con = Conn.getConnection();
                    String query = "delete from book_package where username=?";

                    PreparedStatement pre_smt = con.prepareStatement(query);
                    pre_smt.setString(1, username);

                    pre_smt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Bookings deleted successfully.");
                    dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        add(delete);


        JButton back = new JButton("Back");
        back.setBounds(255, 455, 145, 30);
        back.setFont(new Font("Times New Roman", Font.BOLD, 19));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> dispose());
        add(back);


        try {
            Connection con = Conn.getConnection();
            String query = "select * from book_package where username=?";

            PreparedStatement pre_smt = con.prepareStatement(query);
            pre_smt.setString(1, username);

            ResultSet user = pre_smt.executeQuery();
            if (user.next()) {
                ansusername.setText(username);
                anspackage.setText(user.getString(2));
                anspersons.setText(user.getString(3));
                ansid.setText(user.getString(4));
                ansidnumber.setText(user.getString(5));
                ansphone.setText(user.getString(6));
                ansprice.setText(user.getString(7));
                showFrame = true;
            } else {
                JOptionPane.showMessageDialog(null, "You don't have a booked package " +
                        "currently.");
                showFrame = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setVisible(showFrame);
    }

    public static void main(String[] args) {
        new ViewPackage("sadid");
    }
}