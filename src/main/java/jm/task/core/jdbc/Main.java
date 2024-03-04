package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //Реализация через Hibernate
        UserDaoHibernateImpl zhib = new UserDaoHibernateImpl();
        //zhib.dropUsersTable();
        zhib.createUsersTable();
        //zhib.saveUser("Ivan1","Ivanov",(byte)43);
        //zhib.cleanUsersTable();
        System.out.println(zhib.getAllUsers());
        //zhib.removeUserById(6);




        //Реализация через JDBC
        /*UserDaoJDBCImpl db = new UserDaoJDBCImpl();
        db.createUsersTable();*/
        //Проверка сохранения пользователя
        //db.saveUser("Sergey","Lonov", (byte) 21);
        //System.out.println(db.getAllUsers());
        //db.removeUserById(9);
        //user.dropUsersTable();
        //db.cleanUsersTable();



        /*try (var connection =  Util.connect()){
            System.out.println("Подключение установлено");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }*/
    }
}
