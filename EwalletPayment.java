import java.text.SimpleDateFormat;

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
    
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);    
    }
    
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus) {
        super(id, job, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    
    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;    
    }
    
    public Bonus getBonus() {
        return bonus;    
    }
    
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;    
    }
    
    @Override
    public void setTotalFee() {
        if (bonus != null && (bonus.getActive() == true) && (totalFee > bonus.getMinTotalFee())) {
            super.totalFee = getJob().getFee() + bonus.getExtraFee();
        } else {
            super.totalFee = getJob().getFee();
        }
    }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = dateFormat.format(getDate().getTime());
        if ((bonus != null) && (bonus.getActive() == true) && (getJob().getFee() > bonus.getMinTotalFee()))
        {
            return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName() + "Referral Code = " + bonus.getReferralCode() + "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }else
        {
            return ("===================== Invoice =====================\n" + "Id = " + getId() + "\nJob = " + getJob().getName() + "\nDate = " + date + "\nJob Seeker = "
                + getJobseeker().getName()+ "\nTotal Fee = " + getTotalFee() + "\nStatus = " + getInvoiceStatus() + "\nPayment = " + PAYMENT_TYPE);
        }
    }
}

