package vernandowijayaputra.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class yang akan menangani method berkaitan dengan objek recruiter untuk postgresql
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class DatabaseRecruiterPostgre {
    /**
     * Method ini digunakan untuk memasukkan recruiter baru ke database
     *
     * @param recruiter sebagai objek yang digunakan untuk input
     * @return objek recruiter apabila insert berhasil dilakukan, null apabila terjadi exception
     */
    public static Recruiter insertRecruiter(Recruiter recruiter) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = recruiter.getName();
            String email = recruiter.getEmail();
            String phoneNumber = recruiter.getPhoneNumber();
            int locationId = recruiter.getLocation().getId();

            String sql = "INSERT INTO recruiter (name, email, phoneNumber, locationId) " +
                    "VALUES ('" + name + "', '" + email + "', '" + phoneNumber + "', '" + locationId + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil lastId atau id terakhir dari database recruiter
     *
     * @return lastId atau id terakhir dari database recruiter
     */
    public static int getLastRecruiterId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM recruiter;";
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
     * Method ini akan mengambil semua entry recruiter yang terdapat pada database
     *
     * @return array list yang berisi recruiter apabila berhasil, null apabila gagal
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Recruiter recruiter = null;
        ArrayList<Recruiter> recruiterList = new ArrayList<>();
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM recruiter;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
                recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocationById(locationId));
                recruiterList.add(recruiter);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? recruiterList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method untuk mengambil recruiter dari database recruiter melalui id
     *
     * @param recruiterId sebagai id acuan untuk mengambil recruiter
     * @return objek recruiter apabila berhasil, null apabila terjadi exception
     */
    public static Recruiter getRecruiterById(int recruiterId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Recruiter recruiter = null;
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        int locationId = 0;

        try {
            String sql = "SELECT * FROM recruiter WHERE id = '" + recruiterId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                phoneNumber = rs.getString("phoneNumber");
                locationId = rs.getInt("locationId");
            }
            rs.close();
            stmt.close();
            c.close();

            recruiter = new Recruiter(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocationById(locationId));
            return recruiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method yang digunakan untuk menghapus recruiter yang dispesifikasikan oleh recruiterId
     *
     * @param recruiterId sebagai acuan untuk mengetahui recruiter mana yang akan dihapus
     */
    public static void removeRecruiter(int recruiterId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM recruiter WHERE id = '" + recruiterId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
