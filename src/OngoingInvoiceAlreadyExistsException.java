public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException (Invoice invoice_input) {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already exists.";
    }
}
