/**
 * Class yang menangani lokasi dari perekrut
 *
 * @author Vernando Wijaya Putra
 * @version 2021-03-18
 */
public class Location
{
    private String province = "", city = "", description = "";

    public Location(String province, String city, String description) {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    public String getProvince() {
        return this.province;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getDescription() {
        return this.description;    
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setDescription(String description) {
        this.description = description;    
    }
    
    public void printData() {
        System.out.println(getProvince());
    }
}
