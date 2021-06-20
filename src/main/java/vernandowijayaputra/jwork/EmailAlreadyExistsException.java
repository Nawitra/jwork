package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila email yang digunakan telah teregistrasi
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class EmailAlreadyExistsException extends Exception {
    private Jobseeker jobseeker_error;

    public EmailAlreadyExistsException (Jobseeker jobseeker_input) {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}
