package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila jobseeker tidak ditemukan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class JobSeekerNotFoundException extends Exception {
    private int jobseeker_error;

    public JobSeekerNotFoundException (int jobseeker_input) {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}
