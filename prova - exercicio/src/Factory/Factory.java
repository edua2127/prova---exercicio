package Factory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    String senha = "eduardo123";
    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prova", "root", senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
