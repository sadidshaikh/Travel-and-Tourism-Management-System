package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

public class Payment extends JFrame {

    public Payment() {

        setLayout(null);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 150, 800, 600);
        add(l4);

        JButton pay = new JButton("Pay");
        pay.addActionListener(e -> new Paytm().setVisible(true));
        pay.setBounds(420, 20, 80, 40);
        pay.setFocusable(false);
        add(pay);

        JButton back = new JButton("Back");
        back.addActionListener(e -> setVisible(false));
        back.setBounds(510, 20, 80, 40);
        back.setFocusable(false);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Payment().setVisible(true);
    }

}