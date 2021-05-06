
/**
 * Write a description of class Bonus here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */
public class Bonus
{
    private int id, extraFee, minTotalFee;
    private String referralCode;
    private boolean active;
    
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active) {
        this.id = id;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.referralCode = referralCode;
        this.active = active;
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
     * getReferralCode untuk mendapatkan nilai dari property referralCode
     *
     * @return nilai dari property referralCode
     */
    public String getReferralCode() {
        return referralCode;
    }
    
    /**
     * getExtraFee untuk mendapatkan nilai dari property extraFee
     *
     * @return nilai dari property extraFee
     */
    public int getExtraFee() {
        return extraFee;
    }
    
    /**
     * getMinTotalFee untuk mendapatkan nilai dari property minTotalFee
     *
     * @return nilai dari property minTotalFee
     */
    public int getMinTotalFee() {
        return minTotalFee;
    }
    
    /**
     * getActive untuk mendapatkan nilai dari property active
     *
     * @return nilai dari property active
     */
    public boolean getActive() {
        return active;
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
     * setReferralCode untuk menggantikan nilai dari property referralCode
     * 
     * @param referralCode, property yang nilainya akan digantikan, dengan tipe String
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
    
    /**
     * setExtraFee untuk menggantikan nilai dari property extraFee
     * 
     * @param extraFee, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }
    
    /**
     * setMinTotalFee untuk menggantikan nilai dari property minTotalFee
     * 
     * @param minTotalFee, property yang nilainya akan digantikan, dengan tipe int
     */
    public void setMinTotalFee(int minTotalFee) {
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * setActive untuk menggantikan nilai dari property active
     * 
     * @param active, property yang nilainya akan digantikan, dengan tipe boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
    /**
     * printData digunakan untuk menampilkan berbagai parameter
     */
    public String toString() {
        return "Id = " + getId() + "\nReferral Code = " + getReferralCode() + "\nExtra Fee = " + getExtraFee() + "\nMin Total Fee = " + getMinTotalFee() + "\nActive Status: " + getActive();
    };

}
