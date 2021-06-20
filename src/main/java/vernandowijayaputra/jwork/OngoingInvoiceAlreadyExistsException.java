package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila terdapat invoice yang statusnya OnGoing
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException (Invoice invoice_input) {
        super("Ongoing Invoice ");
        invoice_error = invoice_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already exists.";
    }
}
