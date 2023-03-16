package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewHotel extends JFrame {

    private boolean showFrame;
    private JLabel ansusername, anshotelname, ansrooms, anspackage, ansid, ansidnumber, ansphone,
            ansprice, ansdays, ansac, ansfood,
            anspersons;

    public ViewHotel(String username) {
        setSize(1000, 570);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("BOOKED HOTEL DETAILS");
        heading.setBounds(70, 0, 300, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(40, 60, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        ansusername = new JLabel("Sadid");
        ansusername.setBounds(250, 60, 180, 25);
        ansusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansusername);


        JLabel lblhotelname = new JLabel("Hotel Name :");
        lblhotelname.setBounds(40, 100, 150, 25);
        lblhotelname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblhotelname);

        anshotelname = new JLabel("Grand Hayatt");
        anshotelname.setBounds(250, 100, 180, 25);
        anshotelname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(anshotelname);


        JLabel lblrooms = new JLabel("Total Rooms :");
        lblrooms.setBounds(40, 140, 150, 25);
        lblrooms.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrooms);

        ansrooms = new JLabel("1");
        ansrooms.setBounds(250, 140, 180, 25);
        ansrooms.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansrooms);


        JLabel lbldays = new JLabel("Total Days :");
        lbldays.setBounds(40, 180, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);

        ansdays = new JLabel("1");
        ansdays.setBounds(250, 180, 180, 25);
        ansdays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansdays);


        JLabel lblac = new JLabel("Ac Included? :");
        lblac.setBounds(40, 220, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);

        ansac = new JLabel("Yes");
        ansac.setBounds(250, 220, 180, 25);
        ansac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansac);


        JLabel lblfood = new JLabel("Food Included? :");
        lblfood.setBounds(40, 260, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);

        ansfood = new JLabel("Yes");
        ansfood.setBounds(250, 260, 180, 25);
        ansfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansfood);


        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(40, 300, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        ansid = new JLabel("Aadhar Card");
        ansid.setBounds(250, 300, 180, 25);
        ansid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansid);


        JLabel lblnumber = new JLabel("ID Number :");
        lblnumber.setBounds(40, 340, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        ansidnumber = new JLabel("1234567890");
        ansidnumber.setBounds(250, 340, 180, 25);
        ansidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansidnumber);


        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(40, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        ansphone = new JLabel("1237890");
        ansphone.setBounds(250, 380, 180, 25);
        ansphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansphone);


        JLabel lblcost = new JLabel("Total Cost :");
        lblcost.setBounds(40, 420, 150, 25);
        lblcost.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcost);

        ansprice = new JLabel("Rs. 36000");
        ansprice.setBounds(250, 420, 180, 25);
        ansprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansprice);


        // image on the right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(545, 405, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(440, 30, 545, 405);
        add(image);


        JButton delete = new JButton("Delete ?");
        delete.setBounds(50, 475, 140, 28);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setFocusable(false);
        delete.setBackground(Color.BLUE);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(e -> {
            try {
                if (JOptionPane.showConfirmDialog(null,
                        "Do you really want to cancel your bookings ?", "CONFIRMATION",
                        JOptionPane.YES_NO_OPTION) == 0) {

                    Connection con = Conn.getConnection();
                    String query = "delete from book_hotel where username=?";

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
        back.setBounds(255, 475, 140, 28);
        back.setFont(new Font("Times New Roman", Font.BOLD, 18));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> dispose());
        add(back);


        try {
            Connection con = Conn.getConnection();
            String query = "select * from book_hotel where username=?";

            PreparedStatement pre_smt = con.prepareStatement(query);
            pre_smt.setString(1, username);

            ResultSet user = pre_smt.executeQuery();
            if (user.next()) {
                ansusername.setText(username);
                anshotelname.setText(user.getString(2));
                ansrooms.setText(user.getString(3));
                ansdays.setText(user.getString(4));
                ansac.setText(user.getString(5));
                ansfood.setText(user.getString(6));
                ansid.setText(user.getString(7));
                ansidnumber.setText(user.getString(8));
                ansphone.setText(user.getString(9));
                ansprice.setText(user.getString(10));
                showFrame = true;
            } else {
                JOptionPane.showMessageDialog(null, "You haven't booked a hotel " +
                        "currently.");
                showFrame = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(showFrame);
    }

    public static void main(String[] args) {
        new ViewHotel("suniket");
    }
}