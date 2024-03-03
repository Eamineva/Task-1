package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();

            zsession.createSQLQuery("CREATE TABLE IF NOT EXISTS t_users(user_id SERIAL NOT NULL PRIMARY KEY, firstname varchar(225) NOT NULL, lastname varchar(225) NOT NULL, age INT)").executeUpdate();
            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }
    }

    @Override
    public void dropUsersTable() {
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();
            /*Query query = zsession.createSQLQuery("drop table t_users");
            query.executeUpdate();*/

            zsession.createSQLQuery("drop table t_users").executeUpdate();
            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            User zuser = new User(name,lastName,age);
            //zuser.setId();
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();
            zsession.save(zuser);
            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }


    }

    @Override
    public void removeUserById(long id) {
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();
           User zu = zsession.get(User.class, id);
           zsession.delete(zu);
            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        //return null;
        List<User> zu = new ArrayList<>();
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            //User zuser = new User(name,lastName,age);
            //zuser.setId();
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();
            zu = zsession.createQuery("from User").getResultList();
            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }
        return zu;
    }

    @Override
    public void cleanUsersTable() {
        SessionFactory zfact = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        try {
            Session zsession = zfact.getCurrentSession();
            zsession.beginTransaction();
            zsession.createSQLQuery("truncate table t_users").executeUpdate();
            

            zsession.getTransaction().commit();
        }
        finally {
            zfact.close();
        }
    }
}
