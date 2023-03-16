package travel.management.system;

import javax.swing.*;
import java.awt.*;

class SplashFrame extends JFrame implements Runnable {

    Thread thread;

    SplashFrame() {
        //setSize(new Dimension(1200, 600));
        //setLocationRelativeTo(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        thread = new Thread(this);
        thread.start(); // start the execution of new thread without stopping the original thread
        // by calling the run() method
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
            dispose();
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Splash {
    public static void main(String[] args) {
        SplashFrame frame = new SplashFrame();

        for (int i = 1, x = 1; i <= 500; x += 7, i += 6) {
            frame.setSize(i + x, i + 50);
            frame.setLocation(780 - (x + i) / 2, 400 - i / 2);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}