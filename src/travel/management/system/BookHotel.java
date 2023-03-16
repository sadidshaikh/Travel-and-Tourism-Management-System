package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookHotel extends JFrame {

    private JLabel ansusername, ansid, ansidnumber, ansphone, ansprice;
    private JTextField ansrooms, ansdays;
    private Choice anshotel, ansac, ansfood;
    private String query;
    private boolean showFrame;

    BookHotel(String username) {

        setSize(1050, 600);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel heading = new JLabel("BOOK HOTEL");
        heading.setBounds(120, 0, 300, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 65, 190, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        ansusername = new JLabel("Sadid");
        ansusername.setBounds(220, 65, 220, 25);
        ansusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansusername);


        JLabel lblHotels = new JLabel("Select Hotel :");
        lblHotels.setBounds(30, 105, 190, 25);
        lblHotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblHotels);

        anshotel = new Choice();
        anshotel.setBounds(220, 105, 220, 25);
        anshotel.setFont(new Font("Tahoma", Font.BOLD, 16));
        anshotel.setBackground(new Color(202, 202, 202));
        try {
            Connection con = Conn.getConnection();
            query = "select * from hotel";

            Statement stmt = con.createStatement();
            ResultSet hotels = stmt.executeQuery(query);

            while (hotels.next()) {
                anshotel.add(hotels.getString("hotel_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        add(anshotel);


        JLabel lblrooms = new JLabel("No. of Rooms :");
        lblrooms.setBounds(30, 145, 190, 25);
        lblrooms.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrooms);

        ansrooms = new JTextField("1");
        ansrooms.setBounds(220, 145, 220, 25);
        ansrooms.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansrooms);


        JLabel lbldays = new JLabel("No. of Days :");
        lbldays.setBounds(30, 185, 190, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);

        ansdays = new JTextField("1");
        ansdays.setBounds(220, 185, 220, 25);
        ansdays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansdays);


        JLabel lblac = new JLabel("AC / Non-AC ?");
        lblac.setBounds(30, 225, 190, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);

        ansac = new Choice();
        ansac.add("AC");
        ansac.add("Non-AC");
        ansac.setBounds(220, 225, 220, 25);
        ansac.setFont(new Font("Tahoma", Font.BOLD, 16));
        ansac.setBackground(new Color(202, 202, 202));
        add(ansac);


        JLabel lblfood = new JLabel("Food Included ?");
        lblfood.setBounds(30, 265, 190, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);

        ansfood = new Choice();
        ansfood.add("Yes");
        ansfood.add("No");
        ansfood.setBounds(220, 265, 220, 25);
        ansfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        ansfood.setBackground(new Color(202, 202, 202));
        add(ansfood);


        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 305, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        ansid = new JLabel();
        ansid.setBounds(220, 305, 180, 25);
        ansid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansid);


        JLabel lblidnumber = new JLabel("ID Number :");
        lblidnumber.setBounds(30, 345, 150, 25);
        lblidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblidnumber);

        ansidnumber = new JLabel();
        ansidnumber.setBounds(220, 345, 180, 25);
        ansidnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansidnumber);


        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(30, 385, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        ansphone = new JLabel();
        ansphone.setBounds(220, 385, 180, 25);
        ansphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(ansphone);


        JLabel lblprice = new JLabel("Total Price :");
        lblprice.setBounds(30, 425, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblprice);

        ansprice = new JLabel();
        ansprice.setBounds(220, 425, 180, 25);
        ansprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        ansprice.setForeground(Color.RED);
        add(ansprice);


        // image on the right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(565, 420, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(465, 40, 565, 420);
        add(image);


        JButton checkPrice = new JButton("Check Price");
        checkPrice.setBounds(30, 495, 155, 30);
        checkPrice.setFont(new Font("San Serif", Font.BOLD, 16));
        checkPrice.setBorder(BorderFactory.createEmptyBorder());
        checkPrice.setFocusable(false);
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.addActionListener(e -> ansprice.setText("Rs. " + getPrice()));
        add(checkPrice);

        JButton bookNow = new JButton("Book");
        bookNow.setBounds(225, 495, 155, 30);
        bookNow.setFont(new Font("San Serif", Font.BOLD, 16));
        bookNow.setBorder(BorderFactory.createEmptyBorder());
        bookNow.setFocusable(false);
        bookNow.setBackground(Color.BLACK);
        bookNow.setForeground(Color.WHITE);
        bookNow.addActionListener(e -> {
            try {
                String id = ansid.getText();
                String idnumber = ansidnumber.getText();
                String price = "Rs " + getPrice();

                Connection con = Conn.getConnection();
                String query = "insert into book_hotel value(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement pre_smt = con.prepareStatement(query);
                pre_smt.setString(1, username);
                pre_smt.setString(2, anshotel.getSelectedItem());
                pre_smt.setString(3, ansrooms.getText());
                pre_smt.setString(4, ansdays.getText());
                pre_smt.setString(5, ansac.getSelectedItem());
                pre_smt.setString(6, ansfood.getSelectedItem());
                pre_smt.setString(7, id);
                pre_smt.setString(8, idnumber);
                pre_smt.setString(9, ansphone.getText());
                pre_smt.setString(10, price);

                if (JOptionPane.showConfirmDialog(null, "Are you sure, you want to book hotel?",
                        "CONFIRT", JOptionPane.YES_NO_OPTION) == 0) {
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
        back.setBounds(420, 495, 155, 30);
        back.setFont(new Font("San Serif", Font.BOLD, 16));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.BLACK);
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
        int total_cost = 0;
        try {
            Connection con = Conn.getConnection();
            query = "select * from hotel where hotel_name=?";

            PreparedStatement pre_stm = con.prepareStatement(query);
            pre_stm.setString(1, anshotel.getSelectedItem());

            ResultSet hotelDetails = pre_stm.executeQuery();
            hotelDetails.next();

            int cost_per_room = hotelDetails.getInt(2);
            if (ansac.getSelectedItem().equals("AC")) {
                cost_per_room += hotelDetails.getInt(4);
            }
            if (ansfood.getSelectedItem().equals("Yes")) {
                cost_per_room += hotelDetails.getInt(3);
            }

            int days = Integer.parseInt(ansdays.getText());
            int no_persons = Integer.parseInt(ansrooms.getText());

            total_cost = cost_per_room * no_persons * days;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total_cost;
    }

    public static void main(String[] args) {
        new BookHotel("suniket");
    }
}
