package vernandowijayaputra.jwork;

/**
 * Enum yang berisi status dari invoice
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.27
 */
public enum InvoiceStatus
{
    OnGoing("Ongoing"), 
    Finished("Finished"), 
    Cancelled("Cancelled");
    
    private String status;

    /**
     * Method yang digunakan untuk menggantikan status dari suatu invoice
     *
     * @param status merupakan status baru untuk menggantikan status lama
     */
    private InvoiceStatus(String status) {
        this.status = status;    
    }

    /**
     * Method yang digunakan untuk menampilkan status dalam bentuk string
     *
     * @return status
     */
    public String toString() {
        return status;
    }
    
    //pembuktian
    public static void main(String[] args) {
        InvoiceStatus ongoing = InvoiceStatus.OnGoing;
        InvoiceStatus finished = InvoiceStatus.Finished;
        InvoiceStatus cancel = InvoiceStatus.Cancelled;
        
        System.out.println(ongoing);
        System.out.println(finished);
        System.out.println(cancel);
    }
}
