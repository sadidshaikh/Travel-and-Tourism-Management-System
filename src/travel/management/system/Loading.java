package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    Loading(String username) {
        this.username = username;
        t = new Thread(this);

        setSize(650, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230, 130, 200, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 300, 400, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblusername);

        t.start();
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 101; ++i) {
                int max = bar.getMaximum(); // 100
                int val = bar.getValue();
                if (val < max) {
                    bar.setValue(val + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Loading("Sadid");
    }
}