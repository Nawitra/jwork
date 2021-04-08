
/**
 * Class yang menampung BankPayment sebagai payment type
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.4
 */
public class BankPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;
    
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, date, jobseeker, invoiceStatus);    
    }
    
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee) {
        super(id, job, date, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
    }
    
    /**
     * getPaymentType untuk mendapatkan nilai dari konstan PAYMENT_TYPE
     *
     * @return nilai dari konstan PAYMENT_TYPE
     */
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;    
    }
    
    /**
     * getAdminFee untuk mendapatkan nilai dari property adminFee
     *
     * @return nilai dari property adminFee
     */
    public int getAdminFee() {
        return adminFee;    
    }
    
    /**
     * setAdminFee untuk menggantikan nilai dari property adminFee
     * 
     * @param adminFee, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setAdminFee(int adminFee) {
        this.adminFee = adminFee;    
    }

    /**
     * setTotalFee untuk menggantikan nilai dari property totalFee
     */
    @Override
    public void setTotalFee() {
        if (adminFee != 0) {
            super.totalFee = getJob().getFee() - adminFee;
        } else {
            super.totalFee = getJob().getFee();
        }
    }
    
    /**
     * printData untuk menampilkan nilai dari berbagai property
     */
    @Override
    public void printData() {
        System.out.println("===================== Invoice =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Jobseeker: " + getJobseeker().getName());
        System.out.println("Admin Fee: " + adminFee);
        System.out.println("Total Fee: " + super.totalFee);
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("Payment Type: " + PAYMENT_TYPE);
    }
}
