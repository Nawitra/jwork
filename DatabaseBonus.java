
/**
 * Write a description of class DatabaseBonus here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */
public class DatabaseBonus
{
    private static String[] listBonus;
    
    /**
     * addBonus untuk menambahkan bonus ke dalam listBonus
     *
     * @return false, sebagai nilai default
     */
    public static boolean addBonus(Bonus bonus) {
        return false;
    }
    
    /**
     * removeBonus untuk menghapus entry bonus dari listBonus
     *
     * @return false, sebagai nilai default
     */
    public static boolean removeBonus(Bonus bonus) {
        return false;
    }
    
    /**
     * getBonus untuk mendapatkan nilai dari objek Bonus
     *
     * @return null, karena fungsi belum selesai
     */
    public static Bonus getBonus() {
        return null;
    }
    
    
    /**
     * getListBonus untuk mendapatkan nilai dari property listBonus
     *
     * @return listBonus, list dari bonus
     */
    public static String[] getListBonus() {
        return listBonus;   
    }
}
