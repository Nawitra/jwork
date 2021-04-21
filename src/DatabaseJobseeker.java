/**
 * Class yang akan menampung list dari pencari pekerjaan.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public class DatabaseJobseeker
{
    private static String[] listJobseeker;

    /**
     * addJobseeker untuk menambahkan pencari pekerjaan ke dalam listJobseeker
     *
     * @return false, sebagai nilai default
     */
    public static boolean addJobseeker(Jobseeker jobseeker) {
        return false;
    }
    
    /**
     * removeJobseeker untuk menghapus entry pencari pekerjaan dari listJobseeker
     *
     * @return false, sebagai nilai default
     */
    public static boolean removeJobseeker(Jobseeker jobseeker) {
        return false;
    }
    
    /**
     * getJobseeker untuk mendapatkan nilai dari objek Jobseeker
     *
     * @return null, karena fungsi belum selesai
     */
    public static Jobseeker getJobseeker() {
        return null;
    }
    
    /**
     * getListJobseeker untuk mendapatkan nilai dari property listJobseeker
     *
     * @return listJobseeker, list dari jobseeker
     */
    public static String[] getListJobseeker() {
        return listJobseeker;   
    }
}
