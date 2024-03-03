package jm.task.core.jdbc.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    /*private static final Properties properties = new Properties();

    static {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("/db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                System.exit(1);
            }

            // Load the properties file
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {

        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }*/

    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DatabaseConfig class
//            db.url=jdbc:postgresql://localhost:5432/postgres
//            db.username=admuser
//            db.password=Test2024_
//            var jdbcUrl = Util.getDbUrl();
//            var user = Util.getDbUsername();
//            var password = Util.getDbPassword();
            String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
            String user = "admuser";
            String password = "Test2024_";

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            //System.out.println(("create conn"));
            System.err.println(e.getMessage());
            return null;
        }
    }

}
