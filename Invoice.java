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
    
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker) {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
     * getId untuk mendapatkan nilai dari objek jobseeker
     *
     * @return nilai dari objek jobseeker
     */
    public Jobseeker getJobseeker() {
        return this.jobseeker;   
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
     * printData tidak digunakan untuk apa-apa untuk saat ini.
     */
    public void printData() {
        System.out.println(getTotalFee());
    }
}
