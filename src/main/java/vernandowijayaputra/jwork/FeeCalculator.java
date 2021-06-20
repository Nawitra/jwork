package vernandowijayaputra.jwork;

/**
 * Class yang digunakan untuk menghitung total biaya dari invoice
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class FeeCalculator implements Runnable {
    private Invoice invoice;

    public FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Method untuk menghitung total biaya dari semua invoice
     */
    @Override
    public void run() {
        System.out.println("\ncalculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("finish calculating invoice id: " + invoice.getId());
    }
}