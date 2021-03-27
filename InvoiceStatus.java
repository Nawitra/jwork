
/**
 * Enum yang berisi status dari invoice
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.27
 */
public enum InvoiceStatus
{
    OnGoing, Finished, Cancelled;
    
    public String toString() {
        switch(this) {
            case OnGoing:
                return "Ongoing";
            case Finished:
                return "Finished";
            case Cancelled:
                return "Cancelled";
            default:
                return null;
        }
    }
}
