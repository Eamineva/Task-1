package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        //Statement st = null;
        try (Connection conn =  Util.connect()){
            //System.out.println("Connected to the PostgreSQL database.");
            Statement st = conn.createStatement();
            String qs = "CREATE TABLE IF NOT EXISTS t_users(user_id SERIAL NOT NULL PRIMARY KEY, firstname varchar(225) NOT NULL, lastname varchar(225) NOT NULL, age INT)";
            st.execute(qs);
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


    }

    public void dropUsersTable() {
        Statement st = null;
        try (Connection conn =  Util.connect()){
            //System.out.println("Connected to the PostgreSQL database.");
            st = conn.createStatement();
            String qs = "DROP TABLE IF EXISTS t_users";
            st.execute(qs);
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        User user1 = new User(name,lastName, age);
        //System.out.println("user ID "+user2.getId());
        Statement st = null;
        ResultSet rs = null;
        try (Connection conn =  Util.connect()){
            //System.out.println("Connected to the PostgreSQL database.");
            st = conn.createStatement();
/*            String qs1 = "select count(*) from t_users";
            rs=st.executeQuery(qs1);
            rs.next();*/
            //System.out.println(rs.getInt(1));
            String qs = "INSERT INTO t_users (firstname, lastname, age) VALUES('"+user1.getName()+"','"+user1.getLastName()+"',"+user1.getAge()+")";
            //System.out.println(qs);
            st.execute(qs);
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void removeUserById(long id) {
        Statement st = null;
        try (Connection conn =  Util.connect()){
            st = conn.createStatement();
            String qs = "DELETE FROM t_users WHERE user_id="+id;

            st.execute(qs);
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public List<User> getAllUsers() {
        //return null;
        List<User> zu = new ArrayList<User>();
        //List<String> str = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try (Connection conn =  Util.connect()){
            st = conn.createStatement();
            String qs = "SELECT * FROM t_users";
            rs = st.executeQuery(qs);

            while (rs.next()) {
               zu.add(new User(rs.getString(2),rs.getString(3),rs.getByte(4)));
                zu.get(zu.size()-1).setId(rs.getLong(1));
            }


            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return zu;
    }

    public void cleanUsersTable() {
        Statement st = null;
        try (Connection conn =  Util.connect()){
            st = conn.createStatement();
            String qs = "TRUNCATE t_users";

            st.execute(qs);
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
