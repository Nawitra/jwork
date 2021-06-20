package vernandowijayaputra.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class yang menampung EwalletPayment sebagai bentuk payment type
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */
public class EwalletPayment extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker) {
        super(id, jobs, jobseeker);
    }
    
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus) {
        super(id, jobs, jobseeker);
        this.bonus = bonus;
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
     * Method yang digunakan untuk mendapatkan bonus
     *
     * @return objek bonus
     */
    public Bonus getBonus() {
        return bonus;    
    }

    /**
     * Method yang digunakan menggantikan nilai bonus
     *
     * @param bonus sebagai objek yang ingin digantikan
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;    
    }

    /**
     * setTotalFee untuk menggantikan nilai dari property totalFee
     */
    @Override
    public void setTotalFee() {
        for(int i = 0; i < getJobs().size(); i++) {
            if (bonus != null && (bonus.getActive() == true) && (totalFee > bonus.getMinTotalFee())) {
                super.totalFee = getJobs().get(i).getFee() + bonus.getExtraFee();
            } else {
                super.totalFee = getJobs().get(i).getFee();
            }
        }
    }

    /**
     * Method ini digunakan untuk menampilkan nilai dari berbagai property
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String date = dateFormat.format(getDate().getTime());
        for(int i = 0; i < getJobs().size(); i++) {
            if ((bonus != null) && (bonus.getActive() == true) && (getJobs().get(i).getFee() > bonus.getMinTotalFee()))
            {
                return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJobs().get(i).getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName() + "\nReferral Code = " + bonus.getReferralCode() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE + "\n");
            } else {
                return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJobs().get(i).getName() + "\nDate = " + date + "\nJob Seeker = "
                        + getJobseeker().getName()+ "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE + "\n");
            }
        }
        return null;
    }
}

