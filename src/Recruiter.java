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
     * getEmail untuk mendapatkan nilai dari property email
     *
     * @return nilai dari property email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * getPhoneNumber untuk mendapatkan nilai dari property phoneNumber
     *
     * @return nilai dari property phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * getLocation untuk mendapatkan nilai dari objek location
     *
     * @return nilai dari objek location
     */
    public Location getLocation() {
        return location;   
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
     * setEmail untuk menggantikan nilai dari property email
     * 
     * @param email, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setEmail(String email) {
        this.email = email;
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
     * setPhoneNumber untuk menggantikan nilai dari property phoneNumber
     * 
     * @param phoneNumber, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * setLocation untuk menggantikan nilai dari property pada objek location
     * 
     * @param location, property yang nilainya akan digantikan, dengan tipe Location
     */
    public void setLocation(Location location) {
        this.location = location;    
    }
    
    /**
     * toString() mengembalikan nilai
     */
    public String toString() {
        return "Id = " + getId() + "Name = " + getName() + "Phone Number = " + getPhoneNumber() + "Location = " + getLocation();
    }
}
