import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {

    private static volatile Connection conn = null;

    private DBCon() {
        //constructor is made private to avoid instantiation outside the class
    }

    public static Connection getConnection() {

        if (conn == null) {

            synchronized (DBCon.class) {

                if (conn == null) {

                    try {

                        Class.forName("org.h2.Driver");

                        Configuration configure = new Configuration().configure();
                        configure.addURL(URL)
                        StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder().applySetting();

                        conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");

                    } catch (java.lang.ClassNotFoundException e) {

                        System.out.println("Error occured : " + e.getMessage());

                    } catch (java.sql.SQLException e) {

                        System.out.println("Error occured : " + e.getMessage());

                    } catch (Exception e) {
                        System.out.println("Error occured : " + e.getMessage());
                    }
                }
            }
        }

        return conn;
    }

    public static void closeConnection() {

        if (conn != null) {

            try {

                conn.close();
                conn = null;

            } catch (java.sql.SQLException e) {

                System.out.println("Error occured : " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Error occured : " + e.getMessage());

            }
        }

    }
}

