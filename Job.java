/**
 * Class yang menangani detail dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021-03-18
 */
public class Job
{
    private int id = 0, fee = 0;
    private String name = "", category = "";
    private Recruiter recruiter;
    
    public Job(int id, int fee, String name, String category, Recruiter recruiter) {
        this.id = id;
        this.fee = fee;
        this.name = name;
        this.category = category;
        this.recruiter = recruiter;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getFee() {
        return this.fee;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public Recruiter getRecruiter() {
        return this.recruiter;   
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
        
    public void setFee(int fee) {
        this.fee = fee;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
    
    public void printData() {}
}
