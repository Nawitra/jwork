package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila recruiter tidak ditemukan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class RecruiterNotFoundException extends Exception {
    private int recruiter_error;

    public RecruiterNotFoundException(int recruiter_input) {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + recruiter_error + " not found";
    }
}
