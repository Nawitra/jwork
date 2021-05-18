package vernandowijayaputra.jwork;

import java.util.ArrayList;

public class FeeCalculator implements Runnable {
    private Invoice invoice;

    public FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void run() {
        System.out.println("\ncalculating invoice id: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("finish calculating invoice id: " + invoice.getId());
    }
}