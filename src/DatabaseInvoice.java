import java.util.ArrayList;

public class DatabaseInvoice {

    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id){
        Invoice dummy = null;
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if (INVOICE_DATABASE.get(i).getId() == id) {
                dummy = INVOICE_DATABASE.get(i);
                return dummy;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId){
        ArrayList<Invoice> dummy = new ArrayList<Invoice>();
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if (INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId) {
                dummy.add(INVOICE_DATABASE.get(i));
                return dummy;
            }
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice){
        for(int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing) {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for(int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if ((INVOICE_DATABASE.get(i).getId() == id) && (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public boolean removeInvoice(int id){
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if (INVOICE_DATABASE.get(i).getId() == id) {
                INVOICE_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}
