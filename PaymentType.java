
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public enum PaymentType
{
    BankPayment, EwalletPayment;
    
    public String toString() {
        switch(this) {
            case BankPayment:
                return "BankPayment";
            case EwalletPayment:
                return "E-Wallet payment";
            default:
                return null;
        }
    }
}
