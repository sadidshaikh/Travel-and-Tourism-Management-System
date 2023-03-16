package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    static Connection con;

    public static Connection getConnection() {
        try {
            // register/load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // making connection to the database (getting connection string)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306" +
                    "/travel_management_system", "root", "1234");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}