/**
 * Class yang menangani detail dari perekrut
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Recruiter
{
    private int id = 0;
    private String name = "", email = "", phoneNumber = "";
    private Location location;
    
    public Recruiter(int id, String name, String email, String phoneNumber, Location location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public Location getLocation() {
        return this.location;   
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setLocation(Location location) {
        this.location = location;    
    }
    
    public void printData() {
        System.out.println(getName());
    }
}
