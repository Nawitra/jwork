package vernandowijayaputra.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Class yang akan menangani method berkaitan dengan objek jobseeker untuk postgresql
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class DatabaseJobseekerPostgre {
    /**
     * Method ini digunakan untuk memasukkan jobseeker baru ke database
     *
     * @param jobseeker sebagai objek yang digunakan untuk input
     * @return objek jobseeker apabila insert berhasil dilakukan, null apabila terjadi exception
     */
    public static Jobseeker insertJobseeker(Jobseeker jobseeker) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = jobseeker.getName();
            String email = jobseeker.getEmail();
            String password = jobseeker.getPassword();
            int year = jobseeker.joinDate.get(Calendar.YEAR) - 1;
            int month = jobseeker.joinDate.get(Calendar.MONTH) - 1;
            int day = jobseeker.joinDate.get(Calendar.DATE) - 1;
            String sql = "INSERT INTO jobseeker (name, email, password, year, month, day) " +
                    "VALUES ('" + name + "', '" + email + "', '" + password + "', '" + year + "', '" + month + "', '" + day + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil lastId atau id terakhir dari database jobseeker
     *
     * @return lastId atau id terakhir dari database jobseeker
     */
    public static int getLastJobseekerId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM jobseeker;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lastId = rs.getInt("lastId");
            }
            stmt.close();
            c.close();
            return lastId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }

    /**
     * Method untuk mengambil jobseeker dari database jobseeker melalui id
     *
     * @param jobseekerId sebagai id acuan untuk mengambil jobseeker
     * @return objek jobseeker apabila berhasil, null apabila terjadi exception
     */
    public static Jobseeker getJobseekerById(int jobseekerId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Jobseeker jobseeker = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            String sql = "SELECT * FROM jobseeker WHERE id = '" + jobseekerId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                day = rs.getInt("day");
            }
            rs.close();
            stmt.close();
            c.close();

            jobseeker = new Jobseeker(id, name, email, password, year, month, day);
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method yang digunakan untuk menghapus jobseeker yang dispesifikasikan oleh jobseekerId
     *
     * @param jobseekerId sebagai acuan untuk mengetahui jobseeker mana yang akan dihapus
     */
    public static void removeJobseeker(int jobseekerId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM jobseeker WHERE id = '" + jobseekerId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method yang digunakan untuk login jobseeker menggunakan email dan password
     *
     * @param emailLog    merupakan email dari jobseeker
     * @param passwordLog merupakan password dari jobseeker
     * @return objek jobseeker apabila berhasil, null bila gagal
     */
    public static Jobseeker getJobseekerLogin(String emailLog, String passwordLog) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Jobseeker jobseeker = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            String sql = "SELECT * FROM jobseeker WHERE email = '" + emailLog + "' AND password = '" + passwordLog + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                year = rs.getInt("year");
                month = rs.getInt("month");
                day = rs.getInt("day");
            }
            rs.close();
            stmt.close();
            c.close();

            jobseeker = new Jobseeker(id, name, email, password, year, month, day);
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
