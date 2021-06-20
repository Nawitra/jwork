package vernandowijayaputra.jwork;

import java.util.ArrayList;

/**
 * Class yang akan menampung list dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class DatabaseJob {
    private static final ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * Method ini digunakan untuk mendapatkan database job
     *
     * @return semua entry dari dataabase job
     */
    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    /**
     * Method ini digunakan untuk mendapatkan id terakhir dari database job
     *
     * @return lastid sebagai id terakhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method ini digunakan untuk mendapatkan suatu job berdasarkan id yang diberikan
     *
     * @param id sebagai id acuan untuk mendapatkan job
     * @return objek job
     * @throws JobNotFoundException apabila job tidak ada di database
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        Job dummy = null;
        try {
            for (int i = 0; i < JOB_DATABASE.size(); i++) {
                if (JOB_DATABASE.get(i).getId() == id) {
                    dummy = JOB_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new JobNotFoundException(id);
        }
        throw new JobNotFoundException(id);
    }

    /**
     * Method ini digunakan untuk mendapatkan job berdasarkan recruiter
     *
     * @param recruiterId sebagai acuan untuk mendapatkan job
     * @return semua objek job yang dimiliki oleh recruiter tersebut
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> dummy = new ArrayList<Job>();
        for (int i = 0; i < JOB_DATABASE.size(); i++) {
            if (JOB_DATABASE.get(i).getRecruiter().getId() == recruiterId) {
                dummy.add(JOB_DATABASE.get(i));
            }
        }
        return dummy;
    }

    /**
     * Method ini digunakan untuk mendapatkan job berdasarkan kategori
     *
     * @param category sebagai acuan untuk mendapatkan job
     * @return semua objek job yang memiliki kategori tersebut
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        ArrayList<Job> dummy = new ArrayList<Job>();
        for (int i = 0; i < JOB_DATABASE.size(); i++) {
            if (JOB_DATABASE.get(i).getCategory() == category) {
                dummy.add(JOB_DATABASE.get(i));
            }
        }
        return dummy;
    }

    /**
     * Method ini digunakan untuk menambah job baru ke dalam database
     *
     * @param job sebagai objek yang akan ditambah ke dalam database
     * @return true apabila berhasil
     */
    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    /**
     * Method ini digunakan untuk menghapus suatu job dari database
     *
     * @param id sebagai id job yang ingin dihapus
     * @return true apabila berhasil
     * @throws JobNotFoundException apabila job tidak ada di database
     */
    public static boolean removeJob(int id) throws JobNotFoundException {
        try {
            for (int i = 0; i < JOB_DATABASE.size(); i++) {
                if (JOB_DATABASE.get(i).getId() == id) {
                    JOB_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new JobNotFoundException(id);
        }
        throw new JobNotFoundException(id);
    }
}
