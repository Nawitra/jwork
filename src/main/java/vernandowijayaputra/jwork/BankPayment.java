package vernandowijayaputra.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
    
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }
    
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee) {
        super(id, jobs, jobseeker);
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
        for(int i = 0; i < getJobs().size(); i++) {
            if (adminFee != 0) {
                super.totalFee = getJobs().get(i).getFee() - adminFee;
            } else {
                super.totalFee = getJobs().get(i).getFee();
            }
        }
    }
    
    /**
     * printData untuk menampilkan nilai dari berbagai property
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = dateFormat.format(getDate().getTime());
        for(int i = 0; i < getJobs().size(); i++) {
            if (adminFee != 0)
            {
                return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJobs().get(i).getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() +  "\nAdmin Fee = " + adminFee + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE) + "\n";
            } else {
                return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJobs().get(i).getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName()+ "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE) + "\n";
            }
        }
        return "";
    }
}
