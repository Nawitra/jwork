/**
 * Class yang menangani detail dari informasi tagihan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Invoice
{
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus status;
    
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status) {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
        this.paymentType = paymentType;
        this.status = status;
    }
    
    /**
     * getId untuk mendapatkan nilai dari property id
     *
     * @return nilai dari property id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * getIdJob untuk mendapatkan nilai dari property idJob
     *
     * @return nilai dari property idJob
     */
    public int getIdJob() {
        return this.idJob;
    }
    
    /**
     * getId untuk mendapatkan nilai dari property date
     *
     * @return nilai dari property date
     */
    public String getDate() {
        return this.date;
    }
    
    /**
     * getTotalFee untuk mendapatkan nilai dari property totalFee
     *
     * @return nilai dari property totalFee
     */
    public int getTotalFee() {
        return this.totalFee;
    }
    
    /**
     * getJobseeker untuk mendapatkan nilai dari objek jobseeker
     *
     * @return nilai dari objek jobseeker
     */
    public Jobseeker getJobseeker() {
        return this.jobseeker;   
    }
    
    /**
     * getPaymentType untuk mendapatkan nilai dari objek paymentType
     *
     * @return nilai dari objek paymentType
     */
    public PaymentType getPaymentType() {
        return this.paymentType;   
    }
    
    /**
     * getInvoiceStatus untuk mendapatkan nilai dari objek invoiceStatus
     *
     * @return nilai dari objek status
     */
    public InvoiceStatus getInvoiceStatus() {
        return this.status;   
    }
    
    /**
     * setId untuk menggantikan nilai dari property id
     * 
     * @param id, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * setId untuk menggantikan nilai dari property idJob
     * 
     * @param idJob, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setIdJobs(int idJob) {
        this.idJob = idJob; 
    }
    
    /**
     * setDate untuk menggantikan nilai dari property date
     * 
     * @param date, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * setTotalFee untuk menggantikan nilai dari property totalFee
     * 
     * @param totalFee, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * setJobseeker untuk menggantikan nilai dari property pada objek jobseeker
     * 
     * @param jobseeker, property yang nilainya akan digantikan, dengan tipe Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    
    /**
     * setPaymentType untuk menggantikan nilai dari property pada objek paymentType
     * 
     * @param paymentType, property yang nilainya akan digantikan, dengan tipe PaymentType
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    
    /**
     * setInvoiceStatus untuk menggantikan nilai dari property pada objek invoiceStatus
     * 
     * @param status, property yang nilainya akan digantikan, dengan tipe status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.status = status;
    }
    
    /**
     * printData digunakan untuk menampilkan berbagai parameter
     */
    public void printData() {
        System.out.println("===================== Invoice =====================");
        System.out.println("ID: " + id);
        System.out.println("ID Job: " + idJob);
        System.out.println("Date: " + date);
        System.out.println("Seeker: " + jobseeker.getName());
        System.out.println("Fee: " + totalFee);
        System.out.println("Status: " + status);
    }
}
