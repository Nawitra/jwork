package vernandowijayaputra.jwork;

/**
 * Class yang menangani detail dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Job
{
    private int id = 0, fee = 0;
    private String name = "";
    private Recruiter recruiter;
    private JobCategory category;
    
    public Job(int id, int fee, String name, Recruiter recruiter, JobCategory category) {
        this.id = id;
        this.fee = fee;
        this.name = name;
        this.category = category;
        this.recruiter = recruiter;
        this.category = category;
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
     * getName untuk mendapatkan nilai dari property name
     *
     * @return nilai dari property name
     */
    public String getName() {
        return name;
    }
    
    /**
     * getFee untuk mendapatkan nilai dari property fee
     *
     * @return nilai dari property fee
     */
    public int getFee() {
        return fee;
    }
    
    /**
     * getCategory untuk mendapatkan nilai dari property category
     *
     * @return nilai dari objek category
     */
    public JobCategory getCategory() {
        return category;
    }
    
    /**
     * getCategory untuk mendapatkan nilai dari objek recruiter
     *
     * @return nilai dari objek recruiter
     */
    public Recruiter getRecruiter() {
        return recruiter;   
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
     * setName untuk menggantikan nilai dari property name
     * 
     * @param name, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setName(String name) {
        this.name = name;
    }
        
    /**
     * setFee untuk menggantikan nilai dari property fee
     * 
     * @param fee, property yang nilainya akan digantikan, dengan tipe Int
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
    
    /**
     * setCategory untuk menggantikan nilai dari property category
     * 
     * @param category, property yang nilainya akan digantikan, dengan tipe JobCategory
     */
    public void setCategory(JobCategory category) {
        this.category = category;
    }
    
    /**
     * setRecruiter untuk menggantikan nilai dari property pada objek recruiter
     * 
     * @param recruiter, property yang nilainya akan digantikan, dengan tipe Recruiter
     */
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
    
    /**
     * toString() mengembalikan nilai
     */
    public String toString() {
        return "Id = " + getId() + "\nName = " + getName() + "\nRecruiter = " + getRecruiter() +
                "\nFee = " + getFee() + "\nCity = " + getRecruiter().getLocation().getCity()
                + "\nCategory" + getCategory();
    }
}
