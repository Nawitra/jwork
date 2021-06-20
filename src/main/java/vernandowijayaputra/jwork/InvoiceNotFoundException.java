package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila invoice tidak ditemukan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}
