package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    private String username;
    private JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails;
    private JButton checkPackage, bookPackage, viewPackage, viewHotels, destinations;
    private JButton bookHotel, viewBookedHotel, payments, about;

    Dashboard(String username) {
        this.username = username;
        //setSize(1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 500));
        setLocationRelativeTo(null);
        setLayout(null);

        //-------------------------------Top Panel------------------------------
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1600, 65);
        p1.setBackground(new Color(0, 0, 102));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);


        //-------------------------------Left Panel------------------------------
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 65, 300, 900);
        p2.setBackground(new Color(0, 0, 102));
        add(p2);

        addPersonalDetails = createButton("Add Personal Details", 0, 60);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = createButton("Update Personal Details", 50, 30);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = createButton("View Details", 100, 130);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        checkPackage = createButton("Check Package", 150, 110);
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = createButton("Book Package", 200, 120);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = createButton("View Package", 250, 120);
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = createButton("View Hotels", 300, 135);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = createButton("Book Hotel", 350, 145);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = createButton("View Booked Hotel", 400, 80);
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations = createButton("Destinations", 450, 135);
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = createButton("Payment Gateway", 500, 90);
        payments.addActionListener(this);
        p2.add(payments);

        JButton calculator = createButton("Calculator", 550, 160);
        calculator.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        p2.add(calculator);

        about = createButton("About", 600, 195);
        about.addActionListener(this);
        p2.add(about);


        //-------------------------------Right Panel------------------------------
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public JButton createButton(String text, int y, int rm) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setBounds(0, y, 300, 50);
        button.setMargin(new Insets(0, 0, 0, rm));
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (e.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (e.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (e.getSource() == checkPackage) {
            new CheckPackage(username);
        } else if (e.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (e.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (e.getSource() == viewHotels) {
            new CheckHotels();
        } else if (e.getSource() == destinations) {
            new Destinations();
        } else if (e.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (e.getSource() == viewBookedHotel) {
            new ViewHotel(username);
        } else if (e.getSource() == payments) {
            new Payment();
        } else if (e.getSource() == about) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Dashboard("Sadid");
    }
}