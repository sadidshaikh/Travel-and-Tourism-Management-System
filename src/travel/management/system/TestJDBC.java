package travel.management.system;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/text",
                "root", "1234");
        String s = "SELECT * FROM timepass";
        Statement stm = connection.createStatement();
        ResultSet set = stm.executeQuery(s);
        while (set.next()) {
            int id = set.getInt(1);
            String name = set.getString(2);
            System.out.println("ID : " + id);
            System.out.println("Name : " + name);
            System.out.println("-------------------------------End Line-----------------------------");
        }

        String desc = "DESC timepass";
        ResultSet newSet = stm.executeQuery(desc);
        while (newSet.next()) {
            for (int i = 1; i <= 5; ++i) {
                System.out.print(newSet.getString(i) + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------End Line-----------------------------");
    }
}