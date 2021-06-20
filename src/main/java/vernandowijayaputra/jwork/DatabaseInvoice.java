package vernandowijayaputra.jwork;

import java.util.ArrayList;

public class DatabaseInvoice {

    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * Method yang digunakan untuk mendapatkan database invoice
     *
     * @return semua entry dari database invoice
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    /**
     * Method ini digunakan untuk mendapatkan id terakhir dari database invoice
     *
     * @return lastId yang merupakan id terakhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method yang digunakan untuk mendapatkan invoice berdasarkan id yang diberikan
     *
     * @param id sebagai id acuan untuk mengambil invoice
     * @return objek invoice
     * @throws InvoiceNotFoundException
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        Invoice dummy = null;
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getId() == id) {
                    dummy = INVOICE_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new InvoiceNotFoundException(id);
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * Method yang digunakan untuk mengambil semua invoice berdasarkan jobseeker
     *
     * @param jobseekerId sebagai id acuan untuk mendapatkan invoice
     * @return semua invoice yang terdaftar pada jobseeker
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) {
        ArrayList<Invoice> dummy = new ArrayList<>();
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if (INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId) {
                dummy.add(INVOICE_DATABASE.get(i));
            }
        }
        return dummy;
    }

    /**
     * Method yang digunakan untuk menambahkan invoice ke dalam database invoice
     *
     * @param invoice sebagai objek invoice yang akan ditambahkan
     * @return true apabila berhasil
     * @throws OngoingInvoiceAlreadyExistsException
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing) {
                    throw new OngoingInvoiceAlreadyExistsException(invoice);
                }
            }
        } catch (Exception error) {
            throw new OngoingInvoiceAlreadyExistsException(invoice);
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * Method yang digunakan untuk menggantikan status dari suatu invoice
     *
     * @param id dari invoice yang ingin digantikan statusnya
     * @param invoiceStatus status baru sebagai pengganti status lama invoice
     * @return true bila berhasil, false bila gagal
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            if ((INVOICE_DATABASE.get(i).getId() == id) && (INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)) {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Method yang digunakan untuk menghapus suatu invoice dari database invoice
     *
     * @param id dari invoice yang ingin dihapus
     * @return true bila berhasil
     * @throws InvoiceNotFoundException
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        try {
            for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
                if (INVOICE_DATABASE.get(i).getId() == id) {
                    INVOICE_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new InvoiceNotFoundException(id);
        }
        throw new InvoiceNotFoundException(id);
    }
}
