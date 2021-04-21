/**
 * Class yang akan menampung list dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class DatabaseJob
{
    private static String[] listJob;

    /**
     * addJob untuk menambahkan pekerjaan ke dalam listJob
     *
     * @return false, sebagai nilai default
     */
    public static boolean addJob(Job job) {
        return false;
    }

    /**
     * removeJob untuk menghapus entry pekerjaan dari listJob
     *
     * @return false, sebagai nilai default
     */
    public static boolean removeJob(Job job) {
        return false;   
    }
    
    /**
     * getJob untuk mendapatkan nilai dari objek Job
     *
     * @return null, karena fungsi belum selesai
     */
    public static Job getJob() {
        return null;   
    }
    
    /**
     * getListJob untuk mendapatkan nilai dari property listJob
     *
     * @return listJob, list dari pekerjaan
     */
    public static String[] getListJob() {
        return listJob;
    }
}
