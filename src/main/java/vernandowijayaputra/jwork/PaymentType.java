package vernandowijayaputra.jwork;

/**
 * Enum yang menampung tipe-tipe pembayaran
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public enum PaymentType
{
    BankPayment("BankPayment"), 
    EwalletPayment("E-Wallet payment");
    
    private String payment;

    /**
     * Method yang digunakan untuk menggantikan payment
     *
     * @param payment sebagai payment baru untuk menggantikan payment lama
     */
    private PaymentType(String payment) {
        this.payment = payment;
    }

    /**
     * Method yang digunakan untuk mengembalikan nilai payment dalam bentuk string
     *
     * @return payment
     */
    @Override
    public String toString() {
        return payment;   
    }
    
    public static void main(String[] args) {
        PaymentType bank = PaymentType.BankPayment;
        PaymentType ewallet = PaymentType.EwalletPayment;
        System.out.println(bank);
        System.out.println(ewallet);
    }
}
