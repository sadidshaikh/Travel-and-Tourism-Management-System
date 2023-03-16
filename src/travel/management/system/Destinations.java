package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    private JLabel[] images;

    public Destinations() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        images = new JLabel[10];

        for (int i = 0; i < 10; ++i) {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            ImageIcon i2 = new ImageIcon(i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
            images[i] = new JLabel(i2);
            images[i].setBounds(0, 0, 800, 600);
            images[i].setVisible(false);
            add(images[i]);
        }

        Thread t = new Thread(this);
        t.start();

        setVisible(true);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                images[i].setVisible(true);
                Thread.sleep(2500);
                images[i].setVisible(false);
                i = (i + 1) % 10;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Destinations();
    }
}