package vernandowijayaputra.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class yang akan menangani method berkaitan dengan objek location untuk postgresql
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class DatabaseLocationPostgre {
    /**
     * Method ini digunakan untuk memasukkan location baru ke database
     *
     * @param location sebagai objek yang digunakan untuk input
     * @return objek location apabila insert berhasil dilakukan, null apabila terjadi exception
     */
    public static Location insertLocation(Location location) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String province = location.getProvince();
            String city = location.getCity();
            String description = location.getDescription();
            String sql = "INSERT INTO location (province, city, description) " +
                    "VALUES ('" + province + "', '" + city + "', '" + description + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return location;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil lastId atau id terakhir dari database location
     *
     * @return lastId atau id terakhir dari database location
     */
    public static int getLastLocationId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM location;";
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
     * Method untuk mengambil location dari database location melalui id
     *
     * @param locationId sebagai id acuan untuk mengambil location
     * @return objek location apabila berhasil, null apabila terjadi exception
     */
    public static Location getLocationById(int locationId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Location location = null;
        int id = 0;
        String province = null;
        String city = null;
        String description = null;
        try {
            String sql = "SELECT * FROM location WHERE id = '" + locationId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                province = rs.getString("province");
                city = rs.getString("city");
                description = rs.getString("description");
            }
            rs.close();
            stmt.close();
            c.close();

            location = new Location(id, province, city, description);
            return location;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method yang digunakan untuk menghapus location yang dispesifikasikan oleh locationId
     *
     * @param locationId sebagai acuan untuk mengetahui location mana yang akan dihapus
     */
    public static void removeLocation(int locationId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM location WHERE id = '" + locationId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
