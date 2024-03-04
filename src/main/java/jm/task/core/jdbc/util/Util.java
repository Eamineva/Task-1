package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД


    public static Connection connect() throws SQLException {

        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
            String user = "admuser";
            String password = "Test2024_";

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Properties h_connect(){
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        prop.setProperty("hibernate.connection.username", "admuser");
        prop.setProperty("hibernate.connection.password", "Test2024_");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.current_session_context_class", "thread");
        prop.setProperty("show_sql", "true");
        return prop;
    }

}
