/**
 * Class yang menangani detail dari informasi tagihan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public abstract class Invoice
{
    protected int totalFee;
    private int id;
    private String date;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    private Job job;
    
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * getId untuk mendapatkan nilai dari property id
     *
     * @return nilai dari property id
     */
    public int getId() {
        return id;
    }

    /**
     * getId untuk mendapatkan nilai dari property date
     *
     * @return nilai dari property date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * getTotalFee untuk mendapatkan nilai dari property totalFee
     *
     * @return nilai dari property totalFee
     */
    public int getTotalFee() {
        return totalFee;
    }
    
    /**
     * getJobseeker untuk mendapatkan nilai dari objek jobseeker
     *
     * @return nilai dari objek jobseeker
     */
    public Jobseeker getJobseeker() {
        return jobseeker;   
    }
    
    /**
     * getPaymentType untuk mendapatkan nilai dari objek paymentType
     *
     * @return nilai dari objek paymentType
     */
    public abstract PaymentType getPaymentType();

    /**
     * getJob untuk mendapatkan nilai dari objek job
     *
     * @return nilai dari objek job
     */
    public Job getJob() {
        return job;   
    }
    
    /**
     * getInvoiceStatus untuk mendapatkan nilai dari objek invoiceStatus
     *
     * @return nilai dari objek status
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;   
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
     * setJob untuk menggantikan nilai dari property pada objek Job
     * 
     * @param job, property yang nilainya akan digantikan, dengan tipe job
     */
    public void setJob(Job job) {
        this.job = job;
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
    public abstract void setTotalFee();

    /**
     * setJobseeker untuk menggantikan nilai dari property pada objek jobseeker
     * 
     * @param jobseeker, property yang nilainya akan digantikan, dengan tipe Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker) {
        this.jobseeker = jobseeker;
    }
    
    /**
     * setInvoiceStatus untuk menggantikan nilai dari property pada objek invoiceStatus
     * 
     * @param status, property yang nilainya akan digantikan, dengan tipe status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * printData digunakan untuk menampilkan berbagai parameter
     */
    public abstract void printData();
}
