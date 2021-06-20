package vernandowijayaputra.jwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Class ini menangani koneksi yang dilakukan kepada postgresql
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class DatabaseConnection {
    public static Connection connection() {
        Connection c = null;
        Statement stat = null;
        String db_name = "jwork";
        String db_user = "postgres";
        String db_password = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + db_name, db_user, db_password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return c;
    }
}