
/**
 * Kelas untuk menampung list recruiter.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.20
 */
public class DatabaseRecruiter
{
    private static String[] listRecruiter;
    
    /**
     * addRecruiter untuk menambahkan perekrut ke dalam listRecruiter
     *
     * @return false, sebagai nilai default
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        return false;
    }

    /**
     * removeRecruiter untuk menghapus entry perekrut dari listRecruiter
     *
     * @return false, sebagai nilai default
     */
    public static boolean removeRecruiter(Recruiter recruiter) {
        return false;
    }
    
    /**
     * getRecruiter untuk mendapatkan nilai dari objek Recruiter
     *
     * @return null, karena fungsi belum selesai
     */
    public static Recruiter getRecruiter() {
        return null;
    }
    
    /**
     * getListRecruiter untuk mendapatkan nilai dari property listRecruiter
     *
     * @return listRecruiter, list dari recruiter
     */
    public static String[] getListRecruiter() {
        return listRecruiter;   
    }
}
