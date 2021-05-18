package vernandowijayaputra.jwork;

/**
 * Class yang menangani lokasi dari perekrut
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Location
{
    private String province = "", city = "", description = "";

    public Location(String province, String city, String description) {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * getProvince untuk mendapatkan nilai dari property province
     *
     * @return nilai dari property province
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * getCity untuk mendapatkan nilai dari property city
     *
     * @return nilai dari property city
     */
    public String getCity() {
        return city;
    }

    /**
     * getDescription untuk mendapatkan nilai dari property description
     *
     * @return nilai dari property description
     */
    public String getDescription() {
        return description;    
    }
    
    /**
     * setProvince untuk menggantikan nilai dari property province
     * 
     * @param province, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * setCity untuk menggantikan nilai dari property city
     * 
     * @param city, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * setDescription untuk menggantikan nilai dari property description
     * 
     * @param description, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setDescription(String description) {
        this.description = description;    
    }
    
    /**
     * toString() mengembalikan nilai
     */
    public String toString() {
        return "\nProvince = " + getProvince() + "\nCity = " + getCity() + "\nDescription = " + getDescription();
    }
}
