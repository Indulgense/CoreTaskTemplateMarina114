package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Map;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String username = "root";
    private static String password = "A.d.i.d.a.s_02";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.URL, url);
                properties.put(Environment.USER, username);
                properties.put(Environment.PASS, password);
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                sessionFactory = new Configuration()
                        .addProperties(properties)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
