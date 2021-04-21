import java.text.SimpleDateFormat;

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
    
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);    
    }
    
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee) {
        super(id, job, jobseeker, invoiceStatus);
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
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        if (adminFee != 0)
        {
            return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName() +  "Admin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }else
        {
            return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName()+ "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }
    }
}
