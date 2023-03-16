package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Paytm extends JFrame {
    Paytm() {
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800, 600));

        JButton back = new JButton("Back");
        back.addActionListener(e -> setVisible(false));
        back.setBounds(610, 20, 80, 40);
        back.setFocusable(false);
        j.add(back);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}