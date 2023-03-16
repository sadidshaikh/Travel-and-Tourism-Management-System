package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    String username;

    CheckPackage(String username) {
        this.username = username;

        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        String[] package1 = new String[]{"package1.jpg", "GOLD PACKAGE", "6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "Summer Special", "Rs 32000 only"};
        String[] package2 = new String[]{"package2.jpg", "SILVER PACKAGE", "4 days and 3 Nights", "Toll Free and Free Entrance", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "Winter Special", "Rs 25000 only"};
        String[] package3 = new String[]{"package3.jpg", "BRONZE PACKAGE", "6 days and 5 Nights", "Return Airfare", "Free Clubbing & Horse Riding", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "Winter Special", "Rs 12000 only"};

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[1]);
        l1.setBounds(50, 5, 300, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p.add(l1);

        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(30, 60, 300, 30);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l2);

        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(30, 110, 350, 30);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l3);

        JLabel l4 = new JLabel(pack[5]);
        l4.setBounds(30, 160, 300, 30);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 210, 350, 30);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l5);

        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(Color.BLUE);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l6);

        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(30, 310, 300, 30);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l7);

        JLabel l8 = new JLabel(pack[8]);
        l8.setBounds(30, 360, 300, 30);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(l8);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[0]));
        ImageIcon i2 = new ImageIcon(i1.getImage().getScaledInstance(600, 385,
                Image.SCALE_DEFAULT));

        JLabel image = new JLabel(i2);
        image.setBounds(350, 5, 600, 370);
        p.add(image);

        JButton bookNow = new JButton("Book Now");
        bookNow.setBounds(25, 475, 125, 30);
        bookNow.setFont(new Font("San Serif", Font.BOLD, 16));
        bookNow.setBorder(BorderFactory.createEmptyBorder());
        bookNow.setFocusable(false);
        bookNow.setBackground(Color.BLUE);
        bookNow.setForeground(Color.WHITE);
        bookNow.addActionListener(e -> new BookPackage(username));
        add(bookNow);

        JButton back = new JButton("Back");
        back.setBounds(180, 475, 125, 30);
        back.setFont(new Font("San Serif", Font.BOLD, 16));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> dispose());
        add(back);

        JLabel l9 = new JLabel(pack[9]);
        l9.setBounds(380, 448, 210, 30);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("RALEWAY", Font.BOLD, 26));
        p.add(l9);

        JLabel l10 = new JLabel(pack[10]);
        l10.setBounds(650, 448, 210, 30);
        l10.setForeground(Color.RED);
        l10.setFont(new Font("RALEWAY", Font.BOLD, 26));
        p.add(l10);

        return p;
    }

    public static void main(String[] args) {
        new CheckPackage("sadid");
    }

}