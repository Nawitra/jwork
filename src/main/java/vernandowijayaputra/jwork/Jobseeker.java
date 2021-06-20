package vernandowijayaputra.jwork;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.*;  

/**
 * Class yang menangani detail dari pencari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class Jobseeker
{
    private int id = 0;
    private String name = "", email = "", password = "";
    
    public Calendar joinDate;
    
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate){
        this.id = id;
        this.name = name;
        this.email = email;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    public Jobseeker(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
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
     * getPassword untuk mendapatkan nilai dari property password
     *
     * @return nilai dari property password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * getJoinDate untuk mendapatkan nilai dari property joinDate
     *
     * @return nilai dari property joinDate
     */
    public Calendar getJoinDate() {
        return joinDate;
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
        String regex = "^[^.][a-zA-Z0-9&*_~]+([.{1}]?[a-z]+)+@[^-][a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            this.email = email;    
        } else {
            this.email = "";    
        }
    }
    
    /**
     * setPassword untuk menggantikan nilai dari property password
     * 
     * @param password, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            this.password = password;    
        } else {
            this.password = "";    
        }
    }

    /**
     * setJoinDate untuk menggantikan nilai dari property joinDate
     * 
     * @param joinDate, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }
    
    /**
     * setJoinDate untuk menggantikan nilai dari property joinDate
     * 
     * @param year sebagai variable yang menyimpan tahun
     * @param month sebagai variable yang menyimpan bulan
     * @param dayOfMonth sebagai variable yang menyimpan hari
     */
    public void setJoinDate(int year, int month, int dayOfMonth) {
        this.joinDate.set(Calendar.YEAR, year);
        this.joinDate.set(Calendar.MONTH, month-1);
        this.joinDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
    }
    
    /**
     * toString() untuk mengembalikan nilai berbagai property
     */
    @Override
    public String toString() {
        if(joinDate == null) {
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = " + getPassword() + "\nJoin Date = ";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy"); 
            String formattedDate = dateFormat.format(getJoinDate().getTime());
            return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = " + getPassword() + "\nJoin Date = " + formattedDate;
        }
    }
    
}
