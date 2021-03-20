/**
 * Class yang akan menampung list dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class DatabaseJob
{
    private String[] listJob;

    public DatabaseJob() {}
    
    /**
     * addJob untuk menambahkan pekerjaan ke dalam listJob
     *
     * @return false, sebagai nilai default
     */
    public boolean addJob(Job job) {
        return false;
    }

    /**
     * remove untuk menghapus entry pekerjaan dari listJob
     *
     * @return false, sebagai nilai default
     */
    public boolean remove(Job job) {
        return false;   
    }
    
    /**
     * getJob untuk mendapatkan nilai dari objek Job
     *
     * @return null, karena fungsi belum selesai
     */
    public Job getJob() {
        return null;   
    }
    
    /**
     * getListJob untuk mendapatkan nilai dari property listJob
     *
     * @return listJob, list dari pekerjaan
     */
    public String[] getListJob() {
        return listJob;
    }
}
