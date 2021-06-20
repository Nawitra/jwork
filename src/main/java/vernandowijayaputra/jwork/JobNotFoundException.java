package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila job tidak ditemukan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class JobNotFoundException extends Exception {
    private int job_error;

    public JobNotFoundException(int job_input) {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + job_error + " not found";
    }
}
