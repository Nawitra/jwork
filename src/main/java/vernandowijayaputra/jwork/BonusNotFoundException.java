package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila bonus tidak ditemukan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class BonusNotFoundException extends Exception {
    private int bonus_error;

    public BonusNotFoundException(int bonus_input) {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * Method yang digunakan untuk mendapatkan pesan error apabila exception terjadi
     *
     * @return pesan
     */
    public String getMessage() {
        return super.getMessage() + bonus_error + " not found";
    }
}
