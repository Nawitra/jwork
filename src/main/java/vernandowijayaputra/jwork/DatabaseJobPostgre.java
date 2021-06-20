package vernandowijayaputra.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class yang akan menangani method berkaitan dengan objek job untuk postgresql
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class DatabaseJobPostgre {
    /**
     * Method ini digunakan untuk memasukkan job baru ke database
     *
     * @param job sebagai objek yang digunakan untuk input
     * @return objek job apabila insert berhasil dilakukan, null apabila terjadi exception
     */
    public static Job insertJob(Job job) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            c.setAutoCommit(false);
            String name = job.getName();
            int fee = job.getFee();
            int recruiterId = job.getRecruiter().getId();
            String category = String.valueOf(job.getCategory());

            String sql = "INSERT INTO job (name, fee, recruiterId, category) " +
                    "VALUES ('" + name + "', '" + fee + "', '" + recruiterId + "', '" + category + "');";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
            c.close();
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil lastId atau id terakhir dari database job
     *
     * @return lastId atau id terakhir dari database job
     */
    public static int getLastJobId() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        int lastId = 0;
        try {
            String sql = "SELECT MAX(id) AS lastId FROM job;";
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
     * Method ini akan mengambil semua entry job yang terdapat pada database
     *
     * @return array list yang berisi job apabila berhasil, null apabila gagal
     */
    public static ArrayList<Job> getJobDatabase() {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Job job = null;
        ArrayList<Job> jobList = new ArrayList<>();
        int id = 0;
        String name = null;
        int fee = 0;
        int recruiterId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, fee, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId),
                        JobCategory.valueOf(category));
                jobList.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? jobList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method untuk mengambil job dari database job melalui id
     *
     * @param jobId sebagai id acuan untuk mengambil job
     * @return objek job apabila berhasil, null apabila terjadi exception
     */
    public static Job getJobById(int jobId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Job job = null;
        int id = 0;
        String name = null;
        int fee = 0;
        int recruiterId = 0;
        String category = null;
        try {
            String sql = "SELECT * FROM job WHERE id = '" + jobId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
            }
            rs.close();
            stmt.close();
            c.close();
            job = new Job(id, fee, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId),
                    JobCategory.valueOf(category));
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil semua job yang dimiliki oleh seorang recruiter
     *
     * @param recruiterTableId sebagai id dari recruiter
     * @return array list yang berisi job apabila berhasil, null apabila gagal
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterTableId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Job job = null;
        ArrayList<Job> jobList = new ArrayList<>();
        int id = 0;
        String name = null;
        int fee = 0;
        int recruiterId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job WHERE recruiterId = '" + recruiterTableId + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, fee, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId),
                        JobCategory.valueOf(category));
                jobList.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? jobList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method ini akan mengambil semua job yang berdasarkan kategorinya
     *
     * @param categoryTable sebagai category dari job
     * @return array list yang berisi job apabila berhasil, null apabila gagal
     */
    public static ArrayList<Job> getJobByCategory(String categoryTable) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        Job job = null;
        ArrayList<Job> jobList = new ArrayList<>();
        int id = 0;
        String name = null;
        int fee = 0;
        int recruiterId = 0;
        String category = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM job WHERE category = '" + categoryTable + "';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                fee = rs.getInt("fee");
                recruiterId = rs.getInt("recruiterId");
                category = rs.getString("category");
                job = new Job(id, fee, name, DatabaseRecruiterPostgre.getRecruiterById(recruiterId),
                        JobCategory.valueOf(category));
                jobList.add(job);
            }
            rs.close();
            stmt.close();
            c.close();
            return id != 0? jobList : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method yang digunakan untuk menghapus job yang dispesifikasikan oleh jobId
     *
     * @param jobId sebagai acuan untuk mengetahui job mana yang akan dihapus
     */
    public static void removeJob(int jobId) {
        Connection c = DatabaseConnection.connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM job WHERE id = '" + jobId + "';";
            stmt = c.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
