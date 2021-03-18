/**
 * Class yang menangani detail dari pencari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Jobseeker
{
    private int id = 0;
    private String name = "", email = "", password = "", joinDate = "";
    
    public Jobseeker(int id, String name, String email, String password, String joinDate){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
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
     * getName untuk mendapatkan nilai dari property name
     *
     * @return nilai dari property name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * getEmail untuk mendapatkan nilai dari property email
     *
     * @return nilai dari property email
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * getPassword untuk mendapatkan nilai dari property password
     *
     * @return nilai dari property password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * getJoinDate untuk mendapatkan nilai dari property joinDate
     *
     * @return nilai dari property joinDate
     */
    public String getJoinDate() {
        return this.joinDate;
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
     * setEmail untuk menggantikan nilai dari property email
     * 
     * @param email, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * setPassword untuk menggantikan nilai dari property password
     * 
     * @param password, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * setJoinDate untuk menggantikan nilai dari property joinDate
     * 
     * @param joinDate, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    
    /**
     * printData untuk menampilkan nilai dari property name
     */
    public void printData() {
        System.out.println(getName());
    }
    
}
